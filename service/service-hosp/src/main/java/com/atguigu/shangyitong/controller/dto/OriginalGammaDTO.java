package com.atguigu.shangyitong.controller.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class OriginalGammaDTO {

    @ExcelProperty(value = "井深", index = 0)
    private String jinShen;

    @ExcelProperty(value = "GR", index = 2)
    private String gr;
}
