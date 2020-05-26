package com.example.system.utils.common.JSON;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @Title: JSONResult.java
 * @Package com.system.utils
 * @Description: 自定义响应数据结构
 * 				本类可提供给 H5/ios/安卓/公众号/小程序 使用
 * 				前端接受此类数据（json object)后，可自行根据业务去实现相关功能
 * 
 * 				200：表示成功
 * 				500：表示错误，错误信息在msg字段中
 * 				501：bean验证错误，不管多少个错误都以map形式返回
 * 				502：拦截器拦截到用户token出错
 * 			    503：登陆用户名或密码错误
 * 			    504：登录验证码错误
 * 			    505：添加异常
 * 			    506：删除异常
 * 			    507：修改异常
 * 			    508：重置异常
 * 			    509：分配异常
 * 				555：异常抛出信息
 * 				556: 用户qq校验异常
 * @Copyright: Copyright (c) 2020
 * @Company: 
 * @author 慕课网 - 风间影月
 * @version V1.0
 */
public class JSONResult {

    // 响应业务状态
    private Integer code;

    // 响应消息
    private String msg;

    //分页总页数
    private Long count = 0L;

    // 响应中的数据
    private Object data;

//    // 定义jackson对象
//    private static final ObjectMapper MAPPER = new ObjectMapper();


    @JsonIgnore
    private String ok;	// 不使用

    public static JSONResult build(Integer code, String msg, Object data) {
        return new JSONResult(code, msg, data);
    }

    public static JSONResult build(Integer code, String msg, Object data, String ok) {
        return new JSONResult(code, msg, data, ok);
    }

    public static JSONResult ok(Long count, Object data) {
        return new JSONResult(count,data);
    }

    public static JSONResult ok(Object data) {
        return new JSONResult(data);
    }

    public static JSONResult ok() {
        return new JSONResult(null);
    }
    
    public static JSONResult errorMsg(String msg) {
        return new JSONResult(500, msg, null);
    }
    
    public static JSONResult error501(Object data) {
        return new JSONResult(501, "error", data);
    }
    
    public static JSONResult error502(String msg) {
        return new JSONResult(502, msg, null);
    }

    public static JSONResult errorUrmOrPwdWrong() {
        return new JSONResult(503, "登陆用户名或密码错误", null);
    }
    public static JSONResult errorVerCode() {
        return new JSONResult(504, "验证码错误", null);
    }
    public static JSONResult errorAdd() {
        return new JSONResult(505, "添加异常", null);
    }
    public static JSONResult errorDelete() {
        return new JSONResult(506, "删除异常", null);
    }
    public static JSONResult errorUpdate() {
        return new JSONResult(507, "修改异常", null);
    }
    public static JSONResult errorReset() {
        return new JSONResult(508, "重置异常", null);
    }
    public static JSONResult errorDispatch() {
        return new JSONResult(509, "分配异常", null);
    }
    public static JSONResult error555(String msg) {
        return new JSONResult(555, msg, null);
    }
    
    public static JSONResult error556(String msg) {
        return new JSONResult(556, msg, null);
    }

    public JSONResult() {

    }

    public JSONResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    
    public JSONResult(Integer code, String msg, Object data, String ok) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.ok = ok;
    }
    public JSONResult(Long count,Object data) {
        this.count = count;
        this.code = 200;
        this.msg = "OK";
        this.data = data;
    }


    public JSONResult(Object data) {
        this.code = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.code == 200;
    }



    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}

	public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
