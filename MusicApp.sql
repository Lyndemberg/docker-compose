CREATE TABLE banda(
	id SERIAL,
	nome VARCHAR(100),
	localorigem VARCHAR(100),
	PRIMARY KEY(id)
);
CREATE TABLE integrante(
	id SERIAL,
	nome VARCHAR(100),
	banda INT,
	FOREIGN KEY (banda) REFERENCES banda(id) ON UPDATE CASCADE ON DELETE CASCADE,
	PRIMARY KEY(id)
);
CREATE TABLE album(
	id SERIAL,
	estilo VARCHAR(50),
	banda INT,
	lancamento VARCHAR(10),
	FOREIGN KEY (banda) REFERENCES banda(id) ON UPDATE CASCADE ON DELETE CASCADE,
	PRIMARY KEY(id)
);

INSERT INTO banda (nome,localorigem) VALUES ('Beatles', 'Liverpool');
INSERT INTO banda (nome,localorigem) VALUES ('Rolling Stones', 'Europa');
INSERT INTO banda (nome,localorigem) VALUES ('Pantera', 'Cajazeiras');

INSERT INTO integrante (nome,banda) VALUES ('John Lennon', 1);
INSERT INTO integrante (nome,banda) VALUES ('Paul Mcartnney', 1);
INSERT INTO integrante (nome,banda) VALUES ('Mick', 2);
INSERT INTO integrante (nome,banda) VALUES ('Rômulo Soares', 3);
INSERT INTO integrante (nome,banda) VALUES ('Thiago Yure', 3);
