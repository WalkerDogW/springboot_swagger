package site.javaee.springboot_swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tao
 * @create 2020/4/28 11:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户实体类")//swagger-models注释
public class User {
    @ApiModelProperty("用户名")//swagger-models 字段注释
    public String username;
    @ApiModelProperty("密码")
    public String password;
}
