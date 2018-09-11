/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  admin
 * Created: 8/09/2018
 */
create table user
(
    id integer not null primary key auto_increment,
    full_name VARCHAR(255), 
    login VARCHAR(255),
    password VARCHAR(255), 
    email VARCHAR(20)
);

