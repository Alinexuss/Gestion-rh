CREATE DATABASE gestionrh ;

\c gestionrh ;

/*Societe*/
CREATE  TABLE societe ( 
	id_societe           serial  PRIMARY KEY,
	societe              varchar    ,
	CONSTRAINT fk_societe_societe_departement FOREIGN KEY ( id_societe ) REFERENCES societe_departement( id_societe )   
);

/*Departement*/
 CREATE  TABLE departement ( 
	id_departement       serial  PRIMARY KEY,
	nom_departement      varchar(25)   ,
	volume_de_tache      numeric(5)    ,
	nombre_employe       numeric(10)   
);

CREATE  TABLE societe_departement ( 
	id_soc_dept          serial  PRIMARY KEY,
	id_societe           numeric    ,
	id_department        numeric    ,
    FOREIGN KEY ( id_societe ) REFERENCES societe ( id_societe ) ,
    FOREIGN KEY ( id_departement ) REFERENCES departement ( id_departement )
);

/*Poste*/
CREATE  TABLE poste ( 
	id_poste             serial  PRIMARY KEY,
	nom_poste            varchar(25)    
);

CREATE  TABLE poste_departement ( 
	id_poste_departement serial  PRIMARY KEY,
	id_poste             numeric    ,
	id_departement       numeric    ,   
    FOREIGN KEY ( id_poste ) REFERENCES poste ( id_poste ),
    FOREIGN key ( id_departement ) REFERENCES departement ( id_departement )
);

/*Cnaps*/
CREATE  TABLE cnaps ( 
	id_cnaps             serial  PRIMARY KEY,
	numero_cnaps         varchar(10)
);

/*Fiche personnel*/
CREATE  TABLE situation_familial ( 
	id_situation         serial  NOT NULL  ,
	situation            varchar(100)    
);

INSERT INTO situation_familial (situation) VALUES ('Celibataire');
INSERT INTO situation_familial (situation) VALUES ('En couple mais pas marier');
INSERT INTO situation_familial (situation) VALUES ('Marier et ayant 1 enfant');
INSERT INTO situation_familial (situation) VALUES ('Marier et ayant 2 enfants');
INSERT INTO situation_familial (situation) VALUES ('Marier et ayant plus de 2 enfants');

CREATE  TABLE fiche_personnel ( 
	id_fiche_personnel   integer  PRIMARY KEY,
	numero_matricule     varchar(10)    ,
	nom                  varchar(25)    ,
	prenom               varchar(50)    ,
	date_de_naissance    date    ,
	genre                numeric(1)    ,
	id_situation         numeric    ,
	adresse              varchar(50)    ,
	email                varchar(50)    ,
	numero               numeric    ,
	id_cnaps             numeric    ,
    FOREIGN KEY ( id_cnaps ) REFERENCES cnaps ( id_cnaps ),
    FOREIGN KEY ( id_situation ) REFERENCES situation_familial ( id_situation )
);

/*Contrat*/
CREATE  TABLE type_contrat ( 
	id_type_contrat      serial  PRIMARY KEY,
	type_contrat         varchar(20)    ,
);

INSERT INTO type_contrat( type_contrat ) VALUES ('Contrat de travail');
INSERT INTO type_contrat( type_contrat ) VALUES ('Contrat d essai');

CREATE  TABLE contrat ( 
	id_contrat           serial  PRIMARY KEY,
	id_fiche_personnel   numeric    ,
	id_poste             numeric    ,
	lieu_de_travail      numeric    ,
	date_debut           date    ,
	date_fin             date    ,
	horaire_de_travail   timestamp    ,
	id_type_contrat      numeric    ,
    FOREIGN KEY ( id_fiche_personnel ) REFERENCES fiche_personnel ( id_fiche_personnel ),
    FOREIGN KEY ( id_poste ) REFERENCES poste ( id_poste ),
    FOREIGN KEY ( id_type_contrat ) REFERENCES type_contrat ( id_type_contrat )
);