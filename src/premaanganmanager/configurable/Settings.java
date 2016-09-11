/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.stage.Screen;
import premaanganmanager.base.controller.UIModel;
import premaanganmanager.base.controller.Utility;

/**
 * Settings class contains application global variables and get/set API to access them.
 * @author Trevor Fernandes
 */
public class Settings {
    // private member variables
    private final static String DIR_CSS = "/premaanganmanager/configurable/design/css/";       // Relative directory path for CSS files in string
    private final static String DIR_FXML = "/premaanganmanager/configurable/design/fxml/";     // Relative directory path for FXML files in string
    private final static String COMPONENT_CSS_FILENAME = "Common.css";                         // CSS filename from where common components css values will be read
    private final static String PLACEHOLDER_STUDENT_PHOTO = "addStudentPhotoPlaceHolder.jpg";
    private final static String PLACEHOLDER_TEACHER_PHOTO = "addTeacherPhotoPlaceHolder.jpg";
    private final static String TEMP_PHOTO_FILENAME = "tempPhoto";
    private final static String PLACEHOLDER_DIR = "resources\\placeholders";
    private final static String PHOTO_DIR = "photos";
    private final static String PNG_DIR = "resources\\png";
    private final static String ALERT_CSS = "Alerts.css";
    private final static String ADD_STUDENT_CSS = "AddStudent.css";
    private final static String ADD_TEACHER_CSS = "AddTeacher.css";
    private final static String COMMON_CSS = "Common.css";
    private final static String GUEST_USERNAME = "guest";
    private final static String GUEST_PASSWORD = "guest";
    private final static String ADMIN1_USERNAME = "admin1";
    private final static String ADMIN2_USERNAME = "admin2";
    private final static String ADMIN3_USERNAME = "admin3";
    private final static String PNG_ADD_STUDENT = "AddStudent.png";
    private final static String PNG_ADD_TEACHER = "AddTeacher.png";
    private final static String PNG_ADD_SUBJECT = "AddSubject.png";
    private final static String PNG_ADD_ATTENDANCE = "AddAttendance.png";
    private final static String PNG_ADD_COURSE = "AddCourse.png";
    private final static String PNG_ADD_BATCH = "AddBatch.png";
    private final static String PNG_ADD_CLASS = "AddClass.png";
    private final static String PNG_ADD_TIMETABLE = "AddTimetable.png";
    private final static String PNG_MENU_HOME = "MenuHome.png";
    private final static String PNG_MENU_ADD = "MenuAdd.png";
    private final static String PNG_MENU_BROWSE = "MenuBrowse.png";
    private final static String PNG_MENU_SEARCH = "MenuSearch.png";
    private final static String PNG_MENU_SETTINGS = "MenuSettings.png";
    private final static Date DOB_MIN = new GregorianCalendar(1950, Calendar.JANUARY, 01).getTime();
    private final static Date DOB_MAX = new GregorianCalendar(2012, Calendar.DECEMBER, 31).getTime();
    private final static int BUTTON_FONT_SIZE = 35;
    private final static int TABLE_MAX_ITEMS = 10;
    private final static int REFERENCE_NO_LENGTH = 10;
    private final static int ENROLLMENT_NO_LENGTH = 12;
    private final static int DEFAULT_MENU_ITEM = 1;

    private static BooleanProperty guestMode = new SimpleBooleanProperty(false);
    private static BooleanProperty flagDataUnsaved = new SimpleBooleanProperty(false);
    private static double appWidth;
    private static double appHeight;
    private static final screenTag [] menuTag = {                                              // This variable maintains the order and availability of Menu Items.
        screenTag.HOME,
        screenTag.ADD,
        screenTag.BROWSE,
        screenTag.SEARCH,
        screenTag.SETTINGS
    };
    public Labels labels;
    private static Labels.labelTag activeUserTag;
        
    
    public enum screenTag {
        LOGIN_GUEST_ADMIN(COMMON_CSS), 
        LOGIN_ADMIN(COMMON_CSS),
        
        HOME(COMMON_CSS),
        
        ADD(COMMON_CSS), 
        ADD_STUDENT(ADD_STUDENT_CSS), 
        ADD_TEACHER(ADD_TEACHER_CSS), 
        ADD_BATCH(COMMON_CSS), 
        ADD_CLASS(COMMON_CSS), 
        ADD_COURSE(COMMON_CSS), 
        ADD_SUBJECT(COMMON_CSS), 
        ADD_TIMETABLE(COMMON_CSS), 
        ADD_ATTENDANCE(COMMON_CSS),
        
        BROWSE(COMMON_CSS),
        SEARCH(COMMON_CSS),
        SETTINGS(COMMON_CSS);
        
        screenTag(String css){ this.CSS = css; }
        
        private String title;
        private String subtitle;
        private final String CSS;
        
        public void setTitle(String title){ this.title = title; }
        public void setSubtitle(String subtitle){ this.subtitle = subtitle; }
        
        public String getTitle(){ return title; }
        public String getSubtitle(){ return subtitle; }
        public String getCSS(){ return CSS; }
    }
    
    /**
     *
     * Initializes Application wide variables.
     */   
    public Settings(){
        labels = new Labels();
    }
    
    // initialize non-configurable variables here
    static {
        initializeSettings();
        setDefaultValuesToAllLabels();
    }
    
    public static final void initializeSettings(){
        Utility.log("Settings | initializeSettings");
        
        appWidth = Screen.getPrimary().getVisualBounds().getWidth() * 0.6;
        appHeight = Screen.getPrimary().getVisualBounds().getHeight() * 0.7;
        
        Utility.log("Settings | initializeSettings | appWidth: " + appWidth + " | appHeight: " + appHeight);
    }
    
    public static double getAppWidth(){ return appWidth; }    
    public static double getAppHeight(){ return appHeight; }
    public static Date getDOBMinimum(){ return DOB_MIN; }
    public static Date getDOBMaximum(){ return DOB_MAX; }
    public static int getTABLE_MAX_ITEMS(){ return TABLE_MAX_ITEMS; }
    public static int getDefaultButtonFontSize(){ return BUTTON_FONT_SIZE; }
    public static int getReferenceNoLength(){ return REFERENCE_NO_LENGTH; }
    public static int getEnrollmentNoLength(){ return ENROLLMENT_NO_LENGTH; }
    public static int getDefaultMenuIndex(){ return DEFAULT_MENU_ITEM; }
    
    public static String getAlertCSS(){ return ALERT_CSS; }
    public static String getCommonCSS(){ return COMMON_CSS; }
    public static String getCSSDir(){ return DIR_CSS; }
    public static String getFXMLDir(){ return DIR_FXML; }
    public static String getComponentCSSFilename(){ return COMPONENT_CSS_FILENAME; }
    public static String getPlaceHolderStudentPhoto(){ return PLACEHOLDER_STUDENT_PHOTO; }
    public static String getPlaceHolderTeacherPhoto(){ return PLACEHOLDER_TEACHER_PHOTO; }
    public static String getTempPhotoFilename(){ return TEMP_PHOTO_FILENAME; }
    public static String getPhotoDir(){ return PHOTO_DIR; }
    public static String getPNGDir(){ return PNG_DIR; }
    public static String getPlaceHolderDir(){ return PLACEHOLDER_DIR; }
    public static String getGuestUsername(){ return GUEST_USERNAME; }
    public static String getGuestPassword(){ return GUEST_PASSWORD; }
    public static String getAdmin1Username(){ return ADMIN1_USERNAME; }
    public static String getAdmin2Username(){ return ADMIN2_USERNAME; }
    public static String getAdmin3Username(){ return ADMIN3_USERNAME; }
    
    public static String getPNGAddStudent(){ return PNG_ADD_STUDENT; }
    public static String getPNGAddTeacher(){ return PNG_ADD_TEACHER; }
    public static String getPNGAddSubject(){ return PNG_ADD_SUBJECT; }
    public static String getPNGAddAttendance(){ return PNG_ADD_ATTENDANCE; }
    public static String getPNGAddCourse(){ return PNG_ADD_COURSE; }
    public static String getPNGAddBatch(){ return PNG_ADD_BATCH; }
    public static String getPNGAddClass(){ return PNG_ADD_CLASS; }
    public static String getPNGAddTimetable(){ return PNG_ADD_TIMETABLE; }
    public static String getPNGMenuHome(){ return PNG_MENU_HOME; }
    public static String getPNGMenuAdd(){ return PNG_MENU_ADD; }
    public static String getPNGMenuBrowse(){ return PNG_MENU_BROWSE; }
    public static String getPNGMenuSearch(){ return PNG_MENU_SEARCH; }
    public static String getPNGMenuSettings(){ return PNG_MENU_SETTINGS; }
    
    public static screenTag[] getMenuTags(){ return menuTag; }
    
    /**
     * API for guest mode
     * @param value 
     */
    public static void setGuestMode(boolean value){ guestMode.set(value); }
    public static boolean getGuestMode(){ return guestMode.get(); }
    public static BooleanProperty getGuestModeProperty(){ return guestMode; }
    
    /**
     * API for unsaved data
     * @param value 
     */
    public static void setFlagDataUnsaved(boolean value){ flagDataUnsaved.set(value); }
    public static boolean getFlagDataUnsaved(){ return flagDataUnsaved.get(); }
    public static BooleanProperty getFlagDataUnsavedProperty(){ return flagDataUnsaved; }

    /**
     * API to set active user for the app
     * @param tag 
     */
    public static void setActiveUserTag(Labels.labelTag tag){ activeUserTag = tag; }
    public static Labels.labelTag getActiveUserTag(){ return activeUserTag; }
        
    // private methods
    private static void setDefaultValuesToAllLabels(){
        new UIModel().fetchAllLabels().stream().forEach((tempLabels)->{
            try{Labels.labelTag.valueOf(tempLabels.getTag()).setLabel(tempLabels.getValue()); return; }
            catch(IllegalArgumentException e){ Utility.errorLog("Settings | setDefaultValuesToAllLabels | Label Error: " + e); }
            
            try{screenTag.valueOf(tempLabels.getTag().replace("_TITLE", "")).setTitle(tempLabels.getValue()); return; }
            catch(IllegalArgumentException e){ Utility.errorLog("Settings | setScreenLabels | UIControl | TITLE | IllegalArgumentException: " + e); }
            
            try{screenTag.valueOf(tempLabels.getTag().replace("_SUBTITLE", "")).setSubtitle(tempLabels.getValue()); }
            catch(IllegalArgumentException e){ Utility.errorLog("Settings | setScreenLabels | UIControl | SUBTITLE | IllegalArgumentException: " + e); }
        });
    }
}
