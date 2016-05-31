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
        APPLICATION_TITLE, BACK, SAVE,
        MENU_HOME, MENU_BROWSE, MENU_ADD, MENU_SEARCH, MENU_SETTINGS,
        HEADER_LOGOUT, HEADER_SWITCH_ADMIN,
        HEADER_TITLE,
            
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
        
        // Browse
        BROWSE_STUDENT, BROWSE_TEACHER
    }
    
    // List of all  labels used in PAM
    // Common labels.
    private String l_ApplicationTitle, l_Back, l_Save;
    private String l_MenuHome, l_MenuBrowse, l_MenuAdd, l_MenuSearch, l_MenuSettings;
    private String l_HeaderTitle, l_HeaderLogout, l_HeaderSwitchAdmin;

    // Login
    private String l_LoginTitle, l_LoginSubtitle1, l_LoginSubtitle2, l_LoginHelp, l_Guest, l_Admin, l_Admin1, l_Admin2, l_Admin3, l_Key, l_PasswordPrompt, l_Login;
    
    // Home and 'About this software'
    private String l_HomeTitle, l_HomeSubtitle1, l_HomeSubtitle2, l_HomeSubtitle3, l_HomeAboutThisSoftware;
    
    // Add
    private String l_addStudent, l_addTeacher, l_addSubject, l_addAttendance, l_addCourse, l_addBatch, l_addClass, l_addTimetable;
    
    // Add Student
    private String l_addStudentFirstName, l_addStudentMiddleName, l_addStudentLastName;
    
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
            
            case BROWSE_STUDENT: return l_browseStudent;
            case BROWSE_TEACHER: return l_browseTeacher;
        }
        return "NA";
    }
}
