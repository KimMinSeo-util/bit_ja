--시작 START
drop table board;
drop table users;
sqlplus system/1234
conn system/1234

create user board identified by board
default tablespace bit;
grant connect,resource to board;
conn board/board;
sqlplus board/board
--회원 테이블 생성
create table users(
     id          varchar2(8)   constraint users_pk primary key NOT NULL, --not null왜 안될까요?
     password    varchar2(30) NOT NULL,   
     name        varchar2(30) NOT NULL,
     role        varchar2(30) default 'user'
);
--게시판 테이블 생성
create table board( 
     seq         Integer constraint board_pk primary key,
     title       varchar2(50)     NOT NULL,
     content     varchar2(1000),
     regdate     date             NOT NULL,
     cnt         Integer,
     id          varchar2(8)      NOT NULL
);
ALTER TABLE board ADD CONSTRAINT board_id_fk FOREIGN KEY ( id ) REFERENCES users ( id ) NOT DEFERRABLE;
commit;

select * from users;
select * from board;

-- insert users  회원등록
insert into users (id, password, name, role) values('hong', 1234, '홍길동', admin);
insert into users (id, password, name, role) values('kim',  5678, '김길동', default);
insert into users (id, password, name, role) values('choi', 0000, '최길동', default);
insert into users (id, password, name, role) values('lee',  9999, '이길동', default);
insert into users (id, password, name, role) values('go',   8888, '고길동', default);

select * from users;

-- pw  회원정보수정(0 row updated로 뜸. 된걸까? 안된걸까?)
update users set password ='7777' where role = 'admin';    

로그인
select id,password from users where id ='kim' and password ='5678';

--insert board 게시판 글등록
//create sequence board_seq start with 1 increment by 1;
//create sequence cnt_seq;

insert into board(seq,title,content,regdate,cnt,id) values(board_seq.nextval,'공지','안녕하세요',sysdate,0,'hong');
insert into board(seq,title,content,regdate,cnt,id) values(board_seq.nextval,'가입인사','안녕하세요. 저는 김길동 입니다.',sysdate,0,'kim');
insert into board(seq,title,content,regdate,cnt,id) values(board_seq.nextval,'안부글','안녕하세요. 오늘은 점심에 대해서 알아볼게요~ 감사합니다.',sysdate,0,'choi');
insert into board(seq,title,content,regdate,cnt,id) values(board_seq.nextval,'유머글','자두2개와 자몽1개는?',sysdate,0,'lee');
insert into board(seq,title,content,regdate,cnt,id) values(board_seq.nextval,'[kim답글]가입인사','5℃5:5',sysdate,0,'go');

select * from board;

--글수정 (0 row updated로 뜸. 된걸까? 안된걸까?)
update board set content = '안녕하세요 여러분 이곳은 게시판 입니다.' where title = '공지';

게시판 글 삭제
//alter table board drop CONSTRAINT board_fk1;
//alter table board add CONSTRAINT board_fk1 foreign key(id) references users ON DELETE cascade;
delete from board where id='kim';

select * from board;
select * from users;

데이터검색(Query)


전체 등록글 수

--group by 사용자별 등록글수 

--group by 월별게시글수

--group by 사용자별 게시글 검색

제목으로 게시글 검색


create table Customer(
custid number constraint custid_pk primary key,
name varchar2(40),
address varchar2(40),
phone varchar2(30)
);

create table Orders(
orderid number constraint orderid_pk primary key,
custid number constraint custid_not_null not null,
bookid number constraint bookid_not_null not null,
saleprice number,
orderdate DATE
);

alter table orders add constraint custid_fk1 foreign key(custid) references customer on delete cascade;

drop table customer;
drop table orders;





















