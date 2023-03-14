-- 基础账号信息表
CREATE TABLE IF NOT EXISTS `account`
(
    id                BIGINT PRIMARY KEY COMMENT '主键id',
    create_time       TIMESTAMP         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    modify_time       TIMESTAMP         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    uid               BIGINT UNIQUE KEY NOT NULL COMMENT '用户id',
    login_account     VARCHAR(32) UNIQUE COMMENT '登录账号',
    login_phone       VARCHAR(32) UNIQUE COMMENT '登录手机号',
    login_email       VARCHAR(128) UNIQUE COMMENT '登录邮箱',
    login_password    VARCHAR(16) COMMENT '登陆密码',
    nick_name         VARCHAR(32)       NOT NULL COMMENT '昵称',
    signature         VARCHAR(64) COMMENT '个性签名',
    gender            TINYINT(1) COMMENT '性别',
    avatar_url        VARCHAR(256) COMMENT '头像地址',
    last_login_time   TIMESTAMP                  DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
    last_login_ip     VARCHAR(64) COMMENT '最后登录ip',
    salt              VARCHAR(32) COMMENT '账号盐值',
    encrypt_algorithm VARCHAR(16) COMMENT '加密算法',
    account_type      VARCHAR(16) COMMENT '账号类型',
    account_status    VARCHAR(16) COMMENT '账号状态'
) ENGINE = InnoDB COMMENT '基础账号信息表';