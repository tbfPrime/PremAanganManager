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
@Table(name = "application_labels")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApplicationLabels.findAll", query = "SELECT a FROM ApplicationLabels a"),
    @NamedQuery(name = "ApplicationLabels.findById", query = "SELECT a FROM ApplicationLabels a WHERE a.id = :id"),
    @NamedQuery(name = "ApplicationLabels.findByTag", query = "SELECT a FROM ApplicationLabels a WHERE a.tag = :tag"),
    @NamedQuery(name = "ApplicationLabels.findByValue", query = "SELECT a FROM ApplicationLabels a WHERE a.value = :value"),
    @NamedQuery(name = "ApplicationLabels.findByDefaultValue", query = "SELECT a FROM ApplicationLabels a WHERE a.defaultValue = :defaultValue")})
public class ApplicationLabels implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tag")
    private String tag;
    @Column(name = "value")
    private String value;
    @Column(name = "default_value")
    private String defaultValue;

    public ApplicationLabels() {
    }

    public ApplicationLabels(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApplicationLabels)) {
            return false;
        }
        ApplicationLabels other = (ApplicationLabels) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "premaanganmanager.base.controller.background.ApplicationLabels[ id=" + id + " ]";
    }
    
}
