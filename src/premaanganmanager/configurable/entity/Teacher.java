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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Trevor Fernandes
 */
@Entity
@Table(name = "teacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.findByTeacherId", query = "SELECT t FROM Teacher t WHERE t.teacherId = :teacherId"),
    @NamedQuery(name = "Teacher.findByTeacherPhotoId", query = "SELECT t FROM Teacher t WHERE t.teacherPhotoId = :teacherPhotoId"),
    @NamedQuery(name = "Teacher.findByFirstName", query = "SELECT t FROM Teacher t WHERE t.firstName = :firstName"),
    @NamedQuery(name = "Teacher.findByMiddleName", query = "SELECT t FROM Teacher t WHERE t.middleName = :middleName"),
    @NamedQuery(name = "Teacher.findByLastName", query = "SELECT t FROM Teacher t WHERE t.lastName = :lastName"),
    @NamedQuery(name = "Teacher.findByAddress", query = "SELECT t FROM Teacher t WHERE t.address = :address"),
    @NamedQuery(name = "Teacher.findByDob", query = "SELECT t FROM Teacher t WHERE t.dob = :dob"),
    @NamedQuery(name = "Teacher.findByPlaceOfBirth", query = "SELECT t FROM Teacher t WHERE t.placeOfBirth = :placeOfBirth"),
    @NamedQuery(name = "Teacher.findByReligion", query = "SELECT t FROM Teacher t WHERE t.religion = :religion"),
    @NamedQuery(name = "Teacher.findByOtherReligion", query = "SELECT t FROM Teacher t WHERE t.otherReligion = :otherReligion"),
    @NamedQuery(name = "Teacher.findByEmailId", query = "SELECT t FROM Teacher t WHERE t.emailId = :emailId"),
    @NamedQuery(name = "Teacher.findByEmergencyContactPerson", query = "SELECT t FROM Teacher t WHERE t.emergencyContactPerson = :emergencyContactPerson"),
    @NamedQuery(name = "Teacher.findByEmergencyContactNumber", query = "SELECT t FROM Teacher t WHERE t.emergencyContactNumber = :emergencyContactNumber"),
    @NamedQuery(name = "Teacher.findByEducationalBackground", query = "SELECT t FROM Teacher t WHERE t.educationalBackground = :educationalBackground"),
    @NamedQuery(name = "Teacher.findByLanguages", query = "SELECT t FROM Teacher t WHERE t.languages = :languages"),
    @NamedQuery(name = "Teacher.findByHobbies", query = "SELECT t FROM Teacher t WHERE t.hobbies = :hobbies"),
    @NamedQuery(name = "Teacher.findByPlace", query = "SELECT t FROM Teacher t WHERE t.place = :place"),
    @NamedQuery(name = "Teacher.findByDate", query = "SELECT t FROM Teacher t WHERE t.date = :date")})
public class Teacher implements Serializable {

    @Column(name = "date_of_resignation")
    private String dateOfResignation;

    @Column(name = "salary")
    private Integer salary;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Column(name = "teacher_photo_id")
    private String teacherPhotoId;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "dob")
    private String dob;
    @Column(name = "place_of_birth")
    private String placeOfBirth;
    @Column(name = "religion")
    private String religion;
    @Column(name = "other_religion")
    private String otherReligion;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "emergency_contact_person")
    private String emergencyContactPerson;
    @Column(name = "emergency_contact_number")
    private Integer emergencyContactNumber;
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

    public Teacher() {
    }

    public Teacher(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Teacher(Integer teacherId, String firstName) {
        this.teacherId = teacherId;
        this.firstName = firstName;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherPhotoId() {
        return teacherPhotoId;
    }

    public void setTeacherPhotoId(String teacherPhotoId) {
        this.teacherPhotoId = teacherPhotoId;
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

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getOtherReligion() {
        return otherReligion;
    }

    public void setOtherReligion(String otherReligion) {
        this.otherReligion = otherReligion;
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

    public Integer getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(Integer emergencyContactNumber) {
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
        hash += (teacherId != null ? teacherId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.teacherId == null && other.teacherId != null) || (this.teacherId != null && !this.teacherId.equals(other.teacherId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "premaanganmanager.base.controller.background.Teacher[ teacherId=" + teacherId + " ]";
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getDateOfResignation() {
        return dateOfResignation;
    }

    public void setDateOfResignation(String dateOfResignation) {
        this.dateOfResignation = dateOfResignation;
    }
    
}
