package com.atguigu.shangyitong.controller.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class OriginalGammaVO {

    @ExcelProperty(value = "井深", index = 0)
    private String jinShen;

    @ExcelProperty(value = "GR", index = 1)
    private String gr;
}
