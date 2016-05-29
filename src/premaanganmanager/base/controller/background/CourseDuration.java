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
@Table(name = "course_duration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseDuration.findAll", query = "SELECT c FROM CourseDuration c"),
    @NamedQuery(name = "CourseDuration.findByCourseDurationId", query = "SELECT c FROM CourseDuration c WHERE c.courseDurationId = :courseDurationId"),
    @NamedQuery(name = "CourseDuration.findByCourseDurationValue", query = "SELECT c FROM CourseDuration c WHERE c.courseDurationValue = :courseDurationValue"),
    @NamedQuery(name = "CourseDuration.findByCourseTimings", query = "SELECT c FROM CourseDuration c WHERE c.courseTimings = :courseTimings")})
public class CourseDuration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "course_duration_id")
    private Integer courseDurationId;
    @Basic(optional = false)
    @Column(name = "course_duration_value")
    private int courseDurationValue;
    @Column(name = "course_timings")
    private String courseTimings;

    public CourseDuration() {
    }

    public CourseDuration(Integer courseDurationId) {
        this.courseDurationId = courseDurationId;
    }

    public CourseDuration(Integer courseDurationId, int courseDurationValue) {
        this.courseDurationId = courseDurationId;
        this.courseDurationValue = courseDurationValue;
    }

    public Integer getCourseDurationId() {
        return courseDurationId;
    }

    public void setCourseDurationId(Integer courseDurationId) {
        this.courseDurationId = courseDurationId;
    }

    public int getCourseDurationValue() {
        return courseDurationValue;
    }

    public void setCourseDurationValue(int courseDurationValue) {
        this.courseDurationValue = courseDurationValue;
    }

    public String getCourseTimings() {
        return courseTimings;
    }

    public void setCourseTimings(String courseTimings) {
        this.courseTimings = courseTimings;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseDurationId != null ? courseDurationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseDuration)) {
            return false;
        }
        CourseDuration other = (CourseDuration) object;
        if ((this.courseDurationId == null && other.courseDurationId != null) || (this.courseDurationId != null && !this.courseDurationId.equals(other.courseDurationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "premaanganmanager.base.controller.background.CourseDuration[ courseDurationId=" + courseDurationId + " ]";
    }
    
}
