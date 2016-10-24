/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable;

/**
 *
 * @author Trevor Fernandes
 */
public class Labels {
    // public enum to tag lables from this file.
    public static enum labelTag{
        // Common
        APPLICATION_TITLE, BACK, SAVE, PRINT, HELP,
        HEADER_LOGOUT, HEADER_SWITCH_ADMIN, HEADER_HELP,
        
        HEADER_WELCOME_TITLE, HEADER_ADD_TITLE, HEADER_ADD_STUDENT_TITLE,
        HEADER_ADD_TEACHER_TITLE, HEADER_ADD_SUBJECT_TITLE, HEADER_ADD_ATTENDANCE_TITLE,
        HEADER_ADD_COURSE_TITLE, HEADER_ADD_BATCH_TITLE, HEADER_ADD_CLASS_TITLE,
        HEADER_ADD_TIMETABLE_TITLE, HEADER_BROWSE_TITLE, HEADER_BROWSE_STUDENT_TITLE,
        
        ALERT_INFO, ALERT_WARNING, ALERT_ERROR, ALERT_CONFIRMATION,
        ALERT_MESSAGE_IS_EMPTY, ALERT_MESSAGE_CONFIRM_FIELD_EMPTY, 
        ALERT_MESSAGE_STUDENT_SAVE_SUCCESS, ALERT_MESSAGE_TEACHER_SAVE_SUCCESS, ALERT_MESSAGE_ERROR_SAVE,
        ALERT_MESSAGE_EMAIL_FORMAT_INCORRECT, ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT,
        ALERT_MESSAGE_DOB_FORMAT_INCORRECT, ALERT_UNSAVED_DATA,
        
        HELP_ADD_STUDENT,
        
        LABEL_SEPERATOR, LABEL_ID, LABEL_STUDENT_PHOTO_PREFIX, LABEL_TEACHER_PHOTO_PREFIX, LABEL_OF, 
            
        // Login
        LOGIN_HELP1, LOGIN_HELP2, LOGIN_ERROR1,
        GUEST, ADMIN,
        ADMIN1, ADMIN2, ADMIN3, PASSWORD, PASSWORD_PROMPT, PASSWORD_PROMPT_FOR, LOGIN,
        
        // Home and 'About this software'
        
        // Add 
        ADD_NEW_RELIGION, ADD_PHOTO, 
        
        // Add Student
        ADD_STUDENT_FIRST_NAME, ADD_STUDENT_MIDDLE_NAME, ADD_STUDENT_LAST_NAME,
        ADD_STUDENT_ADDRESS, ADD_STUDENT_EMAIL, ADD_STUDENT_DATE_OF_BIRTH,
        ADD_STUDENT_PLACE_OF_BIRTH, ADD_STUDENT_RELIGION, ADD_STUDENT_OTHER_RELIGION,
        ADD_STUDENT_COURSE, ADD_STUDENT_EMERGENCY_CONTACT_PERSON, ADD_STUDENT_EMERGENCY_CONTACT_TEL_NO,
        ADD_STUDENT_EDUCATIONAL_BACKGROUND, ADD_STUDENT_LANGUAGES, ADD_STUDENT_HOBBIES,
        ADD_STUDENT_FAMILY_MEMBER_NAME, ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP, ADD_STUDENT_FAMILY_MEMBER_AGE,
        ADD_STUDENT_FAMILY_MEMBER_OCCUPATION, ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS, ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO,
        ADD_STUDENT_REFERENCE_NUMBER, ADD_STUDENT_ENROLLMENT_NUMBER, ADD_STUDENT_PLACE, ADD_STUDENT_DATE,
        ADD_STUDENT_PERSONAL_DETAILS, ADD_STUDENT_OFFICE_USE_ONLY,
        ADD_STUDENT_FAMILY_DETAILS, ADD_STUDENT_EMERGENCY_CONTACT,
        
        // Add Teacher
        ADD_TEACHER_PERSONAL_DETAILS, ADD_TEACHER_EMERGENCY_CONTACT, ADD_TEACHER_OFFICE_USE_ONLY,
        ADD_TEACHER_FIRST_NAME, ADD_TEACHER_MIDDLE_NAME, ADD_TEACHER_LAST_NAME,
        ADD_TEACHER_ADDRESS, ADD_TEACHER_EMAIL, ADD_TEACHER_DATE_OF_BIRTH,
        ADD_TEACHER_EMERGENCY_CONTACT_PERSON, ADD_TEACHER_EMERGENCY_CONTACT_TEL_NO,
        ADD_TEACHER_SALARY, ADD_TEACHER_DATE_OF_RESIGNATION,
        ADD_TEACHER_PLACE, ADD_TEACHER_DATE,
        
        // Browse
        BROWSE_STUDENT, BROWSE_TEACHER,
        BROWSE_PERSONAL_DETAILS, BROWSE_COURSE_DETAILS, BROWSE_EMERGENCY_CONTACT_DETAILS, BROWSE_FAMILY_MEMBER_DETAILS,
        BROWSE_PREVIOUS, BROWSE_NEXT,
        
        // Browse Student
        BROWSE_STUDENT_COURSE_NAME, BROWSE_STUDENT_CLASS_NAME;
        
        private String label = "NA";
        
        public void setLabel(String value){ label = value; }
        public String getLabel(){ return label; }
    }
    
    // public functions.
    public void setLabel(labelTag tag, String value){ tag.label = value; }
    public String getLabel(labelTag tag){ return tag.label; }
}
