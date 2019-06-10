package com.mrbird.api.utils.springMvc;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 返回值基础信息
 *
 * @author chenyao
 * @date 2018/10/26.
 */
public class AbstractResultEnum2 {

    public static final AbstractResultEnum2 COMM_SYSTEM_EXCEPTION = new AbstractResultEnum2(1000, "系统繁忙");

    public static final AbstractResultEnum2 COMM_ILLEGAL_ARGUMENT = new AbstractResultEnum2(1001, "参数错误");

    public static final AbstractResultEnum2 COMM_NOT_FOUND_GROUP_ORGANIZATION = new AbstractResultEnum2(1002, "未找到集团税号配置信息");


    public static final AbstractResultEnum2 COMM_NOT_FOUND_USER = new AbstractResultEnum2(1003, "纳税人识别号或用户名不存在");

    public static final AbstractResultEnum2 COMM_NOT_FOUND_ROLE = new AbstractResultEnum2(1004, "该用户对应的角色不存在");

    public static final AbstractResultEnum2 COMM_NO_VALID_PASSWORD = new AbstractResultEnum2(1005, "用户名或者密码错误");

    public static final AbstractResultEnum2 COMM_NOT_LOGIN = new AbstractResultEnum2(1006, "未登录，请登录");

    public static final AbstractResultEnum2 COMM_NO_VALID_CODE = new AbstractResultEnum2(1007, "验证码错误");

    public static final AbstractResultEnum2 COMM_NO_USER_FORBID = new AbstractResultEnum2(1008, "该账号已被禁用");

    public static final AbstractResultEnum2 COMM_REMOTE_EXCEPTION = new AbstractResultEnum2(1009, "远程调用失败");


    public static final AbstractResultEnum2 COMM_SEND_MQ_ERROR = new AbstractResultEnum2(1100, "发送mq消息失败");
    public static final AbstractResultEnum2 TOKEN_ERROR = new AbstractResultEnum2(1101, "无效token");

    public static final AbstractResultEnum2 COMM_AUTHENTICATION_FAILURE = new AbstractResultEnum2(1401, "登录认证失败");

    public static final AbstractResultEnum2 COMM_ACCESS_DENIED = new AbstractResultEnum2(1403, "无权限");

    public static final AbstractResultEnum2 COMM_NO_Add_FORBID = new AbstractResultEnum2(2010, "数据修改失败");

    public static final AbstractResultEnum2 TAX_IS_NOT_NULL = new AbstractResultEnum2(5000, "税号不允许为空");
    public static final AbstractResultEnum2 ORG_IS_NOT_NULL = new AbstractResultEnum2(5001, "组织机构不允许为空");


    public static final AbstractResultEnum2 NOT_FOUND_DATA = new AbstractResultEnum2(1404, "未找到数据");

    public static final AbstractResultEnum2 COMM_DELETED_DATA = new AbstractResultEnum2(1405, "该数据已被删除，请刷新页面");
    public static final AbstractResultEnum2 ADD_EMP_NOT_ERROR = new AbstractResultEnum2(1406, "新增员工失败，身份证或者姓名重复");
    public static final AbstractResultEnum2 UP_INVOICE_NOT = new AbstractResultEnum2(1407, "此发票已经存在，无法修改");
    public static final AbstractResultEnum2 ADD_EMP_ORGANIZATIONID = new AbstractResultEnum2(1408, "没有权限操作此员工");
    public static final AbstractResultEnum2 ADD_SUPPLIER_DELETE_ERROR = new AbstractResultEnum2(1409, "删除失败,要删除的类别已经被使用");
    public static final AbstractResultEnum2 ADD_SUPPLIER_ERROR = new AbstractResultEnum2(1410, "新增失败，此供应商已经存在对应销方");
    public static final AbstractResultEnum2 ADD_INVOICE_GETBYKEY_ERROR = new AbstractResultEnum2(1411, "不能选择已经转出的票");
    public static final AbstractResultEnum2 ADD_INVOICE_ERROR = new AbstractResultEnum2(1412, "新增失败");
    public static final AbstractResultEnum2 REMOVE_INVOICE_ERROR = new AbstractResultEnum2(1413, "只能选择已经转出的发票");
    public static final AbstractResultEnum2 REMOVE_INVOICE_ERROR_OUT = new AbstractResultEnum2(1414, "删除失败");

    public static final AbstractResultEnum2 CURRENT_GROUP_DATA_NONE = new AbstractResultEnum2(1412, "集团税号未配置数据");

    public static final AbstractResultEnum2 VALID_WEB_API = new AbstractResultEnum2(1413, "请求校验信息不通过");
    public static final AbstractResultEnum2 WEB_API_REQ_PARAM = new AbstractResultEnum2(1414, "请求参数不允许为空");
    public static final AbstractResultEnum2 WEB_API_TOKEN = new AbstractResultEnum2(1415, "token校验不通过");
    public static final AbstractResultEnum2 UNFIND_ORGNIZATION = new AbstractResultEnum2(1416, "用户所属机构不存在");

    public static final AbstractResultEnum2 TAX_NO_NON_ENABLE = new AbstractResultEnum2(1417, "该税号已被禁用");

    public static final AbstractResultEnum2 UNFIND_FILE = new AbstractResultEnum2(1418, "上传文件不存在");
    public static final AbstractResultEnum2 UPFILE_FAIL = new AbstractResultEnum2(1419, "客户端上传图片失败");
    public static final AbstractResultEnum2 UPFILE_NULL = new AbstractResultEnum2(1419, "客户端上传图片不允许为空");
    public static final AbstractResultEnum2 SERVER_NULL = new AbstractResultEnum2(1419, "上传服务器图片不允许为空");

    private final int code;

    private final String message;

    public AbstractResultEnum2(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
