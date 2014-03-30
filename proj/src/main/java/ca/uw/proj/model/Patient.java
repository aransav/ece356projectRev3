/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.model;

/**
 *
 * @author siva
 */

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="_patient")
public class Patient implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(referencedColumnName = "id", name = "patient_id")
    private User u;
    
    @Column(name="health_card_no")
    private String healthCardNo;
    
    @Column(name="social_ins_no")
    private long socialInsNo;

    public Patient() {
    }

    public User getUser() {
        return u;
    }

    public void setUser(User u) {
        this.u = u;
    }

    public String getHealthCardNo() {
        return healthCardNo;
    }

    public void setHealthCardNo(String healthCardNo) {
        this.healthCardNo = healthCardNo;
    }

    public long getSocialInsNo() {
        return socialInsNo;
    }

    public void setSocialInsNo(long socialInsNo) {
        this.socialInsNo = socialInsNo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.u);
        hash = 97 * hash + Objects.hashCode(this.healthCardNo);
        hash = 97 * hash + (int) (this.socialInsNo ^ (this.socialInsNo >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patient other = (Patient) obj;
        if (!Objects.equals(this.u, other.u)) {
            return false;
        }
        if (!Objects.equals(this.healthCardNo, other.healthCardNo)) {
            return false;
        }
        if (this.socialInsNo != other.socialInsNo) {
            return false;
        }
        return true;
    }

}
