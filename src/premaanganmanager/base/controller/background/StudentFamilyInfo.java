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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Trevor Fernandes
 */
@Entity
@Table(name = "student_family_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentFamilyInfo.findAll", query = "SELECT s FROM StudentFamilyInfo s"),
    @NamedQuery(name = "StudentFamilyInfo.findByStudentFamilyInfoId", query = "SELECT s FROM StudentFamilyInfo s WHERE s.studentFamilyInfoId = :studentFamilyInfoId"),
    @NamedQuery(name = "StudentFamilyInfo.findByStudentId", query = "SELECT s FROM StudentFamilyInfo s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "StudentFamilyInfo.findByFamilyInfoId", query = "SELECT s FROM StudentFamilyInfo s WHERE s.familyInfoId = :familyInfoId")})
public class StudentFamilyInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="studentFamilyInfoGenerator")
    @TableGenerator(name="studentFamilyInfoGenerator", table="sqlite_sequence",
    pkColumnName="name", valueColumnName="seq",
    pkColumnValue="student_family_info", allocationSize=1)
    @Basic(optional = false)
    @Column(name = "student_family_info_id")
    private Integer studentFamilyInfoId;
    @Basic(optional = false)
    @Column(name = "student_id")
    private int studentId;
    @Basic(optional = false)
    @Column(name = "family_info_id")
    private int familyInfoId;

    public StudentFamilyInfo() {
    }

    public StudentFamilyInfo(Integer studentFamilyInfoId) {
        this.studentFamilyInfoId = studentFamilyInfoId;
    }

    public StudentFamilyInfo(Integer studentFamilyInfoId, int studentId, int familyInfoId) {
        this.studentFamilyInfoId = studentFamilyInfoId;
        this.studentId = studentId;
        this.familyInfoId = familyInfoId;
    }

    public Integer getStudentFamilyInfoId() {
        return studentFamilyInfoId;
    }

    public void setStudentFamilyInfoId(Integer studentFamilyInfoId) {
        this.studentFamilyInfoId = studentFamilyInfoId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
        hash += (studentFamilyInfoId != null ? studentFamilyInfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentFamilyInfo)) {
            return false;
        }
        StudentFamilyInfo other = (StudentFamilyInfo) object;
        if ((this.studentFamilyInfoId == null && other.studentFamilyInfoId != null) || (this.studentFamilyInfoId != null && !this.studentFamilyInfoId.equals(other.studentFamilyInfoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "premaanganmanager.base.controller.background.StudentFamilyInfo[ studentFamilyInfoId=" + studentFamilyInfoId + " ]";
    }
    
}
