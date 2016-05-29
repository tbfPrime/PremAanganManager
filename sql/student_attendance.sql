DROP TABLE IF EXISTS "student_attendance";
CREATE TABLE "student_attendance" ("student_attendance_id" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , "student_id" INTEGER NOT NULL , "present" BOOL NOT NULL , "date" DATETIME NOT NULL );
