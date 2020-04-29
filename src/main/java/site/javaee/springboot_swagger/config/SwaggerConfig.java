package site.javaee.springboot_swagger.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
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
    @Bean
    public Docket docket(Environment environment){

        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev","test");
        //监听是否在设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                //自定义Swagger页面信息
                //.apiInfo(apiInfo())

                //接口文档分组
                .groupName("WalkerDog")

                //是否启动Swagger，如果为false则浏览器不能访问
                .enable(flag)

                //接口扫描配置
                .select()
                //RequestHandlerSelectors 配置要扫描接口的方式
                //basePackage-指定包   any-扫描所有   none-不扫描   withClassAnnotation(注解类)-扫描类上的注解
                .apis(RequestHandlerSelectors.basePackage("site.javaee.springboot_swagger.controller"))
                //过滤路径
                //.paths(PathSelectors.ant(""))
                .build();
    }


    //另一个组
    /*
    @Bean
    public Docket docketTony(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Tony");
    }

     */



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
