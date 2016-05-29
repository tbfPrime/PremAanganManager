/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.controller.background;

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
@Table(name = "timetable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timetable.findAll", query = "SELECT t FROM Timetable t"),
    @NamedQuery(name = "Timetable.findByTimetableId", query = "SELECT t FROM Timetable t WHERE t.timetableId = :timetableId"),
    @NamedQuery(name = "Timetable.findBySubjectId", query = "SELECT t FROM Timetable t WHERE t.subjectId = :subjectId"),
    @NamedQuery(name = "Timetable.findByTeacherId", query = "SELECT t FROM Timetable t WHERE t.teacherId = :teacherId"),
    @NamedQuery(name = "Timetable.findByDuration", query = "SELECT t FROM Timetable t WHERE t.duration = :duration"),
    @NamedQuery(name = "Timetable.findByBreaktime1", query = "SELECT t FROM Timetable t WHERE t.breaktime1 = :breaktime1"),
    @NamedQuery(name = "Timetable.findByBreaktime2", query = "SELECT t FROM Timetable t WHERE t.breaktime2 = :breaktime2"),
    @NamedQuery(name = "Timetable.findByBreaktime3", query = "SELECT t FROM Timetable t WHERE t.breaktime3 = :breaktime3"),
    @NamedQuery(name = "Timetable.findByBreaktime4", query = "SELECT t FROM Timetable t WHERE t.breaktime4 = :breaktime4")})
public class Timetable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "timetable_id")
    private Integer timetableId;
    @Basic(optional = false)
    @Column(name = "subject_id")
    private int subjectId;
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "breaktime1")
    private Integer breaktime1;
    @Column(name = "breaktime2")
    private Integer breaktime2;
    @Column(name = "breaktime3")
    private Integer breaktime3;
    @Column(name = "breaktime4")
    private Integer breaktime4;

    public Timetable() {
    }

    public Timetable(Integer timetableId) {
        this.timetableId = timetableId;
    }

    public Timetable(Integer timetableId, int subjectId) {
        this.timetableId = timetableId;
        this.subjectId = subjectId;
    }

    public Integer getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(Integer timetableId) {
        this.timetableId = timetableId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getBreaktime1() {
        return breaktime1;
    }

    public void setBreaktime1(Integer breaktime1) {
        this.breaktime1 = breaktime1;
    }

    public Integer getBreaktime2() {
        return breaktime2;
    }

    public void setBreaktime2(Integer breaktime2) {
        this.breaktime2 = breaktime2;
    }

    public Integer getBreaktime3() {
        return breaktime3;
    }

    public void setBreaktime3(Integer breaktime3) {
        this.breaktime3 = breaktime3;
    }

    public Integer getBreaktime4() {
        return breaktime4;
    }

    public void setBreaktime4(Integer breaktime4) {
        this.breaktime4 = breaktime4;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timetableId != null ? timetableId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timetable)) {
            return false;
        }
        Timetable other = (Timetable) object;
        if ((this.timetableId == null && other.timetableId != null) || (this.timetableId != null && !this.timetableId.equals(other.timetableId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "premaanganmanager.base.controller.background.Timetable[ timetableId=" + timetableId + " ]";
    }
    
}
