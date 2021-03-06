/*員工資訊*/
CREATE TABLE ACCOUNT (
    ACCOUNT_NO   CHAR(8)         NOT NULL, /*員工編號*/
    ACCOUNT_PASS   VARCHAR(200)    NOT NULL, /*密碼*/
    ACCOUNT_LOGIN_TIME   timestamp, /*最新登入時間*/
    ACCOUNT_TRY_NO   VARCHAR(2)    NOT NULL, /*嘗試次數*/
    ACCOUNT_PUR   VARCHAR(2)    NOT NULL, /*權限*/

    CONSTRAINT PK_ACCOUNT PRIMARY KEY(ACCOUNT_NO)
);

/*交通費*/
CREATE TABLE TRANSPORT_INFO (
	ACCOUNT_NO CHAR(8) NOT NULL,/*員工編號*/
	TRANSPORT_FARE   VARCHAR(10) NOT NULL,/*交通費金額*/
	TRANSPORT_MONTH VARCHAR(2) NOT NULL, /*上傳月份*/
	TRANSPORT_INSTER_DATE DATE NOT NULL, /*上傳日期 YYYY/MM/DD */
	TRANSPORT_UPDATE_DATE DATE NOT NULL, /*更新日期 YYYY/MM/DD */
	TRANSPORT_PUR VARCHAR(2) NOT NULL, /*0:審核中 1:審核通過 2:審核不可*/
	TRANSPORTATION_IMG BYTEA ,/*交通費照片*/
	/* 預留位置 交通費EXCEL*/

	  CONSTRAINT PK_TRANSPORT_COST PRIMARY KEY (ACCOUNT_NO, TRANSPORT_MONTH),
	  FOREIGN KEY (ACCOUNT_NO) REFERENCES ACCOUNT (ACCOUNT_NO)
);

/*訊息資訊*/
CREATE TABLE MESSAGE_INFO(
	  ACCOUNT_NO VARCHAR (8) NOT NULL ,  /*員工號碼*/
	  MESSAGE_NO VARCHAR (3) NOT NULL ,  /*訊息編號*/
	  MESSAGE_CONTENT VARCHAR (100) NOT NULL ,  /*訊息內容*/
	  MESSAGE_SEND_FLG VARCHAR (1) NOT NULL,  /*1:配信完 0:未配信 */
	  MESSAGE_LEVEL VARCHAR (1) NOT NULL ,  /*0-4 level 0:一般訊息 公司活動資訊等  1:月次訊息 繳交交通費與時數表 2:重要訊息 申請到期/時限將至等  3:未定 4:未定*/
	  MESSAGE_CREATE_TIME timestamp NOT NULL ,  /*訊息創建時間*/
	  MESSAGE_SEND_TIME timestamp ,  /*配信時間*/
	  MESSAGE_CREATE_ACCOUNT VARCHAR (8) NOT NULL ,  /*創建訊息者*/

	  CONSTRAINT PK_MESSAGEINFO PRIMARY KEY (ACCOUNT_NO,MESSAGE_NO, MESSAGE_CONTENT),
	  FOREIGN KEY (ACCOUNT_NO) REFERENCES ACCOUNT (ACCOUNT_NO),
	  FOREIGN KEY (MESSAGE_CREATE_ACCOUNT) REFERENCES ACCOUNT (ACCOUNT_NO)
);

/*暫定*/
CREATE TABLE SYSTEMMESSAGE_INFO(
	  SYSTEMMESSAGEINFO_NO VARCHAR (3) NOT NULL ,  /*訊息編號*/
	  SYSTEMMESSAGEINFO_CONTENT VARCHAR (100) NOT NULL ,  /*訊息內容*/

	  CONSTRAINT PK_SYSTEMMESSAGEINFO PRIMARY KEY (SYSTEMMESSAGEINFO_NO)
);

/*個人基本資料*/
CREATE TABLE PERSONSAL_INFO (
	  ACCOUNT_NO   CHAR(8)         NOT NULL, /*員工編號*/
	  JOBTITLE   VARCHAR(200)    NOT NULL, /*職稱*/
	  BIRTHDAY   TIMESTAMP    NOT NULL, /*生日*/
	  GENDOR   VARCHAR(1)    NOT NULL, /*性別 男M 女 F*/
	  NAME   VARCHAR(200)    NOT NULL, /*姓名*/
	  PHONE_NO   VARCHAR(20)    NOT NULL, /*行動電話*/
	  EMAIL   VARCHAR(200)    NOT NULL, /*電子郵件*/
	  MATE   VARCHAR(1)    NOT NULL, /*配偶有無 Y,N */
	  LIVE_ALONE VARCHAR(1)    NOT NULL, /*獨居 Y,N */
	  NEAR_STATION VARCHAR(200)    NOT NULL, /*最近地鐵*/
	  ADDRESS TEXT    NOT NULL, /*地址*/
	  RESIDENCE_CARD_NO VARCHAR(20) , /*在留卡號碼*/
	  RESIDENCE_DATE_START TIMESTAMP , /*在留卡起日*/
	  RESIDENCE_DATE_END TIMESTAMP , /*在留卡迄日*/
	  BANK_ACCOUNT_NAME VARCHAR(200)   NOT NULL, /*銀行帳戶名稱*/
	  BANK_ACCOUNT_BRANCH VARCHAR(200)   NOT NULL, /*銀行帳戶分行名稱*/
	  BANK_ACCOUNT_NO VARCHAR(20)   NOT NULL, /*銀行帳戶號碼*/
	  PASSPORT_NO VARCHAR(20)   NOT NULL, /*護照號碼*/
	  HIRED_INSURANCE_INSURED_NO  VARCHAR(20) , /*雇用保險被保險者番號*/
	  DEPENDENT_RELATIVE_NAME_1 VARCHAR(200) , /*扶養親屬姓名1*/
	  DEPENDENT_RELATIVE_RELATION_1 VARCHAR(200) , /*扶養親屬關係1*/
	  DEPENDENT_RELATIVE_BIRTHDAY_1 TIMESTAMP , /*扶養親屬生日1*/
	  DEPENDENT_RELATIVE_ADDRESS_1 TEXT , /*扶養親屬住址1*/
	  DEPENDENT_RELATIVE_NAME_2 VARCHAR(200) , /*扶養親屬姓名2*/
	  DEPENDENT_RELATIVE_RELATION_2 VARCHAR(200) , /*扶養親屬關係2*/
	  DEPENDENT_RELATIVE_BIRTHDAY_2 TIMESTAMP , /*扶養親屬生日2*/
	  DEPENDENT_RELATIVE_ADDRESS_2 TEXT , /*扶養親屬住址2*/
	  DEPENDENT_RELATIVE_NAME_3 VARCHAR(200) , /*扶養親屬姓名3*/
	  DEPENDENT_RELATIVE_RELATION_3 VARCHAR(200) , /*扶養親屬關係3*/
	  DEPENDENT_RELATIVE_BIRTHDAY_3 TIMESTAMP , /*扶養親屬生日3*/
	  DEPENDENT_RELATIVE_ADDRESS_3 TEXT , /*扶養親屬住址3*/

	  CONSTRAINT PK_PERSONSAL_INFO PRIMARY KEY (ACCOUNT_NO),
	  FOREIGN KEY (ACCOUNT_NO) REFERENCES ACCOUNT (ACCOUNT_NO)
);

