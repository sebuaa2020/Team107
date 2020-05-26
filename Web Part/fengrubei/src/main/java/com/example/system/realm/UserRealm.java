package com.example.system.realm;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.system.entity.User;
import com.example.system.service.impl.UserServiceImpl;
import com.example.system.utils.common.ActiveUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /*
    授权、每次请求都会调用
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        ActiveUser activeUser = (ActiveUser) principal.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        if(activeUser.getRoles() != null && activeUser.getRoles().size()>0){
            info.addRoles(activeUser.getRoles());
        }

        if(activeUser.getPermissions() != null && activeUser.getPermissions().size()>0){
            info.addStringPermissions(activeUser.getPermissions());
        }



        return info;
    }

    /*
    认证、只执行一次
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //token.getPrincipal()  身份相当于用户名
        //token.getCredentials() 密码
        if(token == null){
            System.out.println("token为空");
        }
        System.out.println("realm读到前端的用户名:   " + token.getPrincipal().toString());
        System.out.println("realm读到前端的密码:   " + new String((char[])token.getCredentials()));
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loginname", token.getPrincipal().toString());
        User user = userService.getOne(queryWrapper);
        System.out.println("realm数据库密码:   " + user.getPwd());
//加密两次的方法我实在是写不出来了，后头问问学长吧


        if(user != null){
            ActiveUser activeUser = new ActiveUser();//这个地方要加权限的！！！
            activeUser.setUser(user);
//            ByteSource credentialsSalt = ByteSource.Util.bytes("");
//            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activeUser,usertable.getPwd(),credentialsSalt,this.getName());

            String password = new String((char[])token.getCredentials());
            try {
                //password = usertable.getPwd();
                //password =new Md5Hash(password).toString();
                //password =new Md5Hash(password).toHex();
                //password =new Md5Hash(password,salt).toHex();
                //password = MD5Utils.getMD5Str(password);
                System.out.println(password);
                System.out.println("e10adc3949ba59abbe56e057f20f883e");
                System.out.println("14e1b600b1fd579f47433b88e8d85291");
            } catch (Exception e) {
                e.printStackTrace();
            }

            //SimpleAccount info = new SimpleAccount(activeUser,usertable.getPwd(),this.getName());
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activeUser,user.getPwd(),this.getName());
            return info;
        }
        else{
            return null;
        }



    }
}
