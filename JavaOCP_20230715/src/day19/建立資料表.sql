create table if not exists branch(
	branch_id int auto_increment primary key,
	city varchar(50) not null,
	branch_name varchar(50) not null			
);

create table if not exists product(
	product_id int auto_increment primary key,
	product_name varchar(50) not null,
	price decimal(10, 2) not null			
);

create table if not exists sales(
	id int auto_increment primary key,
	date DATE not null,
	product_id int,
	qty int not null,
	branch_id int,
	foreign key (product_id) references product(product_id),
	foreign key (branch_id) references branch(branch_id)	
);