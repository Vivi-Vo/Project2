-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-08-15 14:19:05.534

-- Table: TestNG
CREATE TABLE TestNG (
    RECORD_ID   NUMBER(10)          not null primary key,
    BATCH_ID    NUMBER(10)          not null,
    INIT_BY     VARCHAR2(40 char)   not null,
    TEST_STATUS VARCHAR2(30 char)   not null,
    SIGNATURE   VARCHAR2(100 char)  not null,
    TEST_NAME   VARCHAR2(100 char)  not null,
    DURATION    NUMBER(10)          not null,
    START_TIME  VARCHAR2(255 char)  not null,
    FINISH_TIME VARCHAR2(255 char)  not null,
    EX_CLASS    VARCHAR2(100 char),
    EX_MESASGE  VARCHAR2(200 char),
    EX_STACK    VARCHAR2(900 char)
    EX_STACK varchar2(900)  NULL,
    CONSTRAINT TestNG_pk PRIMARY KEY (RECORD_ID)
) ;

