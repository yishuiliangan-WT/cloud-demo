package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component  //注入到spring容器
@ConfigurationProperties(prefix = "pattern")  //约定大于配置，完成属性的注入
public class PatternProperties {
    private String dateformat;
    private String envSharedValue;
    private String name;
}
