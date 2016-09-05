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
@Table(name = "teacher_photo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeacherPhoto.findAll", query = "SELECT t FROM TeacherPhoto t"),
    @NamedQuery(name = "TeacherPhoto.findByTeacherPhotoId", query = "SELECT t FROM TeacherPhoto t WHERE t.teacherPhotoId = :teacherPhotoId"),
    @NamedQuery(name = "TeacherPhoto.findByTeacherId", query = "SELECT t FROM TeacherPhoto t WHERE t.teacherId = :teacherId"),
    @NamedQuery(name = "TeacherPhoto.findByPhotoPath", query = "SELECT t FROM TeacherPhoto t WHERE t.photoPath = :photoPath")})
public class TeacherPhoto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "teacher_photo_id")
    private Integer teacherPhotoId;
    @Basic(optional = false)
    @Column(name = "teacher_id")
    private int teacherId;
    @Basic(optional = false)
    @Column(name = "photo_path")
    private String photoPath;

    public TeacherPhoto() {
    }

    public TeacherPhoto(Integer teacherPhotoId) {
        this.teacherPhotoId = teacherPhotoId;
    }

    public TeacherPhoto(Integer teacherPhotoId, int teacherId, String photoPath) {
        this.teacherPhotoId = teacherPhotoId;
        this.teacherId = teacherId;
        this.photoPath = photoPath;
    }

    public Integer getTeacherPhotoId() {
        return teacherPhotoId;
    }

    public void setTeacherPhotoId(Integer teacherPhotoId) {
        this.teacherPhotoId = teacherPhotoId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
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
        hash += (teacherPhotoId != null ? teacherPhotoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeacherPhoto)) {
            return false;
        }
        TeacherPhoto other = (TeacherPhoto) object;
        if ((this.teacherPhotoId == null && other.teacherPhotoId != null) || (this.teacherPhotoId != null && !this.teacherPhotoId.equals(other.teacherPhotoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "premaanganmanager.base.controller.background.TeacherPhoto[ teacherPhotoId=" + teacherPhotoId + " ]";
    }
    
}
