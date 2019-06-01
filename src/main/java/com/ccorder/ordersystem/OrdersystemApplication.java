package com.ccorder.ordersystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ccorder.ordersystem")
public class OrdersystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdersystemApplication.class, args);
    }

}
