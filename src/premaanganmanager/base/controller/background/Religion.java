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
@Table(name = "religion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Religion.findAll", query = "SELECT r FROM Religion r"),
    @NamedQuery(name = "Religion.findByReligionId", query = "SELECT r FROM Religion r WHERE r.religionId = :religionId"),
    @NamedQuery(name = "Religion.findByReligionName", query = "SELECT r FROM Religion r WHERE r.religionName = :religionName")})
public class Religion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="religionGenerator")
    @TableGenerator(name="religionGenerator", table="sqlite_sequence",
    pkColumnName="name", valueColumnName="seq",
    pkColumnValue="religion", allocationSize=1)
    @Basic(optional = false)
    @Column(name = "religion_id")
    private Integer religionId;
    @Column(name = "religion_name")
    private String religionName;

    public Religion() {
    }

    public Religion(Integer religionId) {
        this.religionId = religionId;
    }

    public Integer getReligionId() {
        return religionId;
    }

    public void setReligionId(Integer religionId) {
        this.religionId = religionId;
    }

    public String getReligionName() {
        return religionName;
    }

    public void setReligionName(String religionName) {
        this.religionName = religionName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (religionId != null ? religionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Religion)) {
            return false;
        }
        Religion other = (Religion) object;
        if ((this.religionId == null && other.religionId != null) || (this.religionId != null && !this.religionId.equals(other.religionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return religionName;
    }
    
}
