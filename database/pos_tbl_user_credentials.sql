
  CREATE TABLE "SCOTT"."POS_TBL_USER_CREDENTIALS" 
   (	"USERID" VARCHAR2(6 BYTE) NOT NULL ENABLE, 
	"LOGINSTATUS" NUMBER(1,0), 
	"PASSWORD" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"USERTYPE" VARCHAR2(15 BYTE), 
	 CONSTRAINT "POS_TBL_USER_CREDENTIALS_CHK1" CHECK (Usertype in ('A','C')) ENABLE, 
	 CONSTRAINT "POS_TBL_USER_CREDENTIALS_CHK2" CHECK (Loginstatus in (1,0)) ENABLE, 
	 CONSTRAINT "POS_TBL_USER_CREDENTIALS_PK" PRIMARY KEY ("USERID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
 
