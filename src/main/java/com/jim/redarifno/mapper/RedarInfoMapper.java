package com.jim.redarifno.mapper;

import com.jim.redarifno.entity.RedarInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author JimLau
 * @version 1.0
 * @date 2020/7/8 20:10
 */
public interface RedarInfoMapper extends Mapper<RedarInfo>{

    @Select({"<script>",
            "SELECT * FROM redarInfo",
            "WHERE 1=1",
            "<when test='redarId             !=null'> AND  redarId              = #{redarId             } </when>",
            "<when test='sign             !=null'> AND  sign              = #{sign             } </when>",
            "</script>"})
    List<RedarInfo> query(RedarInfo redarInfo);


    @Insert("INSERT INTO `ctbtdemo`.`redarInfo`(`redarId`,`sign`, `content`) VALUES (#{redarId},#{sign},#{content})")
    void add(RedarInfo redarInfo);

    @Update("UPDATE `ctbtdemo`.`redarInfo` SET `redarId` = #{redarId},`sign` = #{sign}, `content` = #{content} WHERE `id` =#{id}")
    void update(RedarInfo redarInfo2);
}
