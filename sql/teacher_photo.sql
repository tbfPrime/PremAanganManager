DROP TABLE IF EXISTS "teacher_photo";
CREATE TABLE "teacher_photo" ("teacher_photo_id" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , "teacher_id" INTEGER NOT NULL , "photo_path" TEXT NOT NULL );
