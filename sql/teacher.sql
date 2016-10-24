DROP TABLE IF EXISTS "teacher";
CREATE TABLE "teacher" ("teacher_id" INTEGER PRIMARY KEY  NOT NULL ,"teacher_photo_id" TEXT,"first_name" TEXT NOT NULL ,"middle_name" TEXT,"last_name" TEXT,"address" TEXT,"dob" DATETIME,"email_id" TEXT,"emergency_contact_person" TEXT,"emergency_contact_number" INTEGER,"place" TEXT,"date" DATETIME,"salary" INTEGER,"date_of_resignation" DATETIME)
