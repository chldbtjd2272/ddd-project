insert into SELLER (ID, EMAIL, NAME, PASSWORD, PHONE_NUMBER) VALUES ('cys', 'b@b.com', '최유성', '1234', '010-1111-1112');
insert into SELLER (ID, EMAIL, NAME, PASSWORD, PHONE_NUMBER) VALUES ('seheekwon', 'c@c.com', '권세희', '1234', '010-1111-1113');

insert into BUYER (ID, ADDRESS, EMAIL, NAME, PASSWORD, PHONE_NUMBER) VALUES ('hojin.lee', '용인시', 'a@a.com', '이호진', '1234', '010-1111-1111');

insert into ENROLLMENT (SELLER_ID) values ('cys');

insert into REGISTERED_BOOK (AMOUNT, BOOK_ID, RESERVED, SELL_TYPE, ENROLLMENT_ID) values (10000, 1, false, 'NEW', 1);
