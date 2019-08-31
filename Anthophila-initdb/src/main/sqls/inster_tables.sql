/*員工資訊 測試用*/
/*admin */
INSERT INTO account(ACCOUNT_NO,ACCOUNT_PASS,ACCOUNT_LOGIN_TIME,ACCOUNT_TRY_NO,ACCOUNT_PUR) values('admin','admin',NOW(),'0','A');
/*主管*/
INSERT INTO account(ACCOUNT_NO,ACCOUNT_PASS,ACCOUNT_LOGIN_TIME,ACCOUNT_TRY_NO,ACCOUNT_PUR) values('testM','testM',NOW(),'0','M');
/*員工*/
INSERT INTO account(ACCOUNT_NO,ACCOUNT_PASS,ACCOUNT_LOGIN_TIME,ACCOUNT_TRY_NO,ACCOUNT_PUR) values('testE','testE',NOW(),'0','E');


/*資訊推播 測試用*/
INSERT INTO "public".message( message_no, message_content, message_send_flg, message_level, message_create_time, message_send_time, message_create_no) VALUES (  'admin'  , '測試訊息1'  , '0'  , '0'  , NOW()  , null  , 'admin')