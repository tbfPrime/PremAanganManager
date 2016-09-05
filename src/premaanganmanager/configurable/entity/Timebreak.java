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
@Table(name = "timebreak")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timebreak.findAll", query = "SELECT t FROM Timebreak t"),
    @NamedQuery(name = "Timebreak.findByTimebreakId", query = "SELECT t FROM Timebreak t WHERE t.timebreakId = :timebreakId"),
    @NamedQuery(name = "Timebreak.findByTimebreakDuration", query = "SELECT t FROM Timebreak t WHERE t.timebreakDuration = :timebreakDuration")})
public class Timebreak implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "timebreak_id")
    private Integer timebreakId;
    @Basic(optional = false)
    @Column(name = "timebreak_duration")
    private int timebreakDuration;

    public Timebreak() {
    }

    public Timebreak(Integer timebreakId) {
        this.timebreakId = timebreakId;
    }

    public Timebreak(Integer timebreakId, int timebreakDuration) {
        this.timebreakId = timebreakId;
        this.timebreakDuration = timebreakDuration;
    }

    public Integer getTimebreakId() {
        return timebreakId;
    }

    public void setTimebreakId(Integer timebreakId) {
        this.timebreakId = timebreakId;
    }

    public int getTimebreakDuration() {
        return timebreakDuration;
    }

    public void setTimebreakDuration(int timebreakDuration) {
        this.timebreakDuration = timebreakDuration;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timebreakId != null ? timebreakId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timebreak)) {
            return false;
        }
        Timebreak other = (Timebreak) object;
        if ((this.timebreakId == null && other.timebreakId != null) || (this.timebreakId != null && !this.timebreakId.equals(other.timebreakId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "premaanganmanager.base.controller.background.Timebreak[ timebreakId=" + timebreakId + " ]";
    }
    
}
