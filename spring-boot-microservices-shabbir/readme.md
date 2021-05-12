# How to setup project!

- Setup SQL in the MySQL DB.

```sql
use test;
create table department (
	department_id bigint not null auto_increment,
	department_address varchar(255),
	department_code varchar(255),
	department_name varchar(255),
	primary key (department_id)
) engine=InnoDB;

INSERT INTO `test`.`department` (`department_id`, `department_address`, `department_code`, `department_name`) VALUES ('1', '3rd Cross Street, Achalpur', 'AD-001', 'Advisory');
INSERT INTO `test`.`department` (`department_id`, `department_address`, `department_code`, `department_name`) VALUES ('2', '2nd West Street, Wood, Achalpur', 'TX-001', 'Tax');

create table user (
	user_id bigint not null auto_increment,
	department_id bigint,
	email varchar(255),
	first_name varchar(255),
	last_name varchar(255),
	primary key (user_id)
) engine=InnoDB;

INSERT INTO `test`.`user` (`user_id`, `department_id`, `email`, `first_name`, `last_name`) VALUES ('1', '1', 'john.doe@gmailcom', 'John', 'Doe');
INSERT INTO `test`.`user` (`user_id`, `department_id`, `email`, `first_name`, `last_name`) VALUES ('2', '1', 'pradnya.satpute@gmail.com', 'Pradnya', 'Satpute');
INSERT INTO `test`.`user` (`user_id`, `department_id`, `email`, `first_name`, `last_name`) VALUES ('3', '2', 'neha.parate@gmail.com', 'Neha', 'Parate');
INSERT INTO `test`.`user` (`user_id`, `department_id`, `email`, `first_name`, `last_name`) VALUES ('4', '2', 'harshita.dekate@gmail.com', 'Harshita', 'Dekate');
```



![image](https://user-images.githubusercontent.com/54174687/118023124-ca849280-b37a-11eb-80db-11ba7107940a.png)
