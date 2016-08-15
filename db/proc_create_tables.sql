#========================= 元信息表 ======================================
# province   city   invest_phase  invest_field project_phase
#========================================================================
CREATE TABLE IF NOT EXISTS `province` (
  `province_id`   INTEGER UNSIGNED PRIMARY KEY
  COMMENT '省份ID',
  `province_name` VARCHAR(50) NOT NULL
  COMMENT '省份名字'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `city` (
  `city_id`     INTEGER UNSIGNED PRIMARY KEY
  COMMENT '城市ID',
  `city_name`   VARCHAR(60)      NOT NULL
  COMMENT '城市名字',
  `province_id` INTEGER UNSIGNED NOT NULL
  COMMENT '所属省份CODE',

  FOREIGN KEY (`province_id`) REFERENCES `province` (`province_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `invest_phase` (
  `phase_id`   TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `phase_name` VARCHAR(20) NOT NULL
  COMMENT '阶段名称'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `invest_field` (
  `field_id`   TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `field_name` VARCHAR(20) NOT NULL
  COMMENT '领域名称',
  `field_type` VARCHAR(20) NOT NULL
  COMMENT '领域大类',

  UNIQUE KEY (`field_name`, `field_type`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `invest_member_level` (
  `id`       INTEGER PRIMARY KEY AUTO_INCREMENT,
  `level`    VARCHAR(30) NOT NULL,
  `position` VARCHAR(30) NOT NULL,

  UNIQUE KEY (`level`, `position`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

#====================用户信息表 ========================================
CREATE TABLE IF NOT EXISTS `user_info` (
  `user_id`     BIGINT UNSIGNED PRIMARY KEY  AUTO_INCREMENT
  COMMENT '用户ID',

  `name`        VARCHAR(100) NOT NULL UNIQUE
  COMMENT '用户名',
  `email`       VARCHAR(60)  NOT NULL UNIQUE DEFAULT ''
  COMMENT '邮箱',
  `mobile`      VARCHAR(20)  NOT NULL UNIQUE DEFAULT ''
  COMMENT '手机号码',
  `password`    VARCHAR(150) NOT NULL
  COMMENT '密码',
  `user_type`   TINYINT      NOT NULL
  COMMENT '用户类型: 1==>investor; 2==>institution; 3==>project',

  `create_time` TIMESTAMP    NOT NULL        DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP    NOT NULL        DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

#===============================机构相关表 ======================================================
# institution_info  institution_member  institution_case  institution_phase  institution_field
#===============================================================================================
CREATE TABLE IF NOT EXISTS `institution_info` (
  `institution_id`    BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '机构ID',
  `user_id`           BIGINT(20) UNSIGNED          DEFAULT NULL
  COMMENT '用户ID',
  `institution_name`  VARCHAR(60)                  DEFAULT ''
  COMMENT '机构名称',
  `institution_level` TINYINT(4)                   DEFAULT '0'
  COMMENT '机构评级 1 ==> 正科; 2==>副处; ... 7==>正部',
  `fund_number`       DOUBLE                       DEFAULT '0'
  COMMENT '基金规模',
  `fund_unit`         VARCHAR(15)                  DEFAULT ''
  COMMENT '基金单位（万元，万美元，亿元，亿美元）',
  `staff_size`        VARCHAR(60)                  DEFAULT ''
  COMMENT '人员规模',
  `status`            VARCHAR(500)                 DEFAULT ''
  COMMENT '地位',
  `business`          VARCHAR(500)                 DEFAULT ''
  COMMENT '业务',
  `first_fields`      VARCHAR(500)                 DEFAULT ''
  COMMENT '一级行业',
  `web_logo`          VARCHAR(200)                 DEFAULT ''
  COMMENT '机构Web Logo',
  `mobile_logo`       VARCHAR(200)                 DEFAULT ''
  COMMENT '机构Mobile Logo',
  `province`          VARCHAR(30)                  DEFAULT ''
  COMMENT '机构总部所在省',
  `city`              VARCHAR(40)                  DEFAULT ''
  COMMENT '机构所在市',
  `address`           VARCHAR(500)                 DEFAULT ''
  COMMENT '地址',
  `achievement`       VARCHAR(600)                 DEFAULT ''
  COMMENT '机构的成就与荣誉',
  `institution_intro` VARCHAR(1000)                DEFAULT ''
  COMMENT '机构简介',
  `create_time`       TIMESTAMP           NULL     DEFAULT CURRENT_TIMESTAMP,
  `update_time`       TIMESTAMP           NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`institution_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `institution_info_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

#==========================投资人相关表 =================================================
# investor_info investor_phase  investor_field  investor_case
#=======================================================================================
CREATE TABLE `investor_info` (
  `investor_id`       BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '投资人ID',
  `user_id`           BIGINT(20) UNSIGNED          DEFAULT NULL,
  `investor_name`     VARCHAR(30)                  DEFAULT ''
  COMMENT '投资人名字',
  `investor_level`    TINYINT(4)                   DEFAULT '0'
  COMMENT '投资人评级',
  `birth_year`        VARCHAR(10)                  DEFAULT ''
  COMMENT '投资人出生年份',
  `native_province`   VARCHAR(60)                  DEFAULT ''
  COMMENT '投资人籍贯省',
  `native_district`   VARCHAR(60)                  DEFAULT ''
  COMMENT '投资人籍贯市',
  `age`               INT(11)                      DEFAULT '1960'
  COMMENT '年龄',
  `gender`            VARCHAR(20)                  DEFAULT ''
  COMMENT '性别',
  `status`            VARCHAR(200)                 DEFAULT ''
  COMMENT '身份',
  `achievement`       VARCHAR(1200)                DEFAULT ''
  COMMENT '成就与荣誉',
  `first_fields`      VARCHAR(500)                 DEFAULT ''
  COMMENT '一级行业',
  `investor_intro`    VARCHAR(1200)                DEFAULT ''
  COMMENT '投资人简介',
  `education`         VARCHAR(500)                 DEFAULT ''
  COMMENT '教育背景',
  `edu_exp`           VARCHAR(1000)                DEFAULT ''
  COMMENT '教育经历',
  `work_exp`          VARCHAR(1200)                DEFAULT ''
  COMMENT '工作经历',
  `institution_name`  VARCHAR(50)                  DEFAULT ''
  COMMENT '所属机构',
  `investor_position` VARCHAR(60)                  DEFAULT ''
  COMMENT '投资人职位',
  `level_type`        TINYINT(4)                   DEFAULT '1'
  COMMENT 'CEO:1,高层:2,精英:3',
  `institution_id`    BIGINT(20) UNSIGNED          DEFAULT '0'
  COMMENT '所属投资机构ID',
  `province`          VARCHAR(40)                  DEFAULT ''
  COMMENT '投资人所在省',
  `city`              VARCHAR(40)                  DEFAULT ''
  COMMENT '投资人所在市',
  `address`           VARCHAR(100)                 DEFAULT ''
  COMMENT '投资人地址',
  `web_portrait`      VARCHAR(1000)                DEFAULT ''
  COMMENT 'Web端投资人头像(以|分隔)',
  `mobile_portrait`   VARCHAR(500)                 DEFAULT ''
  COMMENT '移动端投资人头像',
  `investor_photo`    VARCHAR(10000)               DEFAULT ''
  COMMENT '投资人照片(以|分隔)',
  `create_time`       TIMESTAMP           NULL     DEFAULT CURRENT_TIMESTAMP,
  `update_time`       TIMESTAMP           NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`investor_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `investor_info_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS `follow` (
  `id`          BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `notice_list` BIGINT UNSIGNED NOT NULL
  COMMENT '关注者ID',
  `fans_list`   BIGINT UNSIGNED NOT NULL
  COMMENT '被关注者ID',
  `group_id`    BIGINT UNSIGNED COMMENT '分组',
  `notice_type` TINYINT         NOT NULL
  COMMENT '关注者类型',
  `fans_type`   TINYINT         NOT NULL
  COMMENT '被关注者类型',
  FOREIGN KEY (`notice_list`) REFERENCES `user_info` (`user_id`),
  FOREIGN KEY (`fans_list`) REFERENCES `user_info` (`user_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `user_money_bag` (
  `id`      BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `user_id` BIGINT UNSIGNED  NOT NULL
  COMMENT '钱包所属ID',
  `amount`  INT(64) UNSIGNED NOT NULL
  COMMENT '金额',
  FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS `user_money_bag_detail` (
  `id`               BIGINT UNSIGNED PRIMARY KEY                  AUTO_INCREMENT,
  `user_id`          BIGINT UNSIGNED                     NOT NULL
  COMMENT '钱包所属ID',
  `amount`           INT(64) UNSIGNED                    NOT NULL
  COMMENT '金额',
  `operation_type`   INTEGER DEFAULT 0                   NOT NULL
  COMMENT '操作类型 求指教,投递,钱包',
  `tradeNo`          VARCHAR(64) COMMENT '支付宝交易号',
  `source_device`    INT                                 NOT NULL
  COMMENT '设备 web/mobile(android,IOS)',
  `trade_status`     VARCHAR(20) COMMENT '交易状态',
  `payment_type`     INTEGER DEFAULT 0                   NOT NULL
  COMMENT '支付类型 余额,支付宝',
  `create_date`      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  COMMENT '交易时间',
  `buyer_email`      VARCHAR(100)                                 DEFAULT ''
  COMMENT '买家支付宝账号',
  `buyer_id`         VARCHAR(30)                                  DEFAULT ''
  COMMENT '买家支付宝账户号',
  `notify_id`        VARCHAR(100)                                 DEFAULT ''
  COMMENT '通知校验ID',
  `gmt_payment`      VARCHAR(20)                                  DEFAULT ''
  COMMENT '付款时间',
  `in_out`           BOOLEAN                             NOT NULL DEFAULT 0
  COMMENT '钱包消费还是充值',
  `refund_status`    VARCHAR(20)                                  DEFAULT ''
  COMMENT '退款状态',
  `delivery_to_user` BOOLEAN                                      DEFAULT 0
  COMMENT '是否已经支付成功过',
  `to_user_id`       BIGINT UNSIGNED
  COMMENT '转入的用户ID',
  `from_user_id`     BIGINT UNSIGNED
  COMMENT '来源的用户ID',
  FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `user_money_bag_detail_relative` (
  `id`          BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `ref_id`      BIGINT UNSIGNED  NOT NULL
  COMMENT '钱包所属ID',
  `amount`      INT(64) UNSIGNED NOT NULL
  COMMENT '金额',
  `relative_id` BIGINT UNSIGNED  NOT NULL
  COMMENT '钱包所属ID',

  FOREIGN KEY (`ref_id`) REFERENCES `user_money_bag_detail` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS `request_cash` (
  `id`          BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `user_id`     BIGINT UNSIGNED                     NOT NULL
  COMMENT '关联ID',
  `account`     VARCHAR(100)                        NOT NULL
  COMMENT '提现账号',
  `name`        VARCHAR(100)                        NOT NULL
  COMMENT '名字',
  `amount`      INTEGER                             NOT NULL
  COMMENT '钱数',
  `type`        TINYINT(4)                          NOT NULL
  COMMENT '类型：支付宝 1，银行卡 2',
  `create_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  COMMENT '时间',
  FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE `provinces` (
  `province_id`   INT(10) UNSIGNED NOT NULL
  COMMENT '省份ID',
  `province_name` VARCHAR(50)      NOT NULL
  COMMENT '省份名字',
  PRIMARY KEY (`province_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `cities` (
  `city_id`     INT(10) UNSIGNED NOT NULL
  COMMENT '城市ID',
  `city_name`   VARCHAR(60)      NOT NULL
  COMMENT '城市名字',
  `province_id` INT(10) UNSIGNED NOT NULL
  COMMENT '所属省份CODE',
  PRIMARY KEY (`city_id`),
  KEY `province_id` (`province_id`),
  CONSTRAINT `cities_ibfk_1` FOREIGN KEY (`province_id`) REFERENCES `provinces` (`province_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE `request_for_ranking` (
  `ranking_id` INT(10) UNSIGNED NOT NULL  AUTO_INCREMENT
  COMMENT '排名ID',
  `user_id`    BIGINT           NOT NULL
  COMMENT '省份名字',
  PRIMARY KEY (`ranking_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `sms_verify` (
  `sms_id`      BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,

  `phone`       BIGINT UNSIGNED                     NOT NULL
  COMMENT '手机',
  `code`        INT UNSIGNED                        NOT NULL
  COMMENT '验证码',
  `create_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  COMMENT '时间'

)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS `question` (
  `question_id`        BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,

  `question_content`   VARCHAR(200)                        NOT NULL
  COMMENT '问题内容',
  `question_vioce_url` VARCHAR(100)                        NOT NULL
  COMMENT '问题语音',
  `requestor_id`       BIGINT UNSIGNED                     NOT NULL
  COMMENT '提问者',
  `response_id`        BIGINT UNSIGNED                     NOT NULL
  COMMENT '回答者',
  `reponse_url`        VARCHAR(100)                        NOT NULL
  COMMENT '回答语音',
  `request_amount`     INTEGER                             NOT NULL
  COMMENT '钱数',
  `question_type` TINYINT(4) NOT NULL
    COMMENT '问题类型：1=悬赏; 2=定向',
  `create_date`        TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  COMMENT '提问时间',
  `reponse_date`       TIMESTAMP
  COMMENT '回复时间'

)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;