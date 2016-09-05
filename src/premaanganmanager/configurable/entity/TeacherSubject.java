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
@Table(name = "teacher_subject")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeacherSubject.findAll", query = "SELECT t FROM TeacherSubject t"),
    @NamedQuery(name = "TeacherSubject.findByTeacherSubjectId", query = "SELECT t FROM TeacherSubject t WHERE t.teacherSubjectId = :teacherSubjectId"),
    @NamedQuery(name = "TeacherSubject.findByTeacherId", query = "SELECT t FROM TeacherSubject t WHERE t.teacherId = :teacherId"),
    @NamedQuery(name = "TeacherSubject.findBySubjectId", query = "SELECT t FROM TeacherSubject t WHERE t.subjectId = :subjectId")})
public class TeacherSubject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "teacher_subject_id")
    private Integer teacherSubjectId;
    @Basic(optional = false)
    @Column(name = "teacher_id")
    private int teacherId;
    @Basic(optional = false)
    @Column(name = "subject_id")
    private int subjectId;

    public TeacherSubject() {
    }

    public TeacherSubject(Integer teacherSubjectId) {
        this.teacherSubjectId = teacherSubjectId;
    }

    public TeacherSubject(Integer teacherSubjectId, int teacherId, int subjectId) {
        this.teacherSubjectId = teacherSubjectId;
        this.teacherId = teacherId;
        this.subjectId = subjectId;
    }

    public Integer getTeacherSubjectId() {
        return teacherSubjectId;
    }

    public void setTeacherSubjectId(Integer teacherSubjectId) {
        this.teacherSubjectId = teacherSubjectId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherSubjectId != null ? teacherSubjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeacherSubject)) {
            return false;
        }
        TeacherSubject other = (TeacherSubject) object;
        if ((this.teacherSubjectId == null && other.teacherSubjectId != null) || (this.teacherSubjectId != null && !this.teacherSubjectId.equals(other.teacherSubjectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "premaanganmanager.base.controller.background.TeacherSubject[ teacherSubjectId=" + teacherSubjectId + " ]";
    }
    
}
