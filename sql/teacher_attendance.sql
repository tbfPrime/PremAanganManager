DROP TABLE IF EXISTS "teacher_attendance";
CREATE TABLE "teacher_attendance" ("teacher_attendance_id" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , "teacher_id" INTEGER NOT NULL , "present" BOOL NOT NULL , "date" DATETIME NOT NULL );
