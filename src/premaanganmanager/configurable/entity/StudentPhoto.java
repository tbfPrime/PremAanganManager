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
@Table(name = "student_photo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentPhoto.findAll", query = "SELECT s FROM StudentPhoto s"),
    @NamedQuery(name = "StudentPhoto.findByStudentPhotoId", query = "SELECT s FROM StudentPhoto s WHERE s.studentPhotoId = :studentPhotoId"),
    @NamedQuery(name = "StudentPhoto.findByStudentId", query = "SELECT s FROM StudentPhoto s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "StudentPhoto.findByPhotoPath", query = "SELECT s FROM StudentPhoto s WHERE s.photoPath = :photoPath")})
public class StudentPhoto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "student_photo_id")
    private Integer studentPhotoId;
    @Basic(optional = false)
    @Column(name = "student_id")
    private int studentId;
    @Basic(optional = false)
    @Column(name = "photo_path")
    private String photoPath;

    public StudentPhoto() {
    }

    public StudentPhoto(Integer studentPhotoId) {
        this.studentPhotoId = studentPhotoId;
    }

    public StudentPhoto(Integer studentPhotoId, int studentId, String photoPath) {
        this.studentPhotoId = studentPhotoId;
        this.studentId = studentId;
        this.photoPath = photoPath;
    }

    public Integer getStudentPhotoId() {
        return studentPhotoId;
    }

    public void setStudentPhotoId(Integer studentPhotoId) {
        this.studentPhotoId = studentPhotoId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentPhotoId != null ? studentPhotoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentPhoto)) {
            return false;
        }
        StudentPhoto other = (StudentPhoto) object;
        if ((this.studentPhotoId == null && other.studentPhotoId != null) || (this.studentPhotoId != null && !this.studentPhotoId.equals(other.studentPhotoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "premaanganmanager.base.controller.background.StudentPhoto[ studentPhotoId=" + studentPhotoId + " ]";
    }
    
}
