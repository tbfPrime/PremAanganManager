DROP TABLE IF EXISTS "family_info";
CREATE TABLE "family_info" (
"family_info_id" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL 
, "name" TEXT NOT NULL 
, "relationship" TEXT
, "age" INTEGER
, "occupation" TEXT
, "occupational_address" TEXT
, "contact_number" TEXT);