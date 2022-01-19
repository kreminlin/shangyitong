package com.atguigu.shangyitong.controller.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 原始测点
 *
 * @author LiuShuo
 * @since 2022-01-18
 */
@Data
public class OriginalPointDTO {

    @ExcelProperty(value = "测深",index = 1)
    private String ceShen;

    @ExcelProperty(value = "井斜", index = 2)
    private String jinXie;

    @ExcelProperty(value = "网格方位", index = 3)
    private String fangWei;

//    @ExcelProperty(value = "网格方位", index = 3)
//    private float fangWei;

}
