/*員工資訊 測試用*/
/*admin */
INSERT INTO account(ACCOUNT_NO,ACCOUNT_PASS,ACCOUNT_LOGIN_TIME,ACCOUNT_TRY_NO,ACCOUNT_PUR) values('admin','admin',NOW(),'0','A');
/*主管*/
INSERT INTO account(ACCOUNT_NO,ACCOUNT_PASS,ACCOUNT_LOGIN_TIME,ACCOUNT_TRY_NO,ACCOUNT_PUR) values('testM','testM',NOW(),'0','M');
/*員工*/
INSERT INTO account(ACCOUNT_NO,ACCOUNT_PASS,ACCOUNT_LOGIN_TIME,ACCOUNT_TRY_NO,ACCOUNT_PUR) values('testE','testE',NOW(),'0','E');
INSERT INTO account(ACCOUNT_NO,ACCOUNT_PASS,ACCOUNT_LOGIN_TIME,ACCOUNT_TRY_NO,ACCOUNT_PUR) values('ahui','ahui',NOW(),'0','E');
/*資訊推播 測試用*/
INSERT INTO message_info( account_no, message_no, message_content, message_send_flg, message_level, message_create_time, message_send_time, message_create_account) VALUES (  'admin'  ,'0' , '測試訊息1'  , '0'  , '0'  , NOW()  , null  , 'admin')
INSERT INTO message_info( account_no, message_no, message_content, message_send_flg, message_level, message_create_time, message_send_time, message_create_account) VALUES (  'admin'  ,'1' , '月次訊息'  , '0'  , '0'  , NOW()  , null  , 'admin')
INSERT INTO message_info( account_no, message_no, message_content, message_send_flg, message_level, message_create_time, message_send_time, message_create_account) VALUES (  'admin'  ,'2' , '即將到期'  , '0'  , '0'  , NOW()  , null  , 'admin')
/*個人基本資料 正式環境用*/
INSERT INTO personsal_info (account_no, jobtitle, birthday, gendor, name, phone_no, email, mate, live_alone, near_station, address, residence_card_no, residence_date_start, residence_date_end, bank_account_name, bank_account_branch, bank_account_no, passport_no, hired_insurance_insured_no, dependent_relative_name_1, dependent_relative_relation_1, dependent_relative_birthday_1, dependent_relative_address_1, dependent_relative_name_2, dependent_relative_relation_2, dependent_relative_birthday_2, dependent_relative_address_2, dependent_relative_name_3, dependent_relative_relation_3, dependent_relative_birthday_3, dependent_relative_address_3) VALUES ('ahui    ', 'PM', '2019-09-08 00:00:00', 'M', 'ahui2', '0912345678', 'ahu@gmail.com', 'N', 'N', 'TAIPEI', 'ADDRESS1', '1234567890', '2019-09-08 00:00:00', '2019-09-09 00:00:00', 'AHUI_BANK', 'TOKOYO', '1234567891', '0987654321', '32123213211', 'TAI NIOU', 'GIRL FRIEND', '2019-09-07 00:00:00', 'IN MY ROOM', null, null, null, null, null, null, null, null);



