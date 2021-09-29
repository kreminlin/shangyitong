package com.atguigu.shangyitong.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lzh
 */
@Data
public class ParamVo implements Serializable {

    @Pattern(regexp = "\\d{14}|\\d{17}[\\dxX]", message = "身份证号格式不正确")
    private String id;

    @NotBlank(message = "姓名必填")
    private String name;

    @NotNull(message = "年龄必填")
    private Integer age;

    @Size(min = 2, max = 10, message = "备注长度不正确")
    private String remark;

}
