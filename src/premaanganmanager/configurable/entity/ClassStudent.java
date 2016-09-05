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
@Table(name = "class_student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClassStudent.findAll", query = "SELECT c FROM ClassStudent c"),
    @NamedQuery(name = "ClassStudent.findByClassStudentId", query = "SELECT c FROM ClassStudent c WHERE c.classStudentId = :classStudentId"),
    @NamedQuery(name = "ClassStudent.findByClassId", query = "SELECT c FROM ClassStudent c WHERE c.classId = :classId"),
    @NamedQuery(name = "ClassStudent.findByStudentId", query = "SELECT c FROM ClassStudent c WHERE c.studentId = :studentId")})
public class ClassStudent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "class_student_id")
    private Integer classStudentId;
    @Basic(optional = false)
    @Column(name = "class_id")
    private int classId;
    @Basic(optional = false)
    @Column(name = "student_id")
    private int studentId;

    public ClassStudent() {
    }

    public ClassStudent(Integer classStudentId) {
        this.classStudentId = classStudentId;
    }

    public ClassStudent(Integer classStudentId, int classId, int studentId) {
        this.classStudentId = classStudentId;
        this.classId = classId;
        this.studentId = studentId;
    }

    public Integer getClassStudentId() {
        return classStudentId;
    }

    public void setClassStudentId(Integer classStudentId) {
        this.classStudentId = classStudentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classStudentId != null ? classStudentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassStudent)) {
            return false;
        }
        ClassStudent other = (ClassStudent) object;
        if ((this.classStudentId == null && other.classStudentId != null) || (this.classStudentId != null && !this.classStudentId.equals(other.classStudentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "premaanganmanager.base.controller.background.ClassStudent[ classStudentId=" + classStudentId + " ]";
    }
    
}
