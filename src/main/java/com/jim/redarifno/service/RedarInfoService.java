package com.jim.redarifno.service;

import com.jim.redarifno.entity.RedarInfo;
import com.jim.redarifno.mapper.RedarInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author JimLau
 * @version 1.0
 * @date 2020/7/8 20:12
 */
@Service
public class RedarInfoService {

    @Autowired(required = false)
    private RedarInfoMapper redarInfoMapper;

    public void updateSign() {

        RedarInfo redarInfo=new RedarInfo();
        // redarInfo.setId();
        redarInfo.setSign(1);
        //查询所有的未过期的雷达信息，即sign=1的雷达信息
        List<RedarInfo> redarInfos= redarInfoMapper.query(redarInfo);
        // List<RedarInfo> redarInfos=redarInfoMapper.selectBySign(1);

        // log.info(redarInfos.toString());
        if (!CollectionUtils.isEmpty(redarInfos)){
            List<Integer> ids = redarInfos.stream().map(redarInfo1 -> redarInfo1.getId()).collect(Collectors.toList());

            // log.info(ids.toString());
            //设置所有的sign=1的为0
            for (Integer id : ids) {
                //设置查询条件
                RedarInfo redarInfo1=new RedarInfo();
                redarInfo1.setId(id);
                redarInfo1.setSign(1);
                //开始查询
                List<RedarInfo> query = redarInfoMapper.query(redarInfo1);
                // List<RedarInfo> query = redarInfoMapper.select(redarInfo1);
                RedarInfo redarInfo2 = query.get(0);
                redarInfo2.setSign(0);
                redarInfoMapper.update(redarInfo2);
                // redarInfoMapper.updateByPrimaryKey(redarInfo2);
            }
        }
    }

    public void add(RedarInfo redarInfo) {

        // int insert = redarInfoMapper.insert(redarInfo);

        redarInfoMapper.add(redarInfo);
    }


}
