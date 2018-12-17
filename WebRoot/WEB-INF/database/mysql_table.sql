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
   password VARCHAR(64) ,
   commentsNum INT,
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
  
INSERT INTO users_basic(username,password,mail,groups) value('admin','admin123','vase@yahoo.com','admin'); 
INSERT INTO users_basic(username,password,mail,groups) value('vase','fatevase','vase87@yahoo.com','admin'); 
INSERT INTO contents(title,text,authorID) value('test','it is test content',1);
INSERT INTO comments(cid,owenrId,text) value(1,1,'it is test comments');