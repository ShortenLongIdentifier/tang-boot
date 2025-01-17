package com.tang.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tang.commons.core.autoconfigure.TangProperties;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * swagger 配置
 *
 * @author Tang
 */
@Configuration
public class SwaggerConfig {

    private final TangProperties tangProperties;

    public SwaggerConfig(TangProperties tangProperties) {
        this.tangProperties = tangProperties;
    }

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info()
                .title("糖猫猫后台管理系统")
                .description("糖猫猫后台管理系统")
                .version("v" + tangProperties.getVersion())
            .license(new License()
                .name("MIT")
                .url("https://gitee.com/tangllty/tang-boot/blob/master/LICENSE"))
            .contact(new Contact()
                .name("Tang")
                .email("")
                .url("https://gitee.com/tangllty/tang-boot")));
    }

}
