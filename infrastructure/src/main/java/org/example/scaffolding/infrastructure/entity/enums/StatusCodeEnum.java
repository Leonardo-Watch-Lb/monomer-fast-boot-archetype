package org.example.scaffolding.infrastructure.entity.enums;

/**
 * @author Leonardo
 * @creatTime 2023/3/13 23:59
 */
public enum StatusCodeEnum {

    SUCCESS(1001, "SUCCESS", "成功"),
    FAIL(2001, "COMMON_FAIL", "失败"),
    UNKNOW_FAIL(2002, "UNKNOW_FAIL", "未知异常失败")
    ;

    /**
     * 状态码
     */
    public int code;

    /**
     * 状态码名称
     */
    public String name;

    /**
     * 说明
     */
    public String desc;

    StatusCodeEnum(int code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }
}
