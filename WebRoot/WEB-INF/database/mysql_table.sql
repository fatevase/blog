CREATE TABLE users_basic(
       uid INT NOT NULL AUTO_INCREMENT,
       username VARCHAR(32) ,
       password VARCHAR(64),
       mail VARCHAR(200),
       validatekey VARCHAR(64) DEFAULT 0,
       created INT DEFAULT 0,
       activated INT DEFAULT 0,
       groups VARCHAR(16) DEFAULT 'visitor',
       PRIMARY KEY (uid)
    );
CREATE TABLE contents(
   cid INT NOT NULL AUTO_INCREMENT,
   title VARCHAR(100) ,
   created INT DEFAULT 0,
   modified INT DEFAULT 0,
   text LONGTEXT,
   authorId INT DEFAULT 0,
   status VARCHAR(15) DEFAULT 'publish',
   classify VARCHAR(20) DEFAULT 'unclassified',
   password VARCHAR(64) ,
   commentsNum INT DEFAULT 0,
   PRIMARY KEY (cid),
  CONSTRAINT UserCon_ID FOREIGN KEY (authorId) REFERENCES users_basic (uid)
);
CREATE TABLE comments(
   coid INT NOT NULL AUTO_INCREMENT,
   cid INT ,
   created INT DEFAULT 0,
   owenrId INT,
   ip VARCHAR(64),
   text TEXT,
   type varchar(16) DEFAULT 'comment',
   status VARCHAR(15) DEFAULT 'publish',
   parent INT,
   PRIMARY KEY (coid),
    CONSTRAINT UserCom_ID FOREIGN KEY (owenrId) REFERENCES users_basic (uid),
   CONSTRAINT ConCom_ID FOREIGN KEY (cid) REFERENCES contents (cid)
);

  
INSERT INTO users_basic(username,password,mail,groups,created) value('admin',md5('admin123'),'vase@yahoo.com','admin',1545148800); 
INSERT INTO users_basic(username,password,mail,groups,created) value('vase',md5('fatevase'),'vase87@yahoo.com','admin', 1545148800);
INSERT INTO users_basic(username,password,mail,groups,created) value('学生临时账号',md5('fatevase'),'学生账号别删','admin', 1545148800);  
insert into contents(title,created,text,authorId,commentsNum) value('William Shakespeare',1545148800,'William Shakespeare was born in Stratford-upon-Avon, a small country town.',1,1);
INSERT INTO comments(cid,owenrId,text,created) value(1,1,'William Shakespeare', 1545400777);