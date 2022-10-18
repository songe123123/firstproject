INSERT INTO article(id, title, content) VALUES (1,'AAAA','1111')
INSERT INTO article(id, title, content) VALUES (2,'BBBB','2222')
INSERT INTO article(id, title, content) VALUES (3,'CCCC','3333')


--article 더미 데이터
INSERT INTO article(id, title, content) VALUES (4,'your favorite MOVIE?','comment plz111')
INSERT INTO article(id, title, content) VALUES (5,'your SOUL FOOD?','comment plz2222')
INSERT INTO article(id, title, content) VALUES (6,'your HOBBY?','comment plz333333')

--comment 더미 데이터
---4번 게시글의 댓글들
INSERT INTO comment(id, article_id, nickname, body) VALUES (1, 4 ,'Park','GOOD WILL HUNTING')
INSERT INTO comment(id, article_id, nickname, body) VALUES (2, 4 ,'Kim','Iam SAM')
INSERT INTO comment(id, article_id, nickname, body) VALUES (3, 4 ,'Choi','ShowsankESCAPE')
---4번 게시글의 댓글들
INSERT INTO comment(id, article_id, nickname, body) VALUES(4, 5, 'Park', 'chicken')
INSERT INTO comment(id, article_id, nickname, body) VALUES(5, 5, 'Kim', 'shabu-shabu')
INSERT INTO comment(id, article_id, nickname, body) VALUES(6, 5, 'Choi', 'sushi')
---- 6번 게시글의 댓글들
INSERT INTO comment(id, article_id, nickname, body) VALUES(7, 6, 'Park', 'Jogginh')
INSERT INTO comment(id, article_id, nickname, body) VALUES(8, 6, 'Kim', 'Youtube')
INSERT INTO comment(id, article_id, nickname, body) VALUES(9, 6, 'Choi', 'Reading')


--------------------------------------------------------------------------------------------

INSERT INTO entitybasic(id, title, contents) VALUES (1,'AAAA','1111')
INSERT INTO entitybasic(id, title, contents) VALUES (2,'BBBB','2222')
INSERT INTO entitybasic(id, title, contents) VALUES (3,'CCCC','3333')


--article 더미 데이터
INSERT INTO entitybasic(id, title, contents) VALUES (4,'your favorite MOVIE?','comment plz111')
INSERT INTO entitybasic(id, title, contents) VALUES (5,'your SOUL FOOD?','comment plz2222')
INSERT INTO entitybasic(id, title, contents) VALUES (6,'your HOBBY?','comment plz333333')


--comment 더미 데이터
---4번 게시글의 댓글들
INSERT INTO commentbasic(id, main_article, nickname, body) VALUES (1, 4 ,'Park','GOOD WILL HUNTING')
INSERT INTO commentbasic(id, main_article, nickname, body) VALUES (2, 4 ,'Kim','Iam SAM')
INSERT INTO commentbasic(id, main_article, nickname, body) VALUES (3, 4 ,'Choi','ShowsankESCAPE')
---4번 게시글의 댓글들
INSERT INTO commentbasic(id, main_article, nickname, body) VALUES(4, 5, 'Park', 'chicken')
INSERT INTO commentbasic(id, main_article, nickname, body) VALUES(5, 5, 'Kim', 'shabu-shabu')
INSERT INTO commentbasic(id, main_article, nickname, body) VALUES(6, 5, 'Choi', 'sushi')
---- 6번 게시글의 댓글들
INSERT INTO commentbasic(id, main_article, nickname, body) VALUES(7, 6, 'Park', 'Jogginh')
INSERT INTO commentbasic(id, main_article, nickname, body) VALUES(8, 6, 'Kim', 'Youtube')
INSERT INTO commentbasic(id, main_article, nickname, body) VALUES(9, 6, 'Choi', 'Reading')


