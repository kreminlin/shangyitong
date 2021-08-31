package com.atguigu.shangyitong.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 分页--前端传参-条件查询
 */
@Data
public class HospitalSetVo {

    @ApiModelProperty(value = "医院名称")
    private String hosname;

    @ApiModelProperty(value = "医院编号")
    private String hoscode;

}
