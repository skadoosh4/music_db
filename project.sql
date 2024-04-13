CREATE TABLE MUSICIAN(
	SSN varchar(11) PRIMARY KEY,
	name varchar(255),
    HOME_ID integer
);

ALTER TABLE MUSICIAN ADD CONSTRAINT HOME_ID FOREIGN KEY(HOME_ID) REFERENCES HOME(ID) ON DELETE CASCADE ON UPDATE CASCADE;

CREATE TABLE HOME(
	ID integer PRIMARY KEY,
	phone_no varchar(10),
	address varchar(255) NOT NULL
);

CREATE TABLE INSTRUMENT(
	UID integer PRIMARY KEY,
	name varchar(255),
    musical_key varchar(25)
);

CREATE TABLE ALBUM(
	UID integer PRIMARY KEY,
	title varchar(255),
    copyright_date DATETIME,
    `format` varchar(25),
    album_identifier integer UNIQUE,
    Musician_ID varchar(11) NOT NULL,
    FOREIGN KEY(Musician_ID) references Musician(SSN) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE SONG(
	ID integer PRIMARY KEY,
	title varchar(100),
	author varchar(255),
	ALBUM_ID integer NOT NULL,
	FOREIGN KEY (ALBUM_ID) REFERENCES ALBUM(UID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE PLAY(
	musician_id varchar(11),
	instrument_id integer,
	PRIMARY KEY(musician_id, instrument_id),
	FOREIGN KEY(musician_id) references MUSICIAN(SSN) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(instrument_id) references INSTRUMENT(UID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE PERFORM(
	musician_id varchar(11),
	song_id integer,
	PRIMARY KEY(musician_id, song_id),
	FOREIGN KEY(musician_id) references MUSICIAN(SSN) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(song_id) references SONG(ID) ON DELETE CASCADE ON UPDATE CASCADE
);