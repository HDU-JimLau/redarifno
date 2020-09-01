package com.jim.redarifno.controller;

import com.jim.redarifno.entity.Redar;
import com.jim.redarifno.service.RedarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author JimLau
 * @version 1.0
 * @date 2020/7/13 16:42
 */
@RestController
public class RedarController {

    @Autowired
    private RedarService redarService;
    @GetMapping("list")
    public List<Redar> gerAll(Redar redar){
        return redarService.queryByAttr(redar);
    }
}
