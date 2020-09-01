package com.jim.redarifno.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author JimLau
 * @version 1.0
 * @date 2020/7/13 16:20
 */
@Data
@Table(name = "redar")
public class Redar {

    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "id")
    private String id;
    @Column(name = "endpoint")
    private String endpoint;
    private String indispatch;
    @Column(name = "last_update")
    private Date last_update;
    @Column(name = "online")
    private String online;
    private double lon;
    private double lat;
    private String alt;
    private String type;
    private String remark;
    @Column(name = "channel_2_config")
    private String channel_2_config;
    @Column(name = "channel_1_config")
    private String channel_1_config;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getIndispatch() {
        return indispatch;
    }

    public void setIndispatch(String indispatch) {
        this.indispatch = indispatch;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getChannel_2_config() {
        return channel_2_config;
    }

    public void setChannel_2_config(String channel_2_config) {
        this.channel_2_config = channel_2_config;
    }

    public String getChannel_1_config() {
        return channel_1_config;
    }

    public void setChannel_1_config(String channel_1_config) {
        this.channel_1_config = channel_1_config;
    }
}
