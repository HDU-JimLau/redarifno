package com.jim.redarifno.schedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.jim.redarifno.entity.RedarInfo;
import com.jim.redarifno.service.RedarInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author JimLau
 * @version 1.0
 * @date 2020/7/8 18:09
 */
@Component
@Slf4j
public class ScheduleTask {

    @Autowired
    private RedarInfoService redarInfoService;

    @Transactional
    @Scheduled(fixedRate = 60000*30)
    public void RedarScheduledTask() {

        // System.out.printf("执行命令");
        String[] cmds = {"curl","192.168.1.40:8080/api/v1/wsr/GetNowRadarTrackItem/tbkj02/1"};
        ProcessBuilder process = new ProcessBuilder(cmds);
        Process p;
        try {
            p = process.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }

            String content=builder.toString();

            if(!StringUtils.isEmpty(content)){
                //设置雷达信息
                RedarInfo redarInfo=new RedarInfo();

                redarInfo.setContent(content);
                redarInfo.setRedarId("tbkj02");
                redarInfo.setSign(1);

                //更新的雷达信息,将所有信息设置为过期
                redarInfoService.updateSign();

                //插入新的信息
                redarInfoService.add(redarInfo);
            }


            log.info("执行命令");



        } catch (IOException e) {
            System.out.print("error");
            e.printStackTrace();
        }
    }

}
