CREATE TABLE "cards" (
    "TypeId" INT PRIMARY KEY NOT NULL,
    "ManaCost" INT NOT NULL,
    "Name" VARCHAR
);

CREATE TABLE "types" (
    "TypeId" INT NOT NULL,
    "Type" VARCHAR NOT NULL,

    CONSTRAINT "PK_Type" PRIMARY KEY ("TypeId"),
    CONSTRAINT "FK_TypesId" FOREIGN KEY ("TypeId") REFERENCES "cards" ("TypeId") ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE INDEX "IFK_TypesId" ON "types" ("TypeId");

INSERT INTO "cards" VALUES (1,5,'Naomi Pillar of Order');
INSERT INTO "cards" VALUES (2,3,'Satoru Umezawa');
INSERT INTO "cards" VALUES (3,2,'Sol Ring');



INSERT INTO "types" VALUES (1, 'Creature');