DROP TABLE IF EXISTS "timetable";
CREATE TABLE "timetable" ("timetable_id" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , "subject_id" INTEGER NOT NULL , "teacher_id" INTEGER, "duration" INTEGER, "breaktime1" INTEGER, "breaktime2" INTEGER, "breaktime3" INTEGER, "breaktime4" INTEGER);
