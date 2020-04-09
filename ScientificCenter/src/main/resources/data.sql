insert into scientific_area(scientific_area_id, name) VALUES (1,"It");
insert into scientific_area(scientific_area_id, name) VALUES (2,"Physics");
insert into scientific_area(scientific_area_id, name) VALUES (3,"Electrical engineering");

INSERT INTO `role` VALUES (1,'USER'),(2,'ADMIN'),(3,'REVIEWER'),(4,'EDITOR'),(5,'LEADEDITOR'),(6,'AUTHOR'),(7,'COAUTHOR');
INSERT INTO `user` (user_id,active,city,country,email,firstname,password,reviewer_check,surname,title,username) VALUES (1,true,'Zemun','Serbia','test@test.com','Korisnik','{bcrypt}$2a$10$livl.GRKgXNnUxCg6z3bhu0Xj.KeGnINWRhqYFvgaVnFkEBKUMXB.',false,'Korisnik','titula','user');
INSERT INTO `user` (user_id,active,city,country,email,firstname,password,reviewer_check,surname,title,username) VALUES (2,true,'Zemun','Serbia','admin@admin.com','Aleksandar','{bcrypt}$2a$10$livl.GRKgXNnUxCg6z3bhu0Xj.KeGnINWRhqYFvgaVnFkEBKUMXB.',false,'Jeremic','titula','acika');
INSERT INTO `user` (user_id,active,city,country,email,firstname,password,reviewer_check,surname,title,username) VALUES (3,true,'Zemun','Serbia','jeremicaleksandar96@gmail.com','Urednik1','{bcrypt}$2a$10$livl.GRKgXNnUxCg6z3bhu0Xj.KeGnINWRhqYFvgaVnFkEBKUMXB.',false,'Urednik1','titula','urednik');
INSERT INTO `user` (user_id,active,city,country,email,firstname,password,reviewer_check,surname,title,username) VALUES (4,true,'Zemun','Serbia','urednik@urednik.com','Urednik2','{bcrypt}$2a$10$livl.GRKgXNnUxCg6z3bhu0Xj.KeGnINWRhqYFvgaVnFkEBKUMXB.',false,'Urednik2','titula','urednik1');
INSERT INTO `user` (user_id,active,city,country,email,firstname,password,reviewer_check,surname,title,username) VALUES (5,true,'Zemun','Serbia','urednik@urednik.com','Urednik3','{bcrypt}$2a$10$livl.GRKgXNnUxCg6z3bhu0Xj.KeGnINWRhqYFvgaVnFkEBKUMXB.',false,'Urednik3','titula','urednik2');
INSERT INTO `user` (user_id,active,city,country,email,firstname,password,reviewer_check,surname,title,username,location_id) VALUES (6,true,'Zemun','Serbia','urednik@urednik.com','Recenzent1','{bcrypt}$2a$10$livl.GRKgXNnUxCg6z3bhu0Xj.KeGnINWRhqYFvgaVnFkEBKUMXB.',false,'Recenzent1','titula','recenzent1',1);
INSERT INTO `user` (user_id,active,city,country,email,firstname,password,reviewer_check,surname,title,username,location_id) VALUES (7,true,'Zemun','Serbia','urednik@urednik.com','Recenzent2','{bcrypt}$2a$10$livl.GRKgXNnUxCg6z3bhu0Xj.KeGnINWRhqYFvgaVnFkEBKUMXB.',false,'Recenzent2','titula','recenzent2',2);
INSERT INTO `user` (user_id,active,city,country,email,firstname,password,reviewer_check,surname,title,username,location_id) VALUES (8,true,'Zemun','Serbia','urednik@urednik.com','Recenzent3','{bcrypt}$2a$10$livl.GRKgXNnUxCg6z3bhu0Xj.KeGnINWRhqYFvgaVnFkEBKUMXB.',false,'Recenzent3','titula','recenzent3',3);
INSERT INTO `user` (user_id,active,city,country,email,firstname,password,reviewer_check,surname,title,username,membership,location_id) VALUES (9,true,'Zemun','Serbia','urednik@urednik.com','Autor1','{bcrypt}$2a$10$livl.GRKgXNnUxCg6z3bhu0Xj.KeGnINWRhqYFvgaVnFkEBKUMXB.',false,'Autor 1','titula','autor1',1,5);
INSERT INTO `user` (user_id,active,city,country,email,firstname,password,reviewer_check,surname,title,username,membership,location_id) VALUES (10,true,'Zemun','Serbia','urednik@urednik.com','Autor2','{bcrypt}$2a$10$livl.GRKgXNnUxCg6z3bhu0Xj.KeGnINWRhqYFvgaVnFkEBKUMXB.',false,'Autor 2','titula','autor2',0,4);
INSERT INTO `user` (user_id,active,city,country,email,firstname,password,reviewer_check,surname,title,username,edit_magazine_id) VALUES (11,true,'Zemun','Serbia','urednik@urednik.com','GlavniUrednik1','{bcrypt}$2a$10$livl.GRKgXNnUxCg6z3bhu0Xj.KeGnINWRhqYFvgaVnFkEBKUMXB.',false,'GlavniUrednik1','titula','glavniurednik1',1);
INSERT INTO `user` (user_id,active,city,country,email,firstname,password,reviewer_check,surname,title,username,edit_magazine_id) VALUES (12,true,'Zemun','Serbia','urednik@urednik.com','GlavniUrednik2','{bcrypt}$2a$10$livl.GRKgXNnUxCg6z3bhu0Xj.KeGnINWRhqYFvgaVnFkEBKUMXB.',false,'GlavniUrednik2','titula','glavniurednik2',2);
INSERT INTO `user` (user_id,active,city,country,email,firstname,password,reviewer_check,surname,title,username,edit_magazine_id) VALUES (13,true,'Zemun','Serbia','urednik@urednik.com','GlavniUrednik3','{bcrypt}$2a$10$livl.GRKgXNnUxCg6z3bhu0Xj.KeGnINWRhqYFvgaVnFkEBKUMXB.',false,'GlavniUrednik3','titula','glavniurednik3',2);

insert into user_role VALUES (1,1);
insert into user_role VALUES (2,2);
insert into user_role VALUES (3,4);
insert into user_role VALUES (4,4);
insert into user_role VALUES (5,4);
insert into user_role VALUES (6,3);
insert into user_role VALUES (7,3);
insert into user_role VALUES (8,3);
insert into user_role VALUES (9,6);
insert into user_role VALUES (10,6);
insert into user_role VALUES (11,5);
insert into user_role VALUES (12,5);
insert into user_role VALUES (13,5);

insert into user_scientificareas values (1,1);
insert into user_scientificareas values (2,2);
insert into user_scientificareas values (3,2);
insert into user_scientificareas values (3,1);
insert into user_scientificareas values (4,1);
insert into user_scientificareas values (5,2);
insert into user_scientificareas values (6,1);
insert into user_scientificareas values (7,1);
insert into user_scientificareas values (7,2);
insert into user_scientificareas values (8,3);

insert into magazine (magazine_id,active_status,magazine_type,price,issn,name,need_edit,lead_editor_id) values (1,1,"PRETPLATA",123,"1234","Casopis 1",0,11);
insert into magazine (magazine_id,active_status,magazine_type,price,issn,name,need_edit,lead_editor_id) values (2,1,"OPEN_ACCESS",321,"12231321","Casopis 2",0,12);
insert into magazine (magazine_id,active_status,magazine_type,price,issn,name,need_edit,lead_editor_id) values (3,1,"OPEN_ACCESS",321,"12231321","Casopis 3",0,13);

insert into scientificareas_magazines values (1,1);
insert into scientificareas_magazines values (1,2);
insert into scientificareas_magazines values (2,1);
insert into scientificareas_magazines values (2,2);
insert into scientificareas_magazines values (3,1);
insert into scientificareas_magazines values (3,2);

insert into reviewers_magazine values (1,6);
insert into reviewers_magazine values (1,7);
insert into reviewers_magazine values (2,6);
insert into reviewers_magazine values (2,7);


-- LOKACIJA
insert into location (id, lat, lng, name) values (1,40.73,-74.01,"New York");
insert into location (id, lat, lng, name) values (2,44.80,20.43,"Novi Beograd");
insert into location (id, lat, lng, name) values (3,44.85,20.38,"Zemun");
insert into location (id, lat, lng, name) values (4,45.25,19.83,"Novi Sad");
insert into location (id, lat, lng, name) values (5,44.82,20.41,"Novi Beograd 2");
-- insert into location (id, lat, lng, name) values (6);
-- insert into location (id, lat, lng, name) values (7);
-- insert into location (id, lat, lng, name) values (8);
-- insert into location (id, lat, lng, name) values (9);
-- insert into location (id, lat, lng, name) values (10);

-- NAUCNI RAD
-- insert into naucni_rad (id, active, apstrakt, doi, file_location, kljucni_pojmovi, naslov, autor_user_id, naucna_oblast_oblast_id, naucni_casopis_casopis_id)
-- values (1,FALSE,"apstrakt",null,"E:\\Github Repository\\ScintificCenterElastic\\NaucnaCentralaUdd\\src\\main\\resources\\upload\\Elastic Search Proba.pdf","kljuc","Proba",9,2,1);
