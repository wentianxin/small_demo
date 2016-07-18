package com.hackerspace.dao;

import javax.persistence.*;

/**
 * Created by tianx on 2016/2/29.
 */
@Entity
@Table(name = "t_studio", schema = "db_hackerspace")
public class Studio {
    private int sdId;
    private int sdNumber;
    private boolean sdOpen;

    @Id
    @Column(name = "sd_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getSdId() {
        return sdId;
    }

    public void setSdId(int sdId) {
        this.sdId = sdId;
    }

    @Basic
    @Column(name = "sd_number")
    public int getSdNumber() {
        return sdNumber;
    }

    public void setSdNumber(int sdNumber) {
        this.sdNumber = sdNumber;
    }

    @Basic
    @Column(name = "sd_open")
    public boolean isSdOpen() {
        return sdOpen;
    }

    public void setSdOpen(boolean sdOpen) {
        this.sdOpen = sdOpen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Studio studio = (Studio) o;

        System.out.println(false);
        if (sdId != studio.sdId) return false;
        if (sdNumber != studio.sdNumber) return false;
        if (sdOpen != studio.sdOpen) return false;

        System.out.println("true");
        return true;
    }

    @Override
    public int hashCode() {
        int result = sdId;
        result = 31 * result + sdNumber;
        result = 31 * result + (sdOpen ? 1 : 0);

        System.out.println(result);
        return result;
    }
}
