package com.jim.redarifno.service;

import com.jim.redarifno.entity.Redar;
import com.jim.redarifno.mapper.RedarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JimLau
 * @version 1.0
 * @date 2020/7/13 16:31
 */
@Service
public class RedarService {

    @Autowired(required = false)
    private RedarMapper redarMapper;

    public List<Redar> queryByAttr(Redar redar) {
        return redarMapper.select(redar);
    }
    public List<Redar> queryAll() {
        return redarMapper.selectAll();
    }
}
