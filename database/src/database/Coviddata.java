/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thamess
 */
@Entity
@Table(name = "COVIDDATA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coviddata.findAll", query = "SELECT c FROM Coviddata c"),
    @NamedQuery(name = "Coviddata.findById", query = "SELECT c FROM Coviddata c WHERE c.id = :id"),
    @NamedQuery(name = "Coviddata.findByYearnum", query = "SELECT c FROM Coviddata c WHERE c.yearnum = :yearnum"),
    @NamedQuery(name = "Coviddata.findByWeeknum", query = "SELECT c FROM Coviddata c WHERE c.weeknum = :weeknum"),
    @NamedQuery(name = "Coviddata.findByProvince", query = "SELECT c FROM Coviddata c WHERE c.province = :province"),
    @NamedQuery(name = "Coviddata.findByAge", query = "SELECT c FROM Coviddata c WHERE c.age = :age"),
    @NamedQuery(name = "Coviddata.findByAgeRange", query = "SELECT c FROM Coviddata c WHERE c.ageRange = :ageRange"),
    @NamedQuery(name = "Coviddata.findByOccupation", query = "SELECT c FROM Coviddata c WHERE c.occupation = :occupation"),
    @NamedQuery(name = "Coviddata.findByTyped", query = "SELECT c FROM Coviddata c WHERE c.typed = :typed"),
    @NamedQuery(name = "Coviddata.findByDeathCluster", query = "SELECT c FROM Coviddata c WHERE c.deathCluster = :deathCluster"),
    @NamedQuery(name = "Coviddata.findByUpdateDate", query = "SELECT c FROM Coviddata c WHERE c.updateDate = :updateDate")})
public class Coviddata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "YEARNUM")
    private Integer yearnum;
    @Column(name = "WEEKNUM")
    private Integer weeknum;
    @Size(max = 255)
    @Column(name = "PROVINCE")
    private String province;
    @Column(name = "AGE")
    private Integer age;
    @Size(max = 255)
    @Column(name = "AGE_RANGE")
    private String ageRange;
    @Size(max = 255)
    @Column(name = "OCCUPATION")
    private String occupation;
    @Size(max = 255)
    @Column(name = "TYPED")
    private String typed;
    @Size(max = 255)
    @Column(name = "DEATH_CLUSTER")
    private String deathCluster;
    @Size(max = 255)
    @Column(name = "UPDATE_DATE")
    private String updateDate;

    public Coviddata() {
    }

    public Coviddata(Integer id) {
        this.id = id;
    }

    public Coviddata(Integer id, Integer yearnum, Integer weeknum, String province, Integer age, String ageRange, String occupation, String typed, String deathCluster, String updateDate) {
        this.id = id;
        this.yearnum = yearnum;
        this.weeknum = weeknum;
        this.province = province;
        this.age = age;
        this.ageRange = ageRange;
        this.occupation = occupation;
        this.typed = typed;
        this.deathCluster = deathCluster;
        this.updateDate = updateDate;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYearnum() {
        return yearnum;
    }

    public void setYearnum(Integer yearnum) {
        this.yearnum = yearnum;
    }

    public Integer getWeeknum() {
        return weeknum;
    }

    public void setWeeknum(Integer weeknum) {
        this.weeknum = weeknum;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getTyped() {
        return typed;
    }

    public void setTyped(String typed) {
        this.typed = typed;
    }

    public String getDeathCluster() {
        return deathCluster;
    }

    public void setDeathCluster(String deathCluster) {
        this.deathCluster = deathCluster;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
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
        if (!(object instanceof Coviddata)) {
            return false;
        }
        Coviddata other = (Coviddata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Coviddata[ id=" + id + " ]";
    }
    
}
