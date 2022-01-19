package com.atguigu.shangyitong.controller.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DrillOfHydrocarbonDTO {

    @ExcelProperty(value = "井深", index = 0)
    private String jinShen;

    @ExcelProperty(value = "钻时", index = 1)
    private String zuanShi;

    @ExcelProperty(value = "全烃", index = 2)
    private String quanTing;
}
