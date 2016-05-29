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
@Table(name = "batch_class_course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BatchClassCourse.findAll", query = "SELECT b FROM BatchClassCourse b"),
    @NamedQuery(name = "BatchClassCourse.findByBatchClassCourseId", query = "SELECT b FROM BatchClassCourse b WHERE b.batchClassCourseId = :batchClassCourseId"),
    @NamedQuery(name = "BatchClassCourse.findByBatchId", query = "SELECT b FROM BatchClassCourse b WHERE b.batchId = :batchId"),
    @NamedQuery(name = "BatchClassCourse.findByClassId", query = "SELECT b FROM BatchClassCourse b WHERE b.classId = :classId"),
    @NamedQuery(name = "BatchClassCourse.findByCourseId", query = "SELECT b FROM BatchClassCourse b WHERE b.courseId = :courseId"),
    @NamedQuery(name = "BatchClassCourse.findByTeacherId", query = "SELECT b FROM BatchClassCourse b WHERE b.teacherId = :teacherId")})
public class BatchClassCourse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "batch_class_course_id")
    private Integer batchClassCourseId;
    @Basic(optional = false)
    @Column(name = "batch_id")
    private int batchId;
    @Basic(optional = false)
    @Column(name = "class_id")
    private int classId;
    @Basic(optional = false)
    @Column(name = "course_id")
    private int courseId;
    @Column(name = "teacher_id")
    private Integer teacherId;

    public BatchClassCourse() {
    }

    public BatchClassCourse(Integer batchClassCourseId) {
        this.batchClassCourseId = batchClassCourseId;
    }

    public BatchClassCourse(Integer batchClassCourseId, int batchId, int classId, int courseId) {
        this.batchClassCourseId = batchClassCourseId;
        this.batchId = batchId;
        this.classId = classId;
        this.courseId = courseId;
    }

    public Integer getBatchClassCourseId() {
        return batchClassCourseId;
    }

    public void setBatchClassCourseId(Integer batchClassCourseId) {
        this.batchClassCourseId = batchClassCourseId;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (batchClassCourseId != null ? batchClassCourseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BatchClassCourse)) {
            return false;
        }
        BatchClassCourse other = (BatchClassCourse) object;
        if ((this.batchClassCourseId == null && other.batchClassCourseId != null) || (this.batchClassCourseId != null && !this.batchClassCourseId.equals(other.batchClassCourseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "premaanganmanager.base.controller.background.BatchClassCourse[ batchClassCourseId=" + batchClassCourseId + " ]";
    }
    
}
