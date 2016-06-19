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
@Table(name = "family_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FamilyInfo.findAll", query = "SELECT f FROM FamilyInfo f"),
    @NamedQuery(name = "FamilyInfo.findByFamilyInfoId", query = "SELECT f FROM FamilyInfo f WHERE f.familyInfoId = :familyInfoId"),
    @NamedQuery(name = "FamilyInfo.findByName", query = "SELECT f FROM FamilyInfo f WHERE f.name = :name"),
    @NamedQuery(name = "FamilyInfo.findByRelationship", query = "SELECT f FROM FamilyInfo f WHERE f.relationship = :relationship"),
    @NamedQuery(name = "FamilyInfo.findByAge", query = "SELECT f FROM FamilyInfo f WHERE f.age = :age"),
    @NamedQuery(name = "FamilyInfo.findByOccupation", query = "SELECT f FROM FamilyInfo f WHERE f.occupation = :occupation"),
    @NamedQuery(name = "FamilyInfo.findByOccupationalAddress", query = "SELECT f FROM FamilyInfo f WHERE f.occupationalAddress = :occupationalAddress"),
    @NamedQuery(name = "FamilyInfo.findByContactNumber", query = "SELECT f FROM FamilyInfo f WHERE f.contactNumber = :contactNumber")})
public class FamilyInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="familyInfoGenerator")
    @TableGenerator(name="familyInfoGenerator", table="sqlite_sequence",
    pkColumnName="name", valueColumnName="seq",
    pkColumnValue="family_info", allocationSize=1)
    @Basic(optional = false)
    @Column(name = "family_info_id")
    private Integer familyInfoId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "relationship")
    private String relationship;
    @Column(name = "age")
    private Integer age;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "occupational_address")
    private String occupationalAddress;
    @Column(name = "contact_number")
    private String contactNumber;

    public FamilyInfo() {
    }

    public FamilyInfo(Integer familyInfoId) {
        this.familyInfoId = familyInfoId;
    }

    public FamilyInfo(Integer familyInfoId, String name) {
        this.familyInfoId = familyInfoId;
        this.name = name;
    }

    public Integer getFamilyInfoId() {
        return familyInfoId;
    }

    public void setFamilyInfoId(Integer familyInfoId) {
        this.familyInfoId = familyInfoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOccupationalAddress() {
        return occupationalAddress;
    }

    public void setOccupationalAddress(String occupationalAddress) {
        this.occupationalAddress = occupationalAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (familyInfoId != null ? familyInfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FamilyInfo)) {
            return false;
        }
        FamilyInfo other = (FamilyInfo) object;
        if ((this.familyInfoId == null && other.familyInfoId != null) || (this.familyInfoId != null && !this.familyInfoId.equals(other.familyInfoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "premaanganmanager.base.controller.background.FamilyInfo[ familyInfoId=" + familyInfoId + " ]";
    }
    
}
