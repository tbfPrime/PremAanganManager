/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.controller.ui;

import premaanganmanager.base.controller.background.*;
import java.sql.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
//import javax.
/**
 *
 * @author Trevor Fernandes
 */
public class UIModel {
    private SqliteConnector o_SqliteConnector;
    private Connection o_Connection;
    private EntityManagerFactory emf;
    private EntityManager em;
    
    /**
     * Constructor to UIModel initializes connection to sqlite database.
     * @return 
     */
    public UIModel(){
        connectToSqliteDB();
    }
    
    
    /**
     * isDbConnected checks if the database is connected.
     * Returns true if successful and false otherwise.
     * @return 
     */
    public boolean isDbConnected(){
        try{
            return !o_Connection.isClosed();
        } catch(Exception e){
            System.out.println("UIModel | isDbConnected | " + e);
            return false;
        }
    }
    
    public boolean isLoginCorrect(String username, String password) throws SQLException{
        System.out.println("UIModel | isLoginCorrect | username: " + username + " | password: " + password);
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        String query = "select * from users where username = ? and password = ?";
        try{
            preparedStatement = o_Connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            result = preparedStatement.executeQuery();
            
            if(result.next()){ System.out.println("Login successful | username: " + username); return true; }
            else{ System.out.println("Login unSuccessful | username: " + username); return false; }
        } catch(Exception e){
            System.err.println("UIModel | isLoginCorrect | Error: " + e);
            return false;
        } finally{
            preparedStatement.close();
            result.close();
        }
    }
    
    public Integer getStudentID(Student student){
        System.out.println("UIModel | getStudentID");
        try{
            em.getTransaction();
            em.persist(student);
            em.flush();
            em.refresh(student);
            
            System.out.println("Value of Student ID: " + student.getStudentId());
            
            return student.getStudentId();
        } catch(Exception e){
            System.out.println("UIModel | getStudentID | Error fetching student ID. Message: " + e);
            return null;
        }        
    }
    
    public boolean saveStudentForm(Student student){
        try{
            System.out.println("UIModel | saveStudentForm | student name: " + student.getFirstName() + " " + student.getMiddleName() + " " + student.getLastName());
            
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
            
            System.out.println("UIModel | saveStudentForm | Entry saved.");
            return true;
        } catch(Exception e){
            System.err.println("UIModel | saveStudentForm | Error saving student data. Message: " + e);
            closeDBObjects();
            createDBObjects();
            return false;
        }
    }
    
    public boolean saveReligion(Religion religion){
        try{
            System.out.println("UIModel | saveReligion | religion name: " + religion.getReligionName());
            
            em.getTransaction().begin();
            em.persist(religion);
            em.getTransaction().commit();
            
            System.out.println("UIModel | saveReligion | Entry saved.");
            return true;
        } catch(Exception e){
            System.err.println("UIModel | saveReligion | Error saving religion data. Message: " + e);
            closeDBObjects();
            createDBObjects();
            return false;
        }
    }
    
    public boolean saveStudentFamilyInfo(FamilyInfo familyInfo, Student student){
        try{
            em.getTransaction().begin();
            em.persist(familyInfo);
            em.getTransaction().commit();
            
            System.out.println("UIModel | saveStudentFamilyInfo | Entry for Family Member Name: " + familyInfo.getName() + " saved.");
            
            StudentFamilyInfo studentFamilyInfo = new StudentFamilyInfo();
            
            studentFamilyInfo.setFamilyInfoId(familyInfo.getFamilyInfoId());
            studentFamilyInfo.setStudentId(student.getStudentId());
            
            em.getTransaction().begin();
            em.persist(studentFamilyInfo);
            em.getTransaction().commit();
            
            System.out.println("UIModel | saveStudentFamilyInfo | Entry for Student: " + student.getFirstName() + ", with Family Member Name: " + familyInfo.getName() + " saved.");
            
            return true;
        } catch (Exception e){
            System.err.println("UIModel | saveStudentFamilyInfo | Error creating Family info. Message" + e);
            closeDBObjects();
            createDBObjects();
            return false;
        }
    }
    
    public List<Student> fetchAllStudent(){
        System.out.println("UIModel | fetchAllStudent");
        
        Query q = em.createNamedQuery("Student.findAll");
        List<Student> result = q.getResultList();
        System.out.println("UIModel | fetchAllStudent | result: " + result.size());
        return result;
    }
    
    public List<Religion> fetchAllReligion(){
        System.out.println("UIModel | fetchAllReligion");
        
        Query q = em.createNamedQuery("Religion.findAll");
        List<Religion> result = q.getResultList();
        System.out.println("UIModel | fetchAllReligion");
        return result;
    }
    
    /**
     * Fetch all application labels.
     */      
    public List<ApplicationLabels> fetchAllLabels(){
        System.out.println("UIModel | fetchAllLabels");
        
        Query rq = em.createNamedQuery("ApplicationLabels.findAll");
        List<ApplicationLabels> result = rq.getResultList();
        return result;
    }
    
    public Student fetchStudentByID(Integer studentID){
        try{
            System.out.println("UIModel | fetchStudentByID | studentID: " + studentID);
            return (Student)em.createNamedQuery("Student.findByStudentId").setParameter("studentId", studentID).getSingleResult();
        } catch(Exception e){
            System.err.println("UIModel | fetchStudentByID | Error: " + e);
            return null;
        }
    }
    
    public String fetchReligionNameByID(Integer religionID){
        try{
            System.out.println("UIModel | fetchReligionNameByID | religionID: " + religionID);
            Religion r = (Religion)em.createNamedQuery("Religion.findByReligionId").setParameter("religionId", religionID).getSingleResult();
            return r.getReligionName();
        } catch(Exception e){
            System.err.println("UIModel | fetchReligionNameByID | Error: " + e);
            return null;
        }
    }
    
    public FamilyInfo fetchFamilyInfoByID(Integer familyInfoID){
        try{
            System.out.println("UIModel | fetchFamilyInfoByID | familyInfoID: " + familyInfoID);
            return (FamilyInfo)em.createNamedQuery("FamilyInfo.findByFamilyInfoId").setParameter("familyInfoId", familyInfoID).getSingleResult();
        } catch(Exception e){
            System.err.println("UIModel | fetchFamilyInfoByID | Error: " + e);
            return null;
        }
    }
    
    public List<StudentFamilyInfo> fetchFamilyInfo(Integer studentID){
        try{
            System.out.println("UIModel | fetchFamilyInfo | studentID: " + studentID);
            return em.createNamedQuery("StudentFamilyInfo.findByStudentId").setParameter("studentId", studentID).getResultList();
        } catch(Exception e){
            System.err.println("UIModel | fetchFamilyInfo | Error: " + e);
            return null;
        }
    }

    /**
     * Creates all  DB Objects.
     */    
    public void createDBObjects(){
        System.out.println("UIModel | createDBObjects");
        emf = Persistence.createEntityManagerFactory("PremAanganManagerPU");
        em = emf.createEntityManager();
    }
    
    /**
     * Closes all  DB Objects.
     */
    public void closeDBObjects(){
        System.out.println("UIModel | closeDBObjects");
        em.close();
        emf.close();
    }
    
    /**
     * connectToSqliteDB creates a connection to sqlite database.
     */
    private void connectToSqliteDB(){
        o_Connection = o_SqliteConnector.connector();        
        if(o_Connection == null){ System.exit(1);}
        else{ System.out.println("Connection Successful!"); }
    }
}
