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
@Table(name = "teacher_attendance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeacherAttendance.findAll", query = "SELECT t FROM TeacherAttendance t"),
    @NamedQuery(name = "TeacherAttendance.findByTeacherAttendanceId", query = "SELECT t FROM TeacherAttendance t WHERE t.teacherAttendanceId = :teacherAttendanceId"),
    @NamedQuery(name = "TeacherAttendance.findByTeacherId", query = "SELECT t FROM TeacherAttendance t WHERE t.teacherId = :teacherId"),
    @NamedQuery(name = "TeacherAttendance.findByPresent", query = "SELECT t FROM TeacherAttendance t WHERE t.present = :present"),
    @NamedQuery(name = "TeacherAttendance.findByDate", query = "SELECT t FROM TeacherAttendance t WHERE t.date = :date")})
public class TeacherAttendance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "teacher_attendance_id")
    private Integer teacherAttendanceId;
    @Basic(optional = false)
    @Column(name = "teacher_id")
    private int teacherId;
    @Basic(optional = false)
    @Column(name = "present")
    private int present;
    @Basic(optional = false)
    @Column(name = "date")
    private String date;

    public TeacherAttendance() {
    }

    public TeacherAttendance(Integer teacherAttendanceId) {
        this.teacherAttendanceId = teacherAttendanceId;
    }

    public TeacherAttendance(Integer teacherAttendanceId, int teacherId, int present, String date) {
        this.teacherAttendanceId = teacherAttendanceId;
        this.teacherId = teacherId;
        this.present = present;
        this.date = date;
    }

    public Integer getTeacherAttendanceId() {
        return teacherAttendanceId;
    }

    public void setTeacherAttendanceId(Integer teacherAttendanceId) {
        this.teacherAttendanceId = teacherAttendanceId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
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
        hash += (teacherAttendanceId != null ? teacherAttendanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeacherAttendance)) {
            return false;
        }
        TeacherAttendance other = (TeacherAttendance) object;
        if ((this.teacherAttendanceId == null && other.teacherAttendanceId != null) || (this.teacherAttendanceId != null && !this.teacherAttendanceId.equals(other.teacherAttendanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "premaanganmanager.base.controller.background.TeacherAttendance[ teacherAttendanceId=" + teacherAttendanceId + " ]";
    }
    
}
