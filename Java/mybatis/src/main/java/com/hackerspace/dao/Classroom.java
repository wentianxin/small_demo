package com.hackerspace.dao;

import javax.persistence.*;

/**
 * Created by tianx on 2016/2/29.
 */
@Entity
@Table(name = "t_classroom", schema = "db_hackerspace")
public class Classroom {
    private int crId;
    private int crNumber;
    private boolean crOpen;

    @Id
    @Column(name = "cr_id")
    public int getCrId() {
        return crId;
    }

    public void setCrId(int crId) {
        this.crId = crId;
    }

    @Basic
    @Column(name = "cr_number")
    public int getCrNumber() {
        return crNumber;
    }

    public void setCrNumber(int crNumber) {
        this.crNumber = crNumber;
    }

    @Basic
    @Column(name = "cr_open")
    public boolean isCrOpen() {
        return crOpen;
    }

    public void setCrOpen(boolean crOpen) {
        this.crOpen = crOpen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Classroom classroom = (Classroom) o;

        if (crId != classroom.crId) return false;
        if (crNumber != classroom.crNumber) return false;
        if (crOpen != classroom.crOpen) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = crId;
        result = 31 * result + crNumber;
        result = 31 * result + (crOpen ? 1 : 0);
        return result;
    }
}
