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
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "_appointment")
public class Appointment implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(referencedColumnName = "id")
    private DoctorPatient doctorPatient;

    @Column(name = "dateofapp")
    private Date dateOfApp;

    @Column(name = "comments", length = 1000)
    private String comments;

    @Column(name = "status")
    private String status;

    @Column(name = "schedlength")
    private int schedLength; //in minutes

    @Column(name = "proceduredesc")
    private String procedureDesc;

    public Appointment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DoctorPatient getDoctorPatient() {
        return doctorPatient;
    }

    public void setDoctorPatient(DoctorPatient doctorPatient) {
        this.doctorPatient = doctorPatient;
    }

    public Date getDateOfApp() {
        return dateOfApp;
    }

    public void setDateOfApp(Date dateOfApp) {
        this.dateOfApp = dateOfApp;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSchedLength() {
        return schedLength;
    }

    public void setSchedLength(int schedLength) {
        this.schedLength = schedLength;
    }

    public String getProcedureDesc() {
        return procedureDesc;
    }

    public void setProcedureDesc(String procedureDesc) {
        this.procedureDesc = procedureDesc;
    }

}
