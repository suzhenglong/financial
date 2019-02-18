package com.suzl.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @Description:
 * @author: zhenglongsu@163.com
 * @date: 2018.08.21 16:38
 */
@EntityScan(basePackages = {"com.suzl.entity"})
@SpringBootApplication
public class ManagerApp {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApp.class, args);
    }

}
