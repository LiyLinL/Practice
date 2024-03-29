CREATE TABLE QUARTZ_TASK_INFORMATIONS (
  "ID" BIGINT NOT NULL primary key GENERATED BY DEFAULT AS IDENTITY,
  "TASK_NO" NVARCHAR(64) NOT NULL COMMENT '任务编号',
  "TASK_NAME" NVARCHAR(64) NOT NULL COMMENT '任务名称',
  "CLASS_NAME" NVARCHAR(100) NOT NULL COMMENT 'CLASS',
  "EXECUTE_PARAMETER" NVARCHAR(2000) DEFAULT NULL COMMENT '执行参数',
  "SCHEDULER_RULE" NVARCHAR(64) NOT NULL COMMENT '定时规则表达式',
  "FROZEN_STATUS" NVARCHAR(16) NOT NULL COMMENT '冻结状态',
  "FROZEN_TIME" TIMESTAMP DEFAULT NULL COMMENT '冻结时间',
  "UNFROZEN_TIME" TIMESTAMP DEFAULT NULL COMMENT '解冻时间',
  "CREATE_TIME" TIMESTAMP DEFAULT NULL COMMENT '创建时间',
  "LAST_MODIFY_TIME" TIMESTAMP DEFAULT NULL COMMENT '最近修改时间'
)

CREATE TABLE QUARTZ_TASK_RECORDS (
  "ID" BIGINT NOT NULL primary key GENERATED BY DEFAULT AS IDENTITY,
  "TASK_NO" NVARCHAR(64) NOT NULL COMMENT '任务编号',
  "TIME_KEY_VALUE" NVARCHAR(32) DEFAULT NULL COMMENT '执行时间格式值',
  "EXECUTE_TIME" TIMESTAMP NOT NULL COMMENT '执行时间',
  "TASK_STATUS" NVARCHAR(16) NOT NULL COMMENT '任务状态',
  "FAIL_COUNT" INT DEFAULT NULL COMMENT '失败统计数',
  "FAIL_REASON" NVARCHAR(64) DEFAULT NULL COMMENT '失败错误描述',
  "CREATE_TIME" TIMESTAMP DEFAULT NULL COMMENT '创建时间',
  "LAST_MODIFY_TIME" TIMESTAMP DEFAULT NULL COMMENT '最近修改时间'
)

CREATE TABLE QUARTZ_TASK_ERRORS (
  "ID" BIGINT NOT NULL primary key GENERATED BY DEFAULT AS IDENTITY,
  "TASK_EXECUTE_RECORDID" NVARCHAR(64) NOT NULL COMMENT '任务执行记录ID',
  "ERROR_KEY" NVARCHAR(1024) NOT NULL COMMENT '信息关键字',
  "ERROR_VALUE" CLOB COMMENT '信息内容',
  "CREATE_TIME" TIMESTAMP NOT NULL COMMENT '创建时间',
  "LAST_MODIFY_TIME" TIMESTAMP DEFAULT NULL COMMENT '最近修改时间'

)