package com.example.system.utils.common;

import com.example.system.utils.common.JSON.JSONResult;

public class ConstantUtils {
    public final static String USER_SESSION_KEY="user";

    public final static String PROJECTS_SESSION_KEY="projects";

    public static final String PERMISSION_TABLE_TYPE = "type";


    /**
     * 菜单权限类型
     */
    public static final String TYPE_MENU = "menu";
    public static final String TYPE_PERMISSION = "permission";
    /**
     * 可以状态
     */
    public static final Integer AVAILABLE_TRUE = 1;
    public static final Integer AVAILABLE_FALSE = 0;

    /**
     * 用户类型
     */
    public static final Integer USER_TYPE_SUPER = 0;
    public static final Integer USER_TYPE_NORMAL = 1;

    /**
     * 展开类型
     */
    public static final Integer OPEN_TRUE = 1;
    public static final Integer OPEN_FALSE = 0;
    
    /**
     * 登陆增删改查状态
     */
    public static final JSONResult LOGIN_SUCCESS = JSONResult.build(200,"登陆成功",null);
    public static final JSONResult LOGIN_ERROR_PASS = JSONResult.errorUrmOrPwdWrong();
    public static final JSONResult LOGIN_ERROR_CODE = JSONResult.errorVerCode();

    public static final JSONResult ADD_SUCCESS = JSONResult.build(200,"添加成功",null);
    public static final JSONResult ADD_ERROR = JSONResult.errorAdd();

    public static final JSONResult DELETE_SUCCESS = JSONResult.build(200,"删除成功",null);
    public static final JSONResult DELETE_ERROR = JSONResult.errorDelete();

    public static final JSONResult UPDATE_SUCCESS = JSONResult.build(200,"更新成功",null);
    public static final JSONResult UPDATE_ERROR = JSONResult.errorUpdate();

    public static final JSONResult RESET_SUCCESS = JSONResult.build(200,"重置成功",null);
    public static final JSONResult RESET_ERROR = JSONResult.errorReset();

    public static final JSONResult DISPATCH_SUCCESS = JSONResult.build(200,"分配成功",null);
    public static final JSONResult DISPATCH_ERROR = JSONResult.errorDispatch();

}
