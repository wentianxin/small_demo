package com.hackerspace.dao;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by tianx on 2016/2/29.
 */
@Entity
@Table(name = "t_sd_apply", schema = "db_hackerspace")
public class SdApply {
    private int sdAId;
    private int teamId;
    private int sdTime;
    private Timestamp sdATime;
    private boolean sdASta;

    @Id
    @Column(name = "sd_a_id")
    public int getSdAId() {
        return sdAId;
    }

    public void setSdAId(int sdAId) {
        this.sdAId = sdAId;
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
    @Column(name = "sd_time")
    public int getSdTime() {
        return sdTime;
    }

    public void setSdTime(int sdTime) {
        this.sdTime = sdTime;
    }

    @Basic
    @Column(name = "sd_a_time")
    public Timestamp getSdATime() {
        return sdATime;
    }

    public void setSdATime(Timestamp sdATime) {
        this.sdATime = sdATime;
    }

    @Basic
    @Column(name = "sd_a_sta")
    public boolean isSdASta() {
        return sdASta;
    }

    public void setSdASta(boolean sdASta) {
        this.sdASta = sdASta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SdApply sdApply = (SdApply) o;

        if (sdAId != sdApply.sdAId) return false;
        if (teamId != sdApply.teamId) return false;
        if (sdTime != sdApply.sdTime) return false;
        if (sdASta != sdApply.sdASta) return false;
        if (sdATime != null ? !sdATime.equals(sdApply.sdATime) : sdApply.sdATime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sdAId;
        result = 31 * result + teamId;
        result = 31 * result + sdTime;
        result = 31 * result + (sdATime != null ? sdATime.hashCode() : 0);
        result = 31 * result + (sdASta ? 1 : 0);
        return result;
    }
}
