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
    public enum labelTag{
        // Common
// Common
        APPLICATION_TITLE, BACK, SAVE,
        MENU_HOME, MENU_BROWSE, MENU_ADD, MENU_SEARCH, MENU_SETTINGS,
        HEADER_LOGOUT, HEADER_SWITCH_ADMIN,
        HEADER_TITLE,
        
        ALERT_INFO, ALERT_WARNING, ALERT_ERROR, ALERT_CONFIRMATION,
        ALERT_MESSAGE_IS_EMPTY, ALERT_MESSAGE_CONFIRM_FIELD_EMPTY, 
        ALERT_MESSAGE_STUDENT_SAVE_SUCCESS, ALERT_MESSAGE_ERROR_SAVE,
        
        LABEL_END, LABEL_ID, LABEL_STUDENT_PHOTO_PREFIX, 
            
        // Login
        LOGIN_TITLE, LOGIN_SUBTITLE1, LOGIN_SUBTITLE2, LOGIN_HELP1, LOGIN_HELP2, LOGIN_ERROR1,
        GUEST, ADMIN,
        ADMIN1, ADMIN2, ADMIN3, PASSWORD, PASSWORD_PROMPT, LOGIN,
        
        // Home and 'About this software'
        HOME_TITLE, HOME_SUBTITLE1, HOME_SUBTITLE2, HOME_SUBTITLE3,
        HOME_ABOUT_THIS_SOFTWARE,
        
        // Add 
        ADD_STUDENT, ADD_TEACHER, ADD_SUBJECT, ADD_ATTENDANCE,
        ADD_COURSE, ADD_BATCH, ADD_CLASS, ADD_TIMETABLE,
        
        // Add Student
        ADD_STUDENT_FIRST_NAME, ADD_STUDENT_MIDDLE_NAME, ADD_STUDENT_LAST_NAME,
        ADD_STUDENT_ADDRESS, ADD_STUDENT_EMAIL, ADD_STUDENT_DATE_OF_BIRTH,
        ADD_STUDENT_PLACE_OF_BIRTH, ADD_STUDENT_RELIGION, ADD_STUDENT_OTHER_RELIGION,
        ADD_STUDENT_COURSE, ADD_STUDENT_EMERGENCY_CONTACT_PERSON, ADD_STUDENT_EMERGENCY_CONTACT_TEL_NO,
        ADD_STUDENT_EDUCATIONAL_BACKGROUND, ADD_STUDENT_LANGUAGES, ADD_STUDENT_HOBBIES,
        ADD_STUDENT_FAMILY_MEMBER_NAME, ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP, ADD_STUDENT_FAMILY_MEMBER_AGE,
        ADD_STUDENT_FAMILY_MEMBER_OCCUPATION, ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS, ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO,
        ADD_STUDENT_ENROLLMENT_NUMBER, ADD_STUDENT_PLACE, ADD_STUDENT_DATE,
        ADD_STUDENT_PHOTO, ADD_STUDENT_PERSONAL_DETAILS, ADD_STUDENT_OFFICE_USE_ONLY,
        ADD_STUDENT_FAMILY_DETAILS, ADD_STUDENT_EMERGENCY_CONTACT, ADD_STUDENT_PASSPORT_PHOTO,
        
        // Browse
        BROWSE_STUDENT, BROWSE_TEACHER
    }
    
    // List of all  labels used in PAM
    // Common labels.
    private String l_ApplicationTitle, l_Back, l_Save;
    private String l_MenuHome, l_MenuBrowse, l_MenuAdd, l_MenuSearch, l_MenuSettings;
    private String l_HeaderTitle, l_HeaderLogout, l_HeaderSwitchAdmin;
    private String l_AlertInfo, l_AlertWarning, l_AlertERROR, l_AlertConfirmation;
    private String l_AlertMessageIsEmpty, l_AlertMessageConfirmFieldEmpty;
    private String l_AlertMessageStudentSaveSuccess, l_AlertMessageErrorSave;
    private String l_LabelEnd, l_LabelID, l_LabelStudentPhotoPrefix;

    // Login
    private String l_LoginTitle, l_LoginSubtitle1, l_LoginSubtitle2, l_LoginHelp, l_Guest, l_Admin, l_Admin1, l_Admin2, l_Admin3, l_Key, l_PasswordPrompt, l_Login;
    
    // Home and 'About this software'
    private String l_HomeTitle, l_HomeSubtitle1, l_HomeSubtitle2, l_HomeSubtitle3, l_HomeAboutThisSoftware;
    
    // Add
    private String l_addStudent, l_addTeacher, l_addSubject, l_addAttendance, l_addCourse, l_addBatch, l_addClass, l_addTimetable;
    
    // Add Student
    private String l_addStudentFirstName, l_addStudentMiddleName, l_addStudentLastName;
    private String l_addStudentAddress, l_addStudentEmail, l_addStudentDOB;
    private String l_addStudentPlaceOfBirth, l_addStudentReligion, l_addStudentOtherReligion;
    private String l_addStudentCourse, l_addStudentEmergencyContactPerson, l_addStudentEmergencyContactTelNo;
    private String l_addStudentEducationalBackground, l_addStudentLanguages, l_addStudentHobbies;
    private String l_addStudentFamilyMemberName, l_addStudentFamilyMemberRelationship, l_addStudentFamilyMemberAge;
    private String l_addStudentFamilyMemberOccupation, l_addStudentFamilyMemberOccupationalAddress, l_addStudentFamilyMemberOccupationalTelNo;
    private String l_addStudentEnrollmentNumber, l_addStudentPlace, l_addStudentDate;
    private String l_addStudentPhoto, l_addStudentPersonalDetails, l_addStudentOfficeUseOnly;
    private String l_addStudentFamilyDetails, l_addStudentEmergencyContact, l_AddStudentPassportPhoto;
    
    // Browse
    private String l_browseStudent, l_browseTeacher;
    
    
    // public functions.
    public void setLabel(labelTag tag, String value){
        switch(tag){
            case APPLICATION_TITLE: l_ApplicationTitle = value; break;
            case BACK: l_Back = value; break;
            case SAVE: l_Save = value; break;
            
            case MENU_HOME: l_MenuHome = value; break;
            case MENU_BROWSE: l_MenuBrowse = value; break;
            case MENU_ADD: l_MenuAdd = value; break;
            case MENU_SEARCH: l_MenuSearch = value; break;
            case MENU_SETTINGS: l_MenuSettings = value; break;
            
            case HEADER_TITLE: l_HeaderTitle = value; break;
            case HEADER_LOGOUT: l_HeaderLogout = value; break;
            case HEADER_SWITCH_ADMIN: l_HeaderSwitchAdmin = value; break;
            
            case ALERT_INFO: l_AlertInfo = value; break;
            case ALERT_WARNING: l_AlertWarning = value; break;
            case ALERT_ERROR: l_AlertERROR = value; break;
            case ALERT_CONFIRMATION: l_AlertConfirmation = value; break;
            
            case ALERT_MESSAGE_IS_EMPTY: l_AlertMessageIsEmpty = value; break;
            case ALERT_MESSAGE_CONFIRM_FIELD_EMPTY: l_AlertMessageConfirmFieldEmpty = value; break;
            case ALERT_MESSAGE_STUDENT_SAVE_SUCCESS: l_AlertMessageStudentSaveSuccess = value; break;
            case ALERT_MESSAGE_ERROR_SAVE: l_AlertMessageErrorSave = value; break;
            
            case LABEL_END: l_LabelEnd = value; break;
            case LABEL_ID: l_LabelID = value; break;
            case LABEL_STUDENT_PHOTO_PREFIX: l_LabelStudentPhotoPrefix = value; break;

            case LOGIN_TITLE: l_LoginTitle = value; break;
            case LOGIN_SUBTITLE1: l_LoginSubtitle1 = value; break;
            case LOGIN_SUBTITLE2: l_LoginSubtitle2 = value; break;
            case LOGIN_HELP1: l_LoginHelp = value; break;
            case GUEST: l_Guest = value; break;
            case ADMIN: l_Admin = value; break;
            case ADMIN1: l_Admin1 = value; break;
            case ADMIN2: l_Admin2 = value; break;
            case ADMIN3: l_Admin3 = value; break;
            case PASSWORD: l_Key = value; break;
            case PASSWORD_PROMPT: l_PasswordPrompt = value; break;
            case LOGIN: l_Login = value; break;
            
            case HOME_TITLE: l_HomeTitle = value; break;
            case HOME_SUBTITLE1: l_HomeSubtitle1 = value; break;
            case HOME_SUBTITLE2: l_HomeSubtitle2 = value; break;
            case HOME_SUBTITLE3: l_HomeSubtitle3 = value; break;
            case HOME_ABOUT_THIS_SOFTWARE: l_HomeAboutThisSoftware = value; break;
            
            case ADD_STUDENT: l_addStudent = value; break;
            case ADD_TEACHER: l_addTeacher = value; break;
            case ADD_SUBJECT: l_addSubject = value; break;
            case ADD_ATTENDANCE: l_addAttendance = value; break;
            case ADD_COURSE: l_addCourse = value; break;
            case ADD_BATCH: l_addBatch = value; break;
            case ADD_CLASS: l_addClass = value; break;
            case ADD_TIMETABLE: l_addTimetable = value; break;
            
            case ADD_STUDENT_FIRST_NAME: l_addStudentFirstName = value; break;
            case ADD_STUDENT_MIDDLE_NAME: l_addStudentMiddleName = value; break;
            case ADD_STUDENT_LAST_NAME: l_addStudentLastName = value; break;
            case ADD_STUDENT_ADDRESS: l_addStudentAddress = value; break;
            case ADD_STUDENT_EMAIL: l_addStudentEmail = value; break;
            case ADD_STUDENT_DATE_OF_BIRTH: l_addStudentDOB = value; break;
            case ADD_STUDENT_PLACE_OF_BIRTH: l_addStudentPlaceOfBirth = value; break;
            case ADD_STUDENT_RELIGION: l_addStudentReligion = value; break;
            case ADD_STUDENT_OTHER_RELIGION: l_addStudentOtherReligion = value; break;
            case ADD_STUDENT_COURSE: l_addStudentCourse = value; break;
            case ADD_STUDENT_EMERGENCY_CONTACT_PERSON: l_addStudentEmergencyContactPerson = value; break;
            case ADD_STUDENT_EMERGENCY_CONTACT_TEL_NO: l_addStudentEmergencyContactTelNo = value; break;
            case ADD_STUDENT_EDUCATIONAL_BACKGROUND: l_addStudentEducationalBackground = value; break;
            case ADD_STUDENT_LANGUAGES: l_addStudentLanguages = value; break;
            case ADD_STUDENT_HOBBIES: l_addStudentHobbies = value; break;
            case ADD_STUDENT_FAMILY_MEMBER_NAME: l_addStudentFamilyMemberName = value; break;
            case ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP: l_addStudentFamilyMemberRelationship = value; break;
            case ADD_STUDENT_FAMILY_MEMBER_AGE: l_addStudentFamilyMemberAge = value; break;
            case ADD_STUDENT_FAMILY_MEMBER_OCCUPATION: l_addStudentFamilyMemberOccupation = value; break;
            case ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS: l_addStudentFamilyMemberOccupationalAddress = value; break;
            case ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO: l_addStudentFamilyMemberOccupationalTelNo = value; break;
            case ADD_STUDENT_ENROLLMENT_NUMBER: l_addStudentEnrollmentNumber = value; break;
            case ADD_STUDENT_PLACE: l_addStudentPlace = value; break;
            case ADD_STUDENT_DATE: l_addStudentDate = value; break;
            case ADD_STUDENT_PHOTO: l_addStudentPhoto = value; break;
            case ADD_STUDENT_PERSONAL_DETAILS: l_addStudentPersonalDetails = value; break;
            case ADD_STUDENT_OFFICE_USE_ONLY: l_addStudentOfficeUseOnly = value; break;
            case ADD_STUDENT_FAMILY_DETAILS: l_addStudentFamilyDetails = value; break;
            case ADD_STUDENT_EMERGENCY_CONTACT: l_addStudentEmergencyContact = value; break;
            case ADD_STUDENT_PASSPORT_PHOTO: l_AddStudentPassportPhoto = value; break;
            
            case BROWSE_STUDENT: l_browseStudent = value; break;
            case BROWSE_TEACHER: l_browseTeacher = value; break;
        }
    }
    
    public String getLabel(labelTag tag){
        switch(tag){
            case APPLICATION_TITLE: return l_ApplicationTitle; 
            case BACK: return l_Back;
            case SAVE: return l_Save;

            case MENU_HOME: return l_MenuHome;
            case MENU_BROWSE: return l_MenuBrowse;
            case MENU_ADD: return l_MenuAdd;
            case MENU_SEARCH: return l_MenuSearch;
            case MENU_SETTINGS: return l_MenuSettings;
            
            case HEADER_TITLE: return l_HeaderTitle;
            case HEADER_LOGOUT: return l_HeaderLogout;
            case HEADER_SWITCH_ADMIN: return l_HeaderSwitchAdmin;
            
            case ALERT_INFO: return l_AlertInfo;
            case ALERT_WARNING: return l_AlertWarning;
            case ALERT_ERROR: return l_AlertERROR;
            case ALERT_CONFIRMATION: return l_AlertConfirmation;
            
            case ALERT_MESSAGE_IS_EMPTY: return l_AlertMessageIsEmpty;
            case ALERT_MESSAGE_CONFIRM_FIELD_EMPTY: return l_AlertMessageConfirmFieldEmpty;
            case ALERT_MESSAGE_STUDENT_SAVE_SUCCESS: return l_AlertMessageStudentSaveSuccess;
            case ALERT_MESSAGE_ERROR_SAVE: return l_AlertMessageErrorSave;
            
            case LABEL_END: return l_LabelEnd;
            case LABEL_ID: return l_LabelID;
            case LABEL_STUDENT_PHOTO_PREFIX: return l_LabelStudentPhotoPrefix;
            
            case LOGIN_TITLE: return l_LoginTitle;
            case LOGIN_SUBTITLE1: return l_LoginSubtitle1;
            case LOGIN_SUBTITLE2: return l_LoginSubtitle2;
            case LOGIN_HELP1: return l_LoginHelp;
            case GUEST: return l_Guest;
            case ADMIN: return l_Admin;
            case ADMIN1: return l_Admin1;
            case ADMIN2: return l_Admin2;
            case ADMIN3: return l_Admin3;
            case PASSWORD: return l_Key;
            case PASSWORD_PROMPT: return l_PasswordPrompt;
            case LOGIN: return l_Login;
            
            case HOME_TITLE: return l_HomeTitle;
            case HOME_SUBTITLE1: return l_HomeSubtitle1;
            case HOME_SUBTITLE2: return l_HomeSubtitle2;
            case HOME_SUBTITLE3: return l_HomeSubtitle3;
            case HOME_ABOUT_THIS_SOFTWARE: return l_HomeAboutThisSoftware;
            
            case ADD_STUDENT: return l_addStudent;
            case ADD_TEACHER: return l_addTeacher;
            case ADD_SUBJECT: return l_addSubject;
            case ADD_ATTENDANCE: return l_addAttendance;
            case ADD_COURSE: return l_addCourse;
            case ADD_BATCH: return l_addBatch;
            case ADD_CLASS: return l_addClass;
            case ADD_TIMETABLE: return l_addTimetable;
            
            case ADD_STUDENT_FIRST_NAME: return l_addStudentFirstName;
            case ADD_STUDENT_MIDDLE_NAME: return l_addStudentMiddleName;
            case ADD_STUDENT_LAST_NAME: return l_addStudentLastName;
            case ADD_STUDENT_ADDRESS: return l_addStudentAddress;
            case ADD_STUDENT_EMAIL: return l_addStudentEmail;
            case ADD_STUDENT_DATE_OF_BIRTH: return l_addStudentDOB;
            case ADD_STUDENT_PLACE_OF_BIRTH: return l_addStudentPlaceOfBirth;
            case ADD_STUDENT_RELIGION: return l_addStudentReligion;
            case ADD_STUDENT_OTHER_RELIGION: return l_addStudentOtherReligion;
            case ADD_STUDENT_COURSE: return l_addStudentCourse;
            case ADD_STUDENT_EMERGENCY_CONTACT_PERSON: return l_addStudentEmergencyContactPerson;
            case ADD_STUDENT_EMERGENCY_CONTACT_TEL_NO: return l_addStudentEmergencyContactTelNo;
            case ADD_STUDENT_EDUCATIONAL_BACKGROUND: return l_addStudentEducationalBackground;
            case ADD_STUDENT_LANGUAGES: return l_addStudentLanguages;
            case ADD_STUDENT_HOBBIES: return l_addStudentHobbies;
            case ADD_STUDENT_FAMILY_MEMBER_NAME: return l_addStudentFamilyMemberName;
            case ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP: return l_addStudentFamilyMemberRelationship;
            case ADD_STUDENT_FAMILY_MEMBER_AGE: return l_addStudentFamilyMemberAge;
            case ADD_STUDENT_FAMILY_MEMBER_OCCUPATION: return l_addStudentFamilyMemberOccupation;
            case ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS: return l_addStudentFamilyMemberOccupationalAddress;
            case ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO: return l_addStudentFamilyMemberOccupationalTelNo;
            case ADD_STUDENT_ENROLLMENT_NUMBER: return l_addStudentEnrollmentNumber;
            case ADD_STUDENT_PLACE: return l_addStudentPlace;
            case ADD_STUDENT_DATE: return l_addStudentDate;
            case ADD_STUDENT_PHOTO: return l_addStudentPhoto;
            case ADD_STUDENT_PERSONAL_DETAILS: return l_addStudentPersonalDetails;
            case ADD_STUDENT_OFFICE_USE_ONLY: return l_addStudentOfficeUseOnly;
            case ADD_STUDENT_FAMILY_DETAILS: return l_addStudentFamilyDetails;
            case ADD_STUDENT_EMERGENCY_CONTACT: return l_addStudentEmergencyContact;
            case ADD_STUDENT_PASSPORT_PHOTO: return l_AddStudentPassportPhoto;
            
            case BROWSE_STUDENT: return l_browseStudent;
            case BROWSE_TEACHER: return l_browseTeacher;
        }
        return "NA";
    }
}
