/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Trevor Fernandes
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentId", query = "SELECT s FROM Student s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "Student.findByStudentPhotoId", query = "SELECT s FROM Student s WHERE s.studentPhotoId = :studentPhotoId"),
    @NamedQuery(name = "Student.findByFirstName", query = "SELECT s FROM Student s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "Student.findByMiddleName", query = "SELECT s FROM Student s WHERE s.middleName = :middleName"),
    @NamedQuery(name = "Student.findByLastName", query = "SELECT s FROM Student s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "Student.findByReferenceNumber", query = "SELECT s FROM Student s WHERE s.referenceNumber = :referenceNumber"),
    @NamedQuery(name = "Student.findByEnrollmentNumber", query = "SELECT s FROM Student s WHERE s.enrollmentNumber = :enrollmentNumber"),
    @NamedQuery(name = "Student.findByAddress", query = "SELECT s FROM Student s WHERE s.address = :address"),
    @NamedQuery(name = "Student.findByDob", query = "SELECT s FROM Student s WHERE s.dob = :dob"),
    @NamedQuery(name = "Student.findByPlaceOfBirth", query = "SELECT s FROM Student s WHERE s.placeOfBirth = :placeOfBirth"),
    @NamedQuery(name = "Student.findByReligionId", query = "SELECT s FROM Student s WHERE s.religionId = :religionId"),
    @NamedQuery(name = "Student.findByEmailId", query = "SELECT s FROM Student s WHERE s.emailId = :emailId"),
    @NamedQuery(name = "Student.findByEmergencyContactPerson", query = "SELECT s FROM Student s WHERE s.emergencyContactPerson = :emergencyContactPerson"),
    @NamedQuery(name = "Student.findByEmergencyContactNumber", query = "SELECT s FROM Student s WHERE s.emergencyContactNumber = :emergencyContactNumber"),
    @NamedQuery(name = "Student.findByEducationalBackground", query = "SELECT s FROM Student s WHERE s.educationalBackground = :educationalBackground"),
    @NamedQuery(name = "Student.findByLanguages", query = "SELECT s FROM Student s WHERE s.languages = :languages"),
    @NamedQuery(name = "Student.findByHobbies", query = "SELECT s FROM Student s WHERE s.hobbies = :hobbies"),
    @NamedQuery(name = "Student.findByPlace", query = "SELECT s FROM Student s WHERE s.place = :place"),
    @NamedQuery(name = "Student.findByDate", query = "SELECT s FROM Student s WHERE s.date = :date"),
    @NamedQuery(name = "Student.count", query = "SELECT COUNT(s.studentId) FROM Student s"),
//    @NamedQuery(name = "Student.fetchPreviousStudentInLimit", query = "SELECT s FROM Student s WHERE s.studentId < :studentIdValue ORDER BY s.studentId"),
//    @NamedQuery(name = "Student.fetchPreviousStudentInLimit", query = "SELECT s FROM (SELECT st FROM Student st WHERE st.studentId < :studentIdValue ORDER BY st.studentId) s ORDER BY s.studentId"),
    @NamedQuery(name = "Student.fetchNextStudentInLimit", query = "SELECT s FROM Student s WHERE s.studentId > :studentIdValue ORDER BY s.studentId")})
public class Student implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="studentGenerator")
    @TableGenerator(name="studentGenerator", table="sqlite_sequence",
    pkColumnName="name", valueColumnName="seq",
    pkColumnValue="student", allocationSize=1)
    @Basic(optional = false)
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "student_photo_id")
    private String studentPhotoId;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "reference_number")
    private String referenceNumber;
    @Column(name = "enrollment_number")
    private String enrollmentNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "dob")
    private String dob;
    @Column(name = "place_of_birth")
    private String placeOfBirth;
    @Column(name = "religion_id")
    private Integer religionId;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "emergency_contact_person")
    private String emergencyContactPerson;
    @Column(name = "emergency_contact_number")
    private String emergencyContactNumber;
    @Column(name = "educational_background")
    private String educationalBackground;
    @Column(name = "languages")
    private String languages;
    @Column(name = "hobbies")
    private String hobbies;
    @Column(name = "place")
    private String place;
    @Column(name = "date")
    private String date;

    public Student() {
    }

    public Student(Integer studentId) {
        this.studentId = studentId;
    }

    public Student(Integer studentId, String firstName) {
        this.studentId = studentId;
        this.firstName = firstName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentPhotoId() {
        return studentPhotoId;
    }

    public void setStudentPhotoId(String studentPhotoId) {
        this.studentPhotoId = studentPhotoId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Integer getReligionId() {
        return religionId;
    }

    public void setReligionId(Integer religionId) {
        this.religionId = religionId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getEmergencyContactPerson() {
        return emergencyContactPerson;
    }

    public void setEmergencyContactPerson(String emergencyContactPerson) {
        this.emergencyContactPerson = emergencyContactPerson;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getEducationalBackground() {
        return educationalBackground;
    }

    public void setEducationalBackground(String educationalBackground) {
        this.educationalBackground = educationalBackground;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "premaanganmanager.base.controller.background.Student[ studentId=" + studentId + " ]";
    }
    
}
