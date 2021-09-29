package com.atguigu.shangyitong.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Class: DemoParam
 * @Author: YoniYuan
 * @Date: 2020-07-11 19:07
 * @Version: Angel
 */
@Data
public class Param {

    @NotBlank(message = "传入name不能为空")
    private String name;

    @NotNull(message = "传入age不能为空")
    private Integer age;
}
