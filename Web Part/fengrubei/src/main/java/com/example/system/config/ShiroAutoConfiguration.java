package com.example.system.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.system.realm.UserRealm;

/**
 * 
 * @author LJH
 *
 */
@Configuration
//@ConditionalOnWebApplication(type = Type.SERVLET)
//@ConditionalOnClass(value = { SecurityManager.class })
//@ConfigurationProperties(prefix = "shiro")
//@Data
public class ShiroAutoConfiguration {

	private static final String SHIRO_DIALECT = "shiroDialect";
	private static final String SHIRO_FILTER = "shiroFilter";
	private String hashAlgorithmName = "md5";// 加密方式
	private int hashIterations = 1;// 散列次数,这里的配置是起作用的，默认为1次

	private String[] anonUrls;
	private String[] authcUlrs;

	private String loginUrl = "/index.html";// 默认的登陆页面
	private String logOutUrl;
	private String unauthorizedUrl;
	/**
	 * 声明凭证匹配器
	 */
	@Bean("credentialsMatcher")
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
		credentialsMatcher.setHashAlgorithmName(hashAlgorithmName);
		credentialsMatcher.setHashIterations(hashIterations);
		return credentialsMatcher;
	}

	/**
	 * 声明userRealm
	 */
	@Bean("userRealm")
	public UserRealm userRealm(@Qualifier("credentialsMatcher") CredentialsMatcher credentialsMatcher) {
		UserRealm userRealm = new UserRealm();
		// 注入凭证匹配器
		userRealm.setCredentialsMatcher(credentialsMatcher);
		return userRealm;
	}

	/**
	 * 配置SecurityManager
	 */
	@Bean("securityManager")
	public SecurityManager securityManager(@Qualifier("userRealm") UserRealm userRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 注入userRealm
		securityManager.setRealm(userRealm);
		return securityManager;
	}

	/**
	 * 配置shiro的过滤器
	 */
	@Bean(SHIRO_FILTER)
	public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager) {
		ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
		// 设置安全管理器
		factoryBean.setSecurityManager(securityManager);
		// 设置未登陆的时要跳转的页面
		// 未通过认证自动跳转的页面
		factoryBean.setLoginUrl(loginUrl);
		// 未授权后的自动跳转页面
		factoryBean.setUnauthorizedUrl(unauthorizedUrl);
		//anon  不拦截
		//authc 通过认证即放行
		//user  remember me功能
		//perms 资源权限 perms[user:add]
		//role  角色权限
		//匹配规则为第一匹配，
		Map<String, String> filterChainDefinitionMap = new HashMap<>();
		// 设置放行的路径
		if (anonUrls != null && anonUrls.length > 0) {
			for (String anon : anonUrls) {
				filterChainDefinitionMap.put(anon, "anon");
			}
		}
		// 设置登出的路径
		if (null != logOutUrl) {
			filterChainDefinitionMap.put(logOutUrl, "logout");
		}
		// 设置拦截的路径
		if (authcUlrs != null && authcUlrs.length > 0) {
			for (String authc : authcUlrs) {
				filterChainDefinitionMap.put(authc, "authc");
			}
		}
		Map<String, Filter> filters=new HashMap<>();
//		filters.put("authc", new ShiroLoginFilter());
		//配置过滤器
		factoryBean.setFilters(filters);
		factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return factoryBean;
	}

	/**
	 * 注册shiro的委托过滤器，相当于之前在web.xml里面配置的
	 * 
	 * @return
	 */
//	@Bean
//	public FilterRegistrationBean<DelegatingFilterProxy> delegatingFilterProxy() {
//		FilterRegistrationBean<DelegatingFilterProxy> filterRegistrationBean = new FilterRegistrationBean<DelegatingFilterProxy>();
//		DelegatingFilterProxy proxy = new DelegatingFilterProxy();
//		proxy.setTargetFilterLifecycle(true);
//		proxy.setTargetBeanName(SHIRO_FILTER);
//		filterRegistrationBean.setFilter(proxy);
//		return filterRegistrationBean;
//	}

	/* 加入注解的使用，不加入这个注解不生效--开始 */
	/**
	 * 
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}
	/* 加入注解的使用，不加入这个注解不生效--结束 */

	/**
	 * 这里是为了能在html页面引用shiro标签，上面两个函数必须添加，不然会报错
	 * 
	 * @return
	 */
	@Bean(name = SHIRO_DIALECT)
	public ShiroDialect shiroDialect() {
		return new ShiroDialect();
	}
}
