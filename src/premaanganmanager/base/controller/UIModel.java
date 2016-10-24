/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.controller;

import premaanganmanager.configurable.entity.Religion;
import premaanganmanager.configurable.entity.ApplicationLabels;
import premaanganmanager.configurable.entity.StudentFamilyInfo;
import premaanganmanager.configurable.entity.Student;
import premaanganmanager.configurable.entity.FamilyInfo;
import premaanganmanager.configurable.entity.Users;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import premaanganmanager.configurable.entity.Teacher;

/**
 * @author Trevor Fernandes
 */
public class UIModel {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    /**
     * Creates all  DB Objects.
     */    
    public void createDBObjects(){
        Utility.log("UIModel | createDBObjects");
        emf = Persistence.createEntityManagerFactory("PremAanganManagerPU");
        em = emf.createEntityManager();
    }
    
    /**
     * Closes all  DB Objects.
     */
    public void closeDBObjects(){
        Utility.log("UIModel | closeDBObjects");
        em.close();
        emf.close();
    }
    
    /**
     * Check provided params are valid for login
     * @param username
     * @param password
     * @return 
     */
    public boolean isLoginCorrect(String username, String password){
        createDBObjects();

        Query q = em.createNamedQuery("Users.findByUsernamePassword");
        q.setParameter("username", username);
        q.setParameter("password", password);
        List<Users> result = q.getResultList();
        if(result.isEmpty()){ Utility.errorLog("UIModel | isLoginCorrect | Incorrect Login Credentails provided. Please re-check."); }

        closeDBObjects();
        return (result.size() > 0);
    }
    
    public Integer getStudentID(Student student){
        Utility.log("UIModel | getStudentID");
        
        createDBObjects();
        try{
            em.getTransaction();
            em.persist(student);
            em.flush();
            em.refresh(student);
            
            Utility.log("Value of Student ID: " + student.getStudentId());
            
            return student.getStudentId();
        } catch(Exception e){
            Utility.log("UIModel | getStudentID | Error fetching student ID. Message: " + e);
            return null;
        } finally{
            closeDBObjects();
        }
    }
    
    public boolean saveStudentForm(Student student){
        Utility.log("UIModel | saveStudentForm | student name: " + student.getFirstName() + " " + student.getMiddleName() + " " + student.getLastName() + " | id: " + student.getStudentId());
        
        createDBObjects();
        try{
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
            
            Utility.log("UIModel | saveStudentForm | Entry saved. | student ID: " + student.getStudentId());
            return true;
        } catch(Exception e){
            Utility.errorLog("UIModel | saveStudentForm | Error saving student data. Message: " + e);
            closeDBObjects();
            createDBObjects();
            return false;
        } finally{
            closeDBObjects();
        }
    }
    
    public boolean saveReligion(Religion religion){
        Utility.log("UIModel | saveReligion | religion name: " + religion.getReligionName());
        
        createDBObjects();
        try{
            em.getTransaction().begin();
            em.persist(religion);
            em.getTransaction().commit();
            
            Utility.log("UIModel | saveReligion | Entry saved.");
            return true;
        } catch(Exception e){
            Utility.errorLog("UIModel | saveReligion | Error saving religion data. Message: " + e);
            closeDBObjects();
            createDBObjects();
            return false;
        } finally{
            closeDBObjects();
        }
    }
    
    public boolean saveStudentFamilyInfo(FamilyInfo familyInfo, Student student){
        Utility.log("UIModel | saveStudentFamilyInfo | Entry for Family Member Name: " + familyInfo.getName() + " saved.");
        
        createDBObjects();
        try{
            em.getTransaction().begin();
            em.persist(familyInfo);
            em.getTransaction().commit();
            
            StudentFamilyInfo studentFamilyInfo = new StudentFamilyInfo();
            
            studentFamilyInfo.setFamilyInfoId(familyInfo.getFamilyInfoId());
            studentFamilyInfo.setStudentId(student.getStudentId());
            
            em.getTransaction().begin();
            em.persist(studentFamilyInfo);
            em.getTransaction().commit();
            
            Utility.log("UIModel | saveStudentFamilyInfo | Entry for Student: " + student.getFirstName() + ", with Family Member Name: " + familyInfo.getName() + " saved.");
            
            return true;
        } catch (Exception e){
            Utility.errorLog("UIModel | saveStudentFamilyInfo | Error creating Family info. Message" + e);
            closeDBObjects();
            createDBObjects();
            return false;
        } finally{
            closeDBObjects();
        }
    }
    
    public List<Student> fetchAllStudent(){
        Utility.log("UIModel | fetchAllStudent");
        
        createDBObjects();
        Query q = em.createNamedQuery("Student.findAll");
        List<Student> result = q.getResultList();
        Utility.log("UIModel | fetchAllStudent | result: " + result.size());
        
        closeDBObjects();
        return result;
    }
    
    public List<Student> fetchNextStudentInLimit(int studentIdValue, int limit){
        Utility.log("UIModel | fetchNextStudentInLimit | studentIdValue: " + studentIdValue + " | limit: " + limit);
        
        createDBObjects();
        Query q = em.createNamedQuery("Student.fetchNextStudentInLimit").setParameter("studentIdValue", studentIdValue).setMaxResults(limit);
        List<Student> result = q.getResultList();
        Utility.log("UIModel | fetchNextStudentInLimit | result count: " + result.size());
        
        closeDBObjects();
        return result;
    }
    
    public List<Student> fetchPreviousStudentInLimit(int studentIdValue, int limit){
        Utility.log("UIModel | fetchNextStudentInLimit | studentIdValue: " + studentIdValue + " | limit: " + limit);
        
        createDBObjects();
        Query q = em.createNativeQuery("SELECT * FROM (SELECT * FROM STUDENT WHERE student_id < ?1 ORDER BY student_id DESC LIMIT ?2) ORDER BY student_id", Student.class);
        
        q.setParameter(1, studentIdValue);
        q.setParameter(2, limit);
        
        List<Student> result = q.getResultList();
        Utility.log("UIModel | fetchNextStudentInLimit | result count: " + q.getResultList().size());
        
        closeDBObjects();
        return result;
    }
    
    public long fetchStudentCount(){
        Utility.log("UIModel | fetchStudentCount | ");
        
        createDBObjects();
        long result = (long)em.createNamedQuery("Student.count").getSingleResult();
        
        closeDBObjects();
        return result;
    }
    
    public List<Religion> fetchAllReligion(){
        Utility.log("UIModel | fetchAllReligion");

        createDBObjects();
        Query q = em.createNamedQuery("Religion.findAll");
        List<Religion> result = q.getResultList();
        
        closeDBObjects();
        return result;
    }
    
    /**
     * Fetch all application labels.
     * @return List of ApplicationLabels
     */      
    public List<ApplicationLabels> fetchAllLabels(){
        Utility.log("UIModel | fetchAllLabels");
        
        createDBObjects();
        
        Query rq = em.createNamedQuery("ApplicationLabels.findAll");
        List<ApplicationLabels> result = rq.getResultList();
        
        closeDBObjects();
        
        return result;
    }
    
    public Student fetchStudentByID(Integer studentID){
        Utility.log("UIModel | fetchStudentByID | studentID: " + studentID);
        
        createDBObjects();
        try{
            return (Student)em.createNamedQuery("Student.findByStudentId").setParameter("studentId", studentID).getSingleResult();
        } catch(Exception e){
            Utility.errorLog("UIModel | fetchStudentByID | Error: " + e);
            return null;
        } finally{
            closeDBObjects();
        }
    }
    
    public String fetchReligionNameByID(Integer religionID){
        Utility.log("UIModel | fetchReligionNameByID | religionID: " + religionID);
        
        createDBObjects();
        try{
            Religion r = (Religion)em.createNamedQuery("Religion.findByReligionId").setParameter("religionId", religionID).getSingleResult();
            return r.getReligionName();
        } catch(Exception e){
            Utility.errorLog("UIModel | fetchReligionNameByID | Error: " + e);
            return null;
        } finally{
            closeDBObjects();
        }
    }
    
    public FamilyInfo fetchFamilyInfoByID(Integer familyInfoID){
        Utility.log("UIModel | fetchFamilyInfoByID | familyInfoID: " + familyInfoID);
        
        createDBObjects();
        try{
            return (FamilyInfo)em.createNamedQuery("FamilyInfo.findByFamilyInfoId").setParameter("familyInfoId", familyInfoID).getSingleResult();
        } catch(Exception e){
            Utility.errorLog("UIModel | fetchFamilyInfoByID | Error: " + e);
            return null;
        } finally{
            closeDBObjects();
        }
    }
    
    public List<StudentFamilyInfo> fetchFamilyInfo(Integer studentID){
        Utility.log("UIModel | fetchFamilyInfo | studentID: " + studentID);
        
        createDBObjects();
        try{
            return em.createNamedQuery("StudentFamilyInfo.findByStudentId").setParameter("studentId", studentID).getResultList();
        } catch(Exception e){
            Utility.errorLog("UIModel | fetchFamilyInfo | Error: " + e);
            return null;
        } finally{
            closeDBObjects();
        }
    }
    
    public boolean saveTeacherForm(Teacher teacher){
        Utility.log("UIModel | saveTeacherForm | teacher name: " + teacher.getFirstName() + " " + teacher.getMiddleName() + " " + teacher.getLastName());
        
        createDBObjects();
        try{
            em.getTransaction().begin();
            em.persist(teacher);
            em.getTransaction().commit();
            
            Utility.log("UIModel | saveTeacherForm | Entry saved. | teacher ID: " + teacher.getTeacherId());
            return true;
        } catch(Exception e){
            Utility.errorLog("UIModel | saveTeacherForm | Error saving teacher data. Message: " + e);
            closeDBObjects();
            createDBObjects();
            return false;
        } finally{
            closeDBObjects();
        }
    }
    
    public List<Student> searchStudent(){
        Utility.log("UIModel | searchStudent");
        
        createDBObjects();
        try{
            return em.createNamedQuery("Student.findAll").getResultList();
        } catch(Exception e){
            Utility.errorLog("UIModel | searchStudent");
            return null;
        } finally{
            closeDBObjects();
        }
    }
}
