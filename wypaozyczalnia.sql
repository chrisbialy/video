DROP TABLE if exists rental;
DROP TABLE if exists item;
DROP TABLE if exists client;



create table client 
(
cid int(6) NOT NULL AUTO_INCREMENT ,
name char(20),
surname char(20),
primary key (cid)
)ENGINE=InnoDB default character set=utf8;


create table item 
(
iid int(6) NOT NULL AUTO_INCREMENT,
title char(20),
status int(1),
primary key (iid)
)ENGINE=InnoDB default character set=utf8;

create table rental
(
rid int(6) NOT NULL AUTO_INCREMENT,
cid int(6),
iid int(6),
primary key (rid),
foreign key (cid) references client(cid),
foreign key (iid) references item(iid)
)ENGINE=InnoDB default character set=utf8;


/*client */


insert into client (name,surname) values ('Chris','Bialy');
insert into client (name,surname) values ('Jan','Kac');
insert into client (name,surname) values ('Adam','Nowak');
insert into client (name,surname) values ('Anna','Atom');

/*item */


insert into item (title,status) values ('Shrek!',1);
insert into item (title,status) values ('Killer',1);
insert into item (title,status) values ('Rambo',1);

/*rental */


insert into rental (cid,iid) values (1,1);
insert into rental (cid,iid) values (1,2);
insert into rental (cid,iid) values (3,1);
insert into rental (cid,iid) values (2,1);
insert into rental (cid,iid) values (2,2);
insert into rental (cid,iid) values (4,3);
insert into rental (cid,iid) values (4,2);

/*Testing database */

select rental.rid, client.cid, client.name, client.surname, item.title
from rental
join client on client.cid = rental.cid
join item on item.iid = rental.iid
where client.cid=3;		/*client.id = 1,2,3 etc  */
