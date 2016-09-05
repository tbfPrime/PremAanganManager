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
@Table(name = "timetable_class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TimetableClass.findAll", query = "SELECT t FROM TimetableClass t"),
    @NamedQuery(name = "TimetableClass.findByTimetableClassId", query = "SELECT t FROM TimetableClass t WHERE t.timetableClassId = :timetableClassId"),
    @NamedQuery(name = "TimetableClass.findByTimetableId", query = "SELECT t FROM TimetableClass t WHERE t.timetableId = :timetableId"),
    @NamedQuery(name = "TimetableClass.findByClassId", query = "SELECT t FROM TimetableClass t WHERE t.classId = :classId")})
public class TimetableClass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "timetable_class_id")
    private Integer timetableClassId;
    @Basic(optional = false)
    @Column(name = "timetable_id")
    private int timetableId;
    @Basic(optional = false)
    @Column(name = "class_id")
    private int classId;

    public TimetableClass() {
    }

    public TimetableClass(Integer timetableClassId) {
        this.timetableClassId = timetableClassId;
    }

    public TimetableClass(Integer timetableClassId, int timetableId, int classId) {
        this.timetableClassId = timetableClassId;
        this.timetableId = timetableId;
        this.classId = classId;
    }

    public Integer getTimetableClassId() {
        return timetableClassId;
    }

    public void setTimetableClassId(Integer timetableClassId) {
        this.timetableClassId = timetableClassId;
    }

    public int getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(int timetableId) {
        this.timetableId = timetableId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timetableClassId != null ? timetableClassId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimetableClass)) {
            return false;
        }
        TimetableClass other = (TimetableClass) object;
        if ((this.timetableClassId == null && other.timetableClassId != null) || (this.timetableClassId != null && !this.timetableClassId.equals(other.timetableClassId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "premaanganmanager.base.controller.background.TimetableClass[ timetableClassId=" + timetableClassId + " ]";
    }
    
}
