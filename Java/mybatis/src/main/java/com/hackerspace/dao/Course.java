package com.hackerspace.dao;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tianx on 2016/2/29.
 */
@Entity
@Table(name = "t_course", schema = "db_hackerspace")
public class Course {
    private int couId;
    private int teacherId;
    private String couName;
    private String couBrief;
    private String couTime;
    private String couType;
    private int couCredit;
    private int couLimNum;
    private int couSelNum;
    private Boolean couOpen;

    @Id
    @Column(name = "cou_id")
    public int getCouId() {
        return couId;
    }

    public void setCouId(int couId) {
        this.couId = couId;
    }

    @Basic
    @Column(name = "teacher_id")
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "cou_name")
    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    @Basic
    @Column(name = "cou_brief")
    public String getCouBrief() {
        return couBrief;
    }

    public void setCouBrief(String couBrief) {
        this.couBrief = couBrief;
    }

    @Basic
    @Column(name = "cou_time")
    public String getCouTime() {
        return couTime;
    }

    public void setCouTime(String couTime) {
        this.couTime = couTime;
    }

    // mysql enum mapping hibernate; 但只对于mysql是正确的, 如果是其他的数据库, 很可能出现问题
    @Basic
    @Column(name = "cou_type", columnDefinition="enum('1', '2')")
    public String getCouType() {
        return couType;
    }

    public void setCouType(String couType) {
        this.couType = couType;
    }

    @Basic
    @Column(name = "cou_credit")
    public int getCouCredit() {
        return couCredit;
    }

    public void setCouCredit(int couCredit) {
        this.couCredit = couCredit;
    }

    @Basic
    @Column(name = "cou_lim_num")
    public int getCouLimNum() {
        return couLimNum;
    }

    public void setCouLimNum(int couLimNum) {
        this.couLimNum = couLimNum;
    }

    @Basic
    @Column(name = "cou_sel_num")
    public int getCouSelNum() {
        return couSelNum;
    }

    public void setCouSelNum(int couSelNum) {
        this.couSelNum = couSelNum;
    }

    @Basic
    @Column(name = "cou_open")
    public Boolean getCouOpen() {
        return couOpen;
    }

    public void setCouOpen(Boolean couOpen) {
        this.couOpen = couOpen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (couId != course.couId) return false;
        if (teacherId != course.teacherId) return false;
        if (couCredit != course.couCredit) return false;
        if (couLimNum != course.couLimNum) return false;
        if (couSelNum != course.couSelNum) return false;
        if (couName != null ? !couName.equals(course.couName) : course.couName != null) return false;
        if (couBrief != null ? !couBrief.equals(course.couBrief) : course.couBrief != null) return false;
        if (couTime != null ? !couTime.equals(course.couTime) : course.couTime != null) return false;
        if (couType != null ? !couType.equals(course.couType) : course.couType != null) return false;
        if (couOpen != null ? !couOpen.equals(course.couOpen) : course.couOpen != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = couId;
        result = 31 * result + teacherId;
        result = 31 * result + (couName != null ? couName.hashCode() : 0);
        result = 31 * result + (couBrief != null ? couBrief.hashCode() : 0);
        result = 31 * result + (couTime != null ? couTime.hashCode() : 0);
        result = 31 * result + (couType != null ? couType.hashCode() : 0);
        result = 31 * result + couCredit;
        result = 31 * result + couLimNum;
        result = 31 * result + couSelNum;
        result = 31 * result + (couOpen != null ? couOpen.hashCode() : 0);
        return result;
    }
}
