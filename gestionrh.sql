CREATE SCHEMA IF NOT EXISTS "public";

CREATE  TABLE "public".annonce ( 
	id_annonce           serial  NOT NULL  ,
	motif                varchar(100)    ,
	poste                varchar    ,
	volume_horaire       varchar    ,
	jour_de_test         date    ,
	jour_d_entretien     date    ,
	qualiter_requise     varchar(100)    ,
	CONSTRAINT pk_annonce PRIMARY KEY ( id_annonce )
 );

CREATE  TABLE "public".avantage_fiche ( 
	id_avantage_fiche    serial  NOT NULL  ,
	id_fiche_poste       numeric    ,
	id_avantage          numeric    ,
	CONSTRAINT pk_avantage_fiche PRIMARY KEY ( id_avantage_fiche ),
	CONSTRAINT unq_avantage_fiche_id_avantage UNIQUE ( id_avantage ) ,
	CONSTRAINT unq_avantage_fiche_id_fiche_poste UNIQUE ( id_fiche_poste ) 
 );

CREATE  TABLE "public".contrat ( 
	id_contrat           serial  NOT NULL  ,
	id_type_contrat      numeric    ,
	numero_matricule     varchar(10)    ,
	id_poste             numeric    ,
	lieu_de_travail      numeric    ,
	date_debut           date    ,
	date_fin             date    ,
	horaire_de_travail   timestamp    ,
	CONSTRAINT pk_contrat PRIMARY KEY ( id_contrat ),
	CONSTRAINT unq_contrat_id_type_contrat UNIQUE ( id_type_contrat ) ,
	CONSTRAINT unq_contrat_id_poste UNIQUE ( id_poste ) ,
	CONSTRAINT unq_contrat_numero_matricule UNIQUE ( numero_matricule ) 
 );

CREATE  TABLE "public".diplome_personnel ( 
	id_diplome_personnel serial  NOT NULL  ,
	id_fiche_personnel   numeric    ,
	id_diplome           numeric    ,
	CONSTRAINT pk_diplome_personnel PRIMARY KEY ( id_diplome_personnel ),
	CONSTRAINT unq_diplome_personnel_id_fiche_personnel UNIQUE ( id_fiche_personnel ) ,
	CONSTRAINT unq_diplome_personnel_id_diplome UNIQUE ( id_diplome ) 
 );

CREATE  TABLE "public".droit_fiche ( 
	id_droit_fiche       serial  NOT NULL  ,
	id_droit             numeric    ,
	id_fiche_poste       numeric    ,
	CONSTRAINT pk_droit_fiche PRIMARY KEY ( id_droit_fiche ),
	CONSTRAINT unq_droit_fiche_id_droit UNIQUE ( id_droit ) ,
	CONSTRAINT unq_droit_fiche_id_fiche_poste UNIQUE ( id_fiche_poste ) 
 );

CREATE  TABLE "public".qualiter_fiche ( 
	id_qualiter_fiche    serial  NOT NULL  ,
	id_qualiter          numeric    ,
	id_fiche_poste       numeric    ,
	CONSTRAINT pk_qualiter_fiche PRIMARY KEY ( id_qualiter_fiche ),
	CONSTRAINT unq_qualiter_fiche_id_fiche_poste UNIQUE ( id_fiche_poste ) ,
	CONSTRAINT unq_qualiter_fiche_id_qualiter UNIQUE ( id_qualiter ) 
 );

CREATE  TABLE "public".responsabilite_poste ( 
	id_responsabiliter_poste serial  NOT NULL  ,
	id_responsabiliter   numeric    ,
	id_fiche_poste       numeric    ,
	CONSTRAINT pk_responsabilite_poste PRIMARY KEY ( id_responsabiliter_poste ),
	CONSTRAINT unq_responsabilite_poste_id_fiche_poste UNIQUE ( id_fiche_poste ) ,
	CONSTRAINT unq_responsabilite_poste_id_responsabiliter UNIQUE ( id_responsabiliter ) 
 );

CREATE  TABLE "public".responsabiliter ( 
	id_responsabiliter   serial  NOT NULL  ,
	responsabiliter      serial    ,
	CONSTRAINT pk_responsabiliter PRIMARY KEY ( id_responsabiliter ),
	CONSTRAINT fk_responsabiliter_responsabilite_poste FOREIGN KEY ( id_responsabiliter ) REFERENCES "public".responsabilite_poste( id_responsabiliter )   
 );

CREATE  TABLE "public".service_diplome ( 
	id_service_diplome   serial  NOT NULL  ,
	id_service           numeric    ,
	id_diplome           numeric    ,
	CONSTRAINT pk_service_diplome PRIMARY KEY ( id_service_diplome ),
	CONSTRAINT unq_service_diplome_id_service UNIQUE ( id_service ) ,
	CONSTRAINT unq_service_diplome_id_diplome UNIQUE ( id_diplome ) 
 );

CREATE  TABLE "public".service_qualiter ( 
	id_service_qualiter  serial  NOT NULL  ,
	id_qualiter          numeric    ,
	id_service           numeric    ,
	CONSTRAINT pk_service_qualiter PRIMARY KEY ( id_service_qualiter ),
	CONSTRAINT unq_service_qualiter_id_service UNIQUE ( id_service ) ,
	CONSTRAINT unq_service_qualiter_id_qualiter UNIQUE ( id_qualiter ) 
 );

CREATE  TABLE "public".societe_departement ( 
	id_soc_dept          serial  NOT NULL  ,
	id_societe           numeric    ,
	id_department        numeric    ,
	CONSTRAINT pk_societe_departement PRIMARY KEY ( id_soc_dept ),
	CONSTRAINT unq_societe_departement_id_societe UNIQUE ( id_societe ) ,
	CONSTRAINT unq_societe_departement_id_department UNIQUE ( id_department ) 
 );

CREATE  TABLE "public".type_contrat ( 
	id_type_contrat      serial  NOT NULL  ,
	"type"               varchar(10)    ,
	CONSTRAINT pk_type_contrat PRIMARY KEY ( id_type_contrat ),
	CONSTRAINT fk_type_contrat_contrat FOREIGN KEY ( id_type_contrat ) REFERENCES "public".contrat( id_type_contrat )   
 );

CREATE  TABLE "public".avantage ( 
	id_avantage          serial  NOT NULL  ,
	avantage             varchar    ,
	CONSTRAINT pk_avantage PRIMARY KEY ( id_avantage ),
	CONSTRAINT fk_avantage_avantage_fiche FOREIGN KEY ( id_avantage ) REFERENCES "public".avantage_fiche( id_avantage )   
 );

CREATE  TABLE "public".diplome ( 
	id_diplome           serial  NOT NULL  ,
	diplome              varchar(15)    ,
	CONSTRAINT pk_diplome PRIMARY KEY ( id_diplome ),
	CONSTRAINT fk_diplome_service_diplome FOREIGN KEY ( id_diplome ) REFERENCES "public".service_diplome( id_diplome )   ,
	CONSTRAINT fk_diplome_diplome_personnel FOREIGN KEY ( id_diplome ) REFERENCES "public".diplome_personnel( id_diplome )   
 );

CREATE  TABLE "public".droit ( 
	id_droit             serial  NOT NULL  ,
	droit                varchar(100)    ,
	CONSTRAINT pk_droit PRIMARY KEY ( id_droit ),
	CONSTRAINT fk_droit_droit_fiche FOREIGN KEY ( id_droit ) REFERENCES "public".droit_fiche( id_droit )   
 );

CREATE  TABLE "public".fiche_poste ( 
	id_fiche_poste       serial  NOT NULL  ,
	numero_matricule     varchar(10)    ,
	id_poste_departement numeric    ,
	mission              varchar(25)    ,
	CONSTRAINT pk_fiche_poste PRIMARY KEY ( id_fiche_poste ),
	CONSTRAINT unq_fiche_poste_id_poste UNIQUE ( id_poste_departement ) ,
	CONSTRAINT unq_fiche_poste_numero_matricule UNIQUE ( numero_matricule ) ,
	CONSTRAINT fk_fiche_poste_avantage_fiche FOREIGN KEY ( id_fiche_poste ) REFERENCES "public".avantage_fiche( id_fiche_poste )   ,
	CONSTRAINT fk_fiche_poste_droit_fiche FOREIGN KEY ( id_fiche_poste ) REFERENCES "public".droit_fiche( id_fiche_poste )   ,
	CONSTRAINT fk_fiche_poste_qualiter_fiche FOREIGN KEY ( id_fiche_poste ) REFERENCES "public".qualiter_fiche( id_fiche_poste )   ,
	CONSTRAINT fk_fiche_poste_responsabilite_poste FOREIGN KEY ( id_fiche_poste ) REFERENCES "public".responsabilite_poste( id_fiche_poste )   
 );

CREATE  TABLE "public".qualiter ( 
	id_qualiter          serial  NOT NULL  ,
	qualiter             varchar(25)    ,
	CONSTRAINT pk_qualiter PRIMARY KEY ( id_qualiter ),
	CONSTRAINT fk_qualiter_qualiter_fiche FOREIGN KEY ( id_qualiter ) REFERENCES "public".qualiter_fiche( id_qualiter )   ,
	CONSTRAINT fk_qualiter_service_qualiter FOREIGN KEY ( id_qualiter ) REFERENCES "public".service_qualiter( id_qualiter )   
 );

CREATE  TABLE "public".service ( 
	id_service           serial  NOT NULL  ,
	id_departement       numeric    ,
	besoin               varchar(100)    ,
	id_poste             numeric    ,
	volume_min           numeric(1)    ,
	volume_max           numeric(5)    ,
	CONSTRAINT pk_service PRIMARY KEY ( id_service ),
	CONSTRAINT unq_service_id_poste UNIQUE ( id_poste ) ,
	CONSTRAINT fk_service_service_qualiter FOREIGN KEY ( id_service ) REFERENCES "public".service_qualiter( id_service )   ,
	CONSTRAINT fk_service_service_diplome FOREIGN KEY ( id_service ) REFERENCES "public".service_diplome( id_service )   
 );

CREATE  TABLE "public".societe ( 
	id_societe           serial  NOT NULL  ,
	societe              varchar    ,
	CONSTRAINT pk_societe PRIMARY KEY ( id_societe ),
	CONSTRAINT fk_societe_societe_departement FOREIGN KEY ( id_societe ) REFERENCES "public".societe_departement( id_societe )   
 );

CREATE  TABLE "public".fiche_personnel ( 
	id_fiche             integer  NOT NULL  ,
	numero_matricule     varchar(10)    ,
	nom                  varchar(25)    ,
	prenom               varchar(50)    ,
	date_de_naissance    date    ,
	genre                numeric(1)    ,
	id_situation         numeric    ,
	adresse              varchar(50)    ,
	email                varchar(50)    ,
	numero               numeric    ,
	CONSTRAINT pk_fiche_personnel PRIMARY KEY ( id_fiche ),
	CONSTRAINT unq_fiche_personnel_id_situation UNIQUE ( id_situation ) ,
	CONSTRAINT fk_fiche_personnel_fiche_poste FOREIGN KEY ( numero_matricule ) REFERENCES "public".fiche_poste( numero_matricule )   ,
	CONSTRAINT fk_fiche_personnel_diplome_personnel FOREIGN KEY ( id_fiche ) REFERENCES "public".diplome_personnel( id_fiche_personnel )   ,
	CONSTRAINT fk_fiche_personnel_contrat FOREIGN KEY ( numero_matricule ) REFERENCES "public".contrat( numero_matricule )   
 );

CREATE  TABLE "public".poste_departement ( 
	id_poste_departement serial  NOT NULL  ,
	id_poste             numeric    ,
	id_departement       numeric    ,
	CONSTRAINT pk_poste_departement PRIMARY KEY ( id_poste_departement ),
	CONSTRAINT unq_poste_departement_id_departement UNIQUE ( id_departement ) ,
	CONSTRAINT unq_poste_departement_id_poste UNIQUE ( id_poste ) ,
	CONSTRAINT fk_poste_departement_service FOREIGN KEY ( id_poste_departement ) REFERENCES "public".service( id_poste )   ,
	CONSTRAINT fk_poste_departement_contrat FOREIGN KEY ( id_poste_departement ) REFERENCES "public".contrat( id_poste )   ,
	CONSTRAINT fk_poste_departement_fiche_poste FOREIGN KEY ( id_poste_departement ) REFERENCES "public".fiche_poste( id_poste_departement )   
 );

CREATE  TABLE "public".situation_familial ( 
	id_situation         serial  NOT NULL  ,
	situation            varchar(100)    ,
	CONSTRAINT pk_situation_familial PRIMARY KEY ( id_situation ),
	CONSTRAINT fk_situation_familial_fiche_personnel FOREIGN KEY ( id_situation ) REFERENCES "public".fiche_personnel( id_situation )   
 );

CREATE  TABLE "public".departement ( 
	id_departement       serial  NOT NULL  ,
	nom_departement      varchar(25)    ,
	volume_de_tache      numeric(5)    ,
	nombre_employe       numeric(10)    ,
	CONSTRAINT pk_departement PRIMARY KEY ( id_departement ),
	CONSTRAINT fk_departement_societe_departement FOREIGN KEY ( id_departement ) REFERENCES "public".societe_departement( id_department )   ,
	CONSTRAINT fk_departement_poste_departement FOREIGN KEY ( id_departement ) REFERENCES "public".poste_departement( id_departement )   
 );

CREATE  TABLE "public".poste ( 
	id_poste             serial  NOT NULL  ,
	nom_poste            varchar(25)    ,
	CONSTRAINT pk_poste PRIMARY KEY ( id_poste ),
	CONSTRAINT fk_poste_poste_departement FOREIGN KEY ( id_poste ) REFERENCES "public".poste_departement( id_poste )   
 );

