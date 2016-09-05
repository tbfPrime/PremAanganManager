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
@Table(name = "teacher_family_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeacherFamilyInfo.findAll", query = "SELECT t FROM TeacherFamilyInfo t"),
    @NamedQuery(name = "TeacherFamilyInfo.findByTeacherFamilyInfoId", query = "SELECT t FROM TeacherFamilyInfo t WHERE t.teacherFamilyInfoId = :teacherFamilyInfoId"),
    @NamedQuery(name = "TeacherFamilyInfo.findByTeacherId", query = "SELECT t FROM TeacherFamilyInfo t WHERE t.teacherId = :teacherId"),
    @NamedQuery(name = "TeacherFamilyInfo.findByFamilyInfoId", query = "SELECT t FROM TeacherFamilyInfo t WHERE t.familyInfoId = :familyInfoId")})
public class TeacherFamilyInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "teacher_family_info_id")
    private Integer teacherFamilyInfoId;
    @Basic(optional = false)
    @Column(name = "teacher_id")
    private int teacherId;
    @Basic(optional = false)
    @Column(name = "family_info_id")
    private int familyInfoId;

    public TeacherFamilyInfo() {
    }

    public TeacherFamilyInfo(Integer teacherFamilyInfoId) {
        this.teacherFamilyInfoId = teacherFamilyInfoId;
    }

    public TeacherFamilyInfo(Integer teacherFamilyInfoId, int teacherId, int familyInfoId) {
        this.teacherFamilyInfoId = teacherFamilyInfoId;
        this.teacherId = teacherId;
        this.familyInfoId = familyInfoId;
    }

    public Integer getTeacherFamilyInfoId() {
        return teacherFamilyInfoId;
    }

    public void setTeacherFamilyInfoId(Integer teacherFamilyInfoId) {
        this.teacherFamilyInfoId = teacherFamilyInfoId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getFamilyInfoId() {
        return familyInfoId;
    }

    public void setFamilyInfoId(int familyInfoId) {
        this.familyInfoId = familyInfoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherFamilyInfoId != null ? teacherFamilyInfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeacherFamilyInfo)) {
            return false;
        }
        TeacherFamilyInfo other = (TeacherFamilyInfo) object;
        if ((this.teacherFamilyInfoId == null && other.teacherFamilyInfoId != null) || (this.teacherFamilyInfoId != null && !this.teacherFamilyInfoId.equals(other.teacherFamilyInfoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "premaanganmanager.base.controller.background.TeacherFamilyInfo[ teacherFamilyInfoId=" + teacherFamilyInfoId + " ]";
    }
    
}
