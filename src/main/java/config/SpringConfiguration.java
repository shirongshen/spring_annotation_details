package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @version v1.0
 * @Desccription: Spring的配置类相当于 applicationContext.xml的作用
 * @Date: 2022-01-23 10:14:55
 * @Author: 石荣申
 */
@Configuration
@Import(value = JdbcConfig.class)
public class SpringConfiguration {

}
