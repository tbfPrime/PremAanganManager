DROP TABLE IF EXISTS "student";
CREATE TABLE "student" ("student_id" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , "student_photo_id" TEXT, "first_name" TEXT NOT NULL , "middle_name" TEXT, "last_name" TEXT, "enrollment_number" INTEGER,"address" TEXT, "dob" DATETIME, "place_of_birth" TEXT, "religion" TEXT, "other_religion" TEXT, "email_id" TEXT, "emergency_contact_person" TEXT, "emergency_contact_number" INTEGER, "educational_background" TEXT, "languages" TEXT, "hobbies" TEXT, "place" TEXT, "date" DATETIME);
