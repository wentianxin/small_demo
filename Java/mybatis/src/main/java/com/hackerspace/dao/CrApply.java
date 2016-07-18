package com.hackerspace.dao;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by tianx on 2016/2/29.
 */
@Entity
@Table(name = "t_cr_apply", schema = "db_hackerspace")
public class CrApply {
    private int crAId;
    private int teamId;
    private int crATime;
    private Timestamp crTime;
    private int crOpen;

    @Id
    @Column(name = "cr_a_id")
    public int getCrAId() {
        return crAId;
    }

    public void setCrAId(int crAId) {
        this.crAId = crAId;
    }

    @Basic
    @Column(name = "team_id")
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Basic
    @Column(name = "cr_a_time")
    public int getCrATime() {
        return crATime;
    }

    public void setCrATime(int crATime) {
        this.crATime = crATime;
    }

    @Basic
    @Column(name = "cr_time")
    public Timestamp getCrTime() {
        return crTime;
    }

    public void setCrTime(Timestamp crTime) {
        this.crTime = crTime;
    }

    @Basic
    @Column(name = "cr_open")
    public int getCrOpen() {
        return crOpen;
    }

    public void setCrOpen(int crOpen) {
        this.crOpen = crOpen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CrApply crApply = (CrApply) o;

        if (crAId != crApply.crAId) return false;
        if (teamId != crApply.teamId) return false;
        if (crATime != crApply.crATime) return false;
        if (crOpen != crApply.crOpen) return false;
        if (crTime != null ? !crTime.equals(crApply.crTime) : crApply.crTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = crAId;
        result = 31 * result + teamId;
        result = 31 * result + crATime;
        result = 31 * result + (crTime != null ? crTime.hashCode() : 0);
        result = 31 * result + crOpen;
        return result;
    }
}
