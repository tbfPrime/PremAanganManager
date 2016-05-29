DROP TABLE IF EXISTS "batch_class_course";
CREATE TABLE "batch_class_course" ("batch_class_course_id" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , "batch_id" INTEGER NOT NULL , "class_id" INTEGER NOT NULL , "course_id" INTEGER NOT NULL , "teacher_id" INTEGER);
