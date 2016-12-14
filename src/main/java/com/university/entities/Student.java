package com.university.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Student {
    private int id;
    private String fio;
    private int groupNumber;
    private String scolarship;
    private Date dateEnter;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fio")
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Basic
    @Column(name = "groupNumber")
    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Basic
    @Column(name = "scolarship")
    public String getScolarship() {
        return scolarship;
    }

    public void setScolarship(String scolarship) {
        this.scolarship = scolarship;
    }

    @Basic
    @Column(name = "date_enter")
    public Date getDateEnter() {
        return dateEnter;
    }

    public void setDateEnter(Date dateEnter) {
        this.dateEnter = dateEnter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (groupNumber != student.groupNumber) return false;
        if (fio != null ? !fio.equals(student.fio) : student.fio != null) return false;
        if (scolarship != null ? !scolarship.equals(student.scolarship) : student.scolarship != null) return false;
        if (dateEnter != null ? !dateEnter.equals(student.dateEnter) : student.dateEnter != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + groupNumber;
        result = 31 * result + (scolarship != null ? scolarship.hashCode() : 0);
        result = 31 * result + (dateEnter != null ? dateEnter.hashCode() : 0);
        return result;
    }
}
