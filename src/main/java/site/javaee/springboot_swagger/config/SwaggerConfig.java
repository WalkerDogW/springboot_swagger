package site.javaee.springboot_swagger.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author JunTao
 * @create 2020/4/28 6:46
 */
@Configuration
// 开启Swagger2的自动配置
@EnableSwagger2
public class SwaggerConfig {

    //Swagger实例Bean是Docket，所以通过配置Docket实例来配置Swaggger。
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    //通过apiInfo()属性配置文档信息
    private ApiInfo apiInfo(){
        Contact contact = new Contact("WalkerDogW","http://www.javaee.site","admin@javaee.site");
        return new ApiInfo(
                "Swagger学习", // 标题
                "学习演示如何配置Swagger", // 描述
                "v1.0", // 版本
                "http://terms.service.url/组织链接", // 组织链接
                contact, // 联系人信息
                "Apach 2.0 许可", // 许可
                "许可链接", // 许可连接
                new ArrayList<>()// 扩展
        );
    }


}
