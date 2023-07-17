CREATE DATABASE IF NOT EXISTS db_student;

create table t_user
(
    id   int auto_increment comment '编号'
        primary key,
    name varchar(255) null comment '姓名',
    age  int          null comment '年龄'
);

create table teacher
(
    tid      int auto_increment
        primary key,
    tname    varchar(20)  not null,
    tsex     varchar(5)   null,
    ttel     varchar(20)  null,
    taddress varchar(100) null
);

create table class
(
    classId     int                    not null
        primary key,
    cclasname   varchar(20) default '' not null,
    teachername varchar(20)            null comment '班主任',
    constraint class_ibfk_1
        foreign key (teachername) references teacher (tname)
            on update cascade on delete set null
);

create index classname
    on class (cclasname);

create index teachername
    on class (teachername);

create table course
(
    courseId   int         not null
        primary key,
    coursename varchar(20) not null,
    coursetype int         null,
    classname  varchar(20) null,
    constraint course_ibfk_1
        foreign key (classname) references class (cclasname)
            on update cascade on delete set null
);

create index classname
    on course (classname);

create index coursename
    on course (coursename);

create table student
(
    sid      int          not null
        primary key,
    sname    varchar(20)  not null,
    sage     int          null,
    ssex     varchar(5)   null,
    sdept    varchar(10)  null,
    sclas    varchar(20)  null,
    stel     varchar(20)  null,
    saddress varchar(100) null,
    constraint student_ibfk_1
        foreign key (sclas) references class (cclasname)
            on update cascade on delete set null
);

create table achievement
(
    achievementid int auto_increment
        primary key,
    stuid         int         null,
    coursename    varchar(20) null,
    achievement   varchar(20) null,
    constraint achievement_ibfk_1
        foreign key (stuid) references student (sid)
            on update cascade on delete cascade,
    constraint achievement_ibfk_2
        foreign key (coursename) references course (coursename)
            on update cascade on delete cascade
);

create index coursename
    on achievement (coursename);

create index stuid
    on achievement (stuid);

create index tname
    on teacher (tname);

create table user
(
    id        int auto_increment
        primary key,
    username  varchar(10) null,
    password  varchar(20) null,
    stuid     int         null,
    teacherid int         null,
    type      int         null,
    constraint user_ibfk_1
        foreign key (stuid) references student (sid)
            on update cascade on delete cascade,
    constraint user_ibfk_2
        foreign key (teacherid) references teacher (tid)
            on update cascade on delete cascade
);

create index stuid
    on user (stuid);

create index teacherid
    on user (teacherid);

