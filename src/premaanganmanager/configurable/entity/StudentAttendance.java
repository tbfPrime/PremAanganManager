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
@Table(name = "student_attendance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentAttendance.findAll", query = "SELECT s FROM StudentAttendance s"),
    @NamedQuery(name = "StudentAttendance.findByStudentAttendanceId", query = "SELECT s FROM StudentAttendance s WHERE s.studentAttendanceId = :studentAttendanceId"),
    @NamedQuery(name = "StudentAttendance.findByStudentId", query = "SELECT s FROM StudentAttendance s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "StudentAttendance.findByPresent", query = "SELECT s FROM StudentAttendance s WHERE s.present = :present"),
    @NamedQuery(name = "StudentAttendance.findByDate", query = "SELECT s FROM StudentAttendance s WHERE s.date = :date")})
public class StudentAttendance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "student_attendance_id")
    private Integer studentAttendanceId;
    @Basic(optional = false)
    @Column(name = "student_id")
    private int studentId;
    @Basic(optional = false)
    @Column(name = "present")
    private int present;
    @Basic(optional = false)
    @Column(name = "date")
    private String date;

    public StudentAttendance() {
    }

    public StudentAttendance(Integer studentAttendanceId) {
        this.studentAttendanceId = studentAttendanceId;
    }

    public StudentAttendance(Integer studentAttendanceId, int studentId, int present, String date) {
        this.studentAttendanceId = studentAttendanceId;
        this.studentId = studentId;
        this.present = present;
        this.date = date;
    }

    public Integer getStudentAttendanceId() {
        return studentAttendanceId;
    }

    public void setStudentAttendanceId(Integer studentAttendanceId) {
        this.studentAttendanceId = studentAttendanceId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
        hash += (studentAttendanceId != null ? studentAttendanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentAttendance)) {
            return false;
        }
        StudentAttendance other = (StudentAttendance) object;
        if ((this.studentAttendanceId == null && other.studentAttendanceId != null) || (this.studentAttendanceId != null && !this.studentAttendanceId.equals(other.studentAttendanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "premaanganmanager.base.controller.background.StudentAttendance[ studentAttendanceId=" + studentAttendanceId + " ]";
    }
    
}
