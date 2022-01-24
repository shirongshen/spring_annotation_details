package com.itheima.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @version v1.0
 * @Desccription: 测试spring注解驱动开发的入门案例
 * @Date: 2022-01-23 10:33:34
 * @Author: 石荣申
 */
public class SpringAnnotationTest {

    public static void main(String[] args) {

        // 1.创建容器 (基于注解的创建方式),扫描指定包下的有@Config的类
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        // 2.根据Bean的id获取对象
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        // 3.执行操作
        jdbcTemplate.update("insert into account(name, money) values(?,?)","test",1234);
    }

}
