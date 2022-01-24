package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @version v1.0
 * @Desccription: 和Jdbc相关的配置类
 * @Date: 2022-01-23 10:16:04
 * @Author: 石荣申
 */
// @PropertySource读取properties配置文件,这个注解可以写在主配置类(SpringConfiguration类)上,也可以写在JdbcConfig类上
@PropertySource(value = "classpath:jdbc.properties")
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    /**
     * 创建JdbcTemplate对象,并且存入IOC容器
     * @param dataSource Spring会自动传入参数(因为dataSource也是在IOC容器里的),不把握的话,你也可以加个@Autowired(优先按类型进行注入)注解给参数
     * @return
     */
    //@Bean支持指定bean的ID
    @Bean(value = "jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(@Autowired DataSource dataSource){
       return new JdbcTemplate(dataSource);
    }

    /**
     * 创建数据源,并存入IOC容器
     * @return
     */
    @Bean
    public DataSource createDataSource(){
        // 1.创建Spring的内置数据源对象
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // 2.给数据源提供必要参数
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        // 3.返回
        return dataSource;
    }
}
