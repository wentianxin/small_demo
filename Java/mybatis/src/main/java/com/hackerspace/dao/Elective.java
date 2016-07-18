package com.hackerspace.dao;

import javax.persistence.*;

/**
 * Created by tianx on 2016/2/29.
 */
@Entity
@Table(name = "t_elective", schema = "db_hackerspace")
public class Elective {
    private int eleId;
    private int couId;
    private int stuId;
    private int stuScore;

    @Id
    @Column(name = "ele_id")
    public int getEleId() {
        return eleId;
    }

    public void setEleId(int eleId) {
        this.eleId = eleId;
    }

    @Basic
    @Column(name = "cou_id")
    public int getCouId() {
        return couId;
    }

    public void setCouId(int couId) {
        this.couId = couId;
    }

    @Basic
    @Column(name = "stu_id")
    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    @Basic
    @Column(name = "stu_score")
    public int getStuScore() {
        return stuScore;
    }

    public void setStuScore(int stuScore) {
        this.stuScore = stuScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Elective elective = (Elective) o;

        if (eleId != elective.eleId) return false;
        if (couId != elective.couId) return false;
        if (stuId != elective.stuId) return false;
        if (stuScore != elective.stuScore) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eleId;
        result = 31 * result + couId;
        result = 31 * result + stuId;
        result = 31 * result + stuScore;
        return result;
    }
}
