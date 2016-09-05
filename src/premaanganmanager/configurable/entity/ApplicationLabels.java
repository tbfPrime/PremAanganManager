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
@Table(name = "application_labels")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApplicationLabels.findAll", query = "SELECT a FROM ApplicationLabels a"),
    @NamedQuery(name = "ApplicationLabels.findByApplicationLabelsId", query = "SELECT a FROM ApplicationLabels a WHERE a.applicationLabelsId = :applicationLabelsId"),
    @NamedQuery(name = "ApplicationLabels.findByTag", query = "SELECT a FROM ApplicationLabels a WHERE a.tag = :tag"),
    @NamedQuery(name = "ApplicationLabels.findByValue", query = "SELECT a FROM ApplicationLabels a WHERE a.value = :value"),
    @NamedQuery(name = "ApplicationLabels.findByDefaultValue", query = "SELECT a FROM ApplicationLabels a WHERE a.defaultValue = :defaultValue")})
public class ApplicationLabels implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "application_labels_id")
    private Integer applicationLabelsId;
    @Column(name = "tag")
    private String tag;
    @Column(name = "value")
    private String value;
    @Column(name = "default_value")
    private String defaultValue;

    public ApplicationLabels() {
    }

    public ApplicationLabels(Integer applicationLabelsId) {
        this.applicationLabelsId = applicationLabelsId;
    }

    public Integer getApplicationLabelsId() {
        return applicationLabelsId;
    }

    public void setApplicationLabelsId(Integer applicationLabelsId) {
        this.applicationLabelsId = applicationLabelsId;
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
        hash += (applicationLabelsId != null ? applicationLabelsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApplicationLabels)) {
            return false;
        }
        ApplicationLabels other = (ApplicationLabels) object;
        if ((this.applicationLabelsId == null && other.applicationLabelsId != null) || (this.applicationLabelsId != null && !this.applicationLabelsId.equals(other.applicationLabelsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "premaanganmanager.base.controller.background.ApplicationLabels[ applicationLabelsId=" + applicationLabelsId + " ]";
    }
    
}
