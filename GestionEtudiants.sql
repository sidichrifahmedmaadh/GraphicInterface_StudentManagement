create database GestionEtudiants;
use GestionEtudiants;

create table GestionEtudiants (id varchar(15) primary key,
							   nom varchar(15),
							   prenom varchar(15),
                               filiere varchar(15));

select * from GestionEtudiants;