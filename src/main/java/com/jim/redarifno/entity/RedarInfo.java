package com.jim.redarifno.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author JimLau
 * @version 1.0
 * @date 2020/7/8 11:03
 */
@Data
@Table(name = "redarInfo")
public class RedarInfo {


    @Id
    @KeySql(useGeneratedKeys = true)
    private int id;

    @Column(name = "redarId")
    private String redarId;

    private String content;
    private int sign;
}
