CREATE TABLE "cards" (
                         "TypeId" INT PRIMARY KEY NOT NULL,
                         "ManaCost" INT NOT NULL,
                         "Color" VARCHAR NOT NULL,
                         "Name" VARCHAR
);

CREATE TABLE "types" (
                         "TypeId" INT NOT NULL,
                         "Type" VARCHAR NOT NULL,
                         ""
                             CONSTRAINT "PK_Type" PRIMARY KEY ("TypeId"),
                         CONSTRAINT "FK_TypesId" FOREIGN KEY ("TypeId") REFERENCES "Artist" ("TypeId") ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE INDEX "IFK_TypesId" ON "types" ("TypeId");