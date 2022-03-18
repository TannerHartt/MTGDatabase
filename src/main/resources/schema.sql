CREATE TABLE "cards" (
    "TypeId" INT PRIMARY KEY NOT NULL,
    "ManaCost" VARCHAR NOT NULL,
    "Name" VARCHAR NOT NULL,
    "Artist" VARCHAR NOT NULL,
    "Multiverse" LONG NOT NULL
);

-- CREATE TABLE "types" (
--     "TypeId" INT NOT NULL,
--     "Type" VARCHAR NOT NULL,
--
--     CONSTRAINT "PK_Type" PRIMARY KEY ("TypeId"),
--     CONSTRAINT "FK_TypesId" FOREIGN KEY ("TypeId") REFERENCES "cards" ("TypeId") ON DELETE NO ACTION ON UPDATE NO ACTION
-- );

-- CREATE INDEX "IFK_TypesId" ON "types" ("TypeId");

INSERT INTO "cards" VALUES (1,'3WB','Naomi Pillar of Order','Joshua Raphael',548542);
INSERT INTO "cards" VALUES (2,'1UB','Satoru Umezawa','Anna Pavleeva',548547);
INSERT INTO "cards" VALUES (3,'1','Sol Ring','Mike Bierek',554243);
INSERT INTO "cards" VALUES (4,'U','Fading Hope','Rovina Cai',534812);
INSERT INTO "cards" VALUES (5,'8','Ugin, the Spirit Dragon','Raymond Swanland',485324);
INSERT INTO "cards" VALUES (6,'U','Ruin Crab','Simon Dominic',491705);
INSERT INTO "cards" VALUES (7,'1U','Maddening Cacophony','Magali Villeneuve',491697);
INSERT INTO "cards" VALUES (8,'2GU','Grolnok,The Omnivore','Simon Dominic',541112);
INSERT INTO "cards" VALUES (9,'4GG','Avabruck Caretaker','Heonhwa Choe',544749);
INSERT INTO "cards" VALUES (10,'2BB','Sorin, the Mirthless','Bastien L. Deharme',544414);
INSERT INTO "cards" VALUES (11,'L','Sokencan, Crucible of Defiance','Lucas Staniec',551786);
INSERT INTO "cards" VALUES (12,'L','Otawara, Soaring City','Alayna Danner',551785);
INSERT INTO "cards" VALUES (13,'WUBRG','Sanctum of All','Johannes Voss',488280);
INSERT INTO "cards" VALUES (14,'GW','Satsuki, the Living Lore','domco',552273);
INSERT INTO "cards" VALUES (15,'3GGUU','Koma, Cosmos Serpent','Jesper Ejsing',503837);
INSERT INTO "cards" VALUES (16,'5BR','Tibalt, Cosmic Imposter','Grzegorz Rutkowski',507137);
INSERT INTO "cards" VALUES (17,'1WB','Greasefang, Okiba Boss','Victor Adame Minguez',551765);


-- INSERT INTO "types" VALUES (1,'Creature');