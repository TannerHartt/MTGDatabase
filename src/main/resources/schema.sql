CREATE TABLE "types" (
    "TypesId" INT PRIMARY KEY NOT NULL,
    "Type"    VARCHAR NOT NULL
);

CREATE TABLE "coloridentity" (
    "TypesId" INT NOT NULL PRIMARY KEY,
    "Type" VARCHAR NOT NULL
);

CREATE TABLE "rarity" (
    "TypesId" INT NOT NULL PRIMARY KEY,
    "Type" VARCHAR NOT NULL
);

CREATE TABLE "cards" (
    "TypeId" INT PRIMARY KEY NOT NULL,
    "ManaCost" VARCHAR NOT NULL,
    "Name" VARCHAR NOT NULL,
    "Artist" VARCHAR NOT NULL,
    "Multiverse" LONG NOT NULL,
    "Rarity" VARCHAR NOT NULL

--     CONSTRAINT "FK_TypeId" FOREIGN KEY ("TypeId") REFERENCES "types" ("TypesId") ON DELETE NO ACTION ON UPDATE NO ACTION
--     CONSTRAINT "FK_Rarity" FOREIGN KEY ("Rarity") REFERENCES "rarity" ("TypesId") ON DELETE NO ACTION ON UPDATE NO ACTION
);

    CREATE INDEX "IFK_TypesId" ON "types" ("TypesId");


INSERT INTO "cards" VALUES (1,'3WB','Naomi Pillar of Order','Joshua Raphael',548542,2);
INSERT INTO "cards" VALUES (2,'1UB','Satoru Umezawa','Anna Pavleeva',548547,3);
INSERT INTO "cards" VALUES (3,'1','Sol Ring','Mike Bierek',509343,2);
INSERT INTO "cards" VALUES (4,'U','Fading Hope','Rovina Cai',534812,2);
INSERT INTO "cards" VALUES (5,'8','Ugin, the Spirit Dragon','Raymond Swanland',485324,4);
INSERT INTO "cards" VALUES (6,'U','Ruin Crab','Simon Dominic',491705,2);
INSERT INTO "cards" VALUES (7,'1U','Maddening Cacophony','Magali Villeneuve',491697,3);
INSERT INTO "cards" VALUES (8,'2GU','Grolnok,The Omnivore','Simon Dominic',541112,3);
INSERT INTO "cards" VALUES (9,'4GG','Avabruck Caretaker','Heonhwa Choe',544749,4);
INSERT INTO "cards" VALUES (10,'2BB','Sorin, the Mirthless','Bastien L. Deharme',544414,4);
INSERT INTO "cards" VALUES (11,'L','Sokencan, Crucible of Defiance','Lucas Staniec',551786,3);
INSERT INTO "cards" VALUES (12,'L','Otawara, Soaring City','Alayna Danner',551785,3);
INSERT INTO "cards" VALUES (13,'WUBRG','Sanctum of All','Johannes Voss',488280,3);
INSERT INTO "cards" VALUES (14,'GW','Satsuki, the Living Lore','domco',552273,3);
INSERT INTO "cards" VALUES (15,'3GGUU','Koma, Cosmos Serpent','Jesper Ejsing',503837,4);
INSERT INTO "cards" VALUES (16,'5BR','Tibalt, Cosmic Imposter','Grzegorz Rutkowski',507137,4);
INSERT INTO "cards" VALUES (17,'1WB','Greasefang, Okiba Boss','Victor Adame Minguez',551765,3);

INSERT INTO "types" VALUES (1, 'Creature');
INSERT INTO "types" VALUES (2, 'Artifact');
INSERT INTO "types" VALUES (3, 'Instant');
INSERT INTO "types" VALUES (4, 'Planeswalker');
INSERT INTO "types" VALUES (5, 'Sorcery');
INSERT INTO "types" VALUES (6, 'Enchantment');
INSERT INTO "types" VALUES (7, 'Land');

INSERT INTO "coloridentity" VALUES (0, 'X');
INSERT INTO "coloridentity" VALUES (1, 'White');
INSERT INTO "coloridentity" VALUES (2, 'Black');
INSERT INTO "coloridentity" VALUES (3, 'Red');
INSERT INTO "coloridentity" VALUES (4, 'Blue');
INSERT INTO "coloridentity" VALUES (5, 'Green');
INSERT INTO "coloridentity" VALUES (6, 'Gold');
INSERT INTO "coloridentity" VALUES (7, 'Colorless');
INSERT INTO "coloridentity" VALUES (8, 'Green/Blue');
INSERT INTO "coloridentity" VALUES (9, 'Black/Red');

INSERT INTO "rarity" VALUES (1, 'Common');
INSERT INTO "rarity" VALUES (2, 'Uncommon');
INSERT INTO "rarity" VALUES (3, 'Rare');
INSERT INTO "rarity" VALUES (4, 'Mythic');
