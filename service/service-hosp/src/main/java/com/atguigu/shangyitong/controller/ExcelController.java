package com.atguigu.shangyitong.controller;

import com.atguigu.shangyitong.utils.CopyOfReadFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
@RequestMapping(value = "/excel")
public class ExcelController {

    /**
     * 解析spddev数据：sheet页为【原始测点】,所需数据为：测深，井斜，方位（2,3,4列数据删除）
     * 1.读取所有文件夹下：文件名为【水平井随钻分析数据图表】
     * 2.每解析完一个图表，生成一个文件，文件按文件夹名称 + SPD\SPDDEV\钻时全烃命名
     * 3.ps：文件需要解析三种类型文件：SPD、SPDDEV、钻时全烃
     */

    //解析生成SPDDEV
    @RequestMapping(value = "/spddev", method = RequestMethod.GET)
    public boolean analyzeSpddev() throws IOException {
        /**
         * 1.递归读取文件夹下【水平井随钻分析数据图表.xlsx】命名的文件
         * 2.写在当前路径下
         */
        boolean result = CopyOfReadFile.readfile("F:\\桌面\\水平井资料");
        return result;
    }

    //解析生成SPDDEV
    @RequestMapping(value = "/spd", method = RequestMethod.POST)
    public boolean analyzeSpd() throws IOException {
        /**
         * 1.递归读取文件夹下【水平井随钻分析数据图表.xlsx】命名的文件
         * 2.写在当前路径下
         */
        boolean result = CopyOfReadFile.readfile("F:\\桌面\\水平井资料");
        return result;
    }

    //解析生成SPDDEV
    @RequestMapping(value = "/zuanshi", method = RequestMethod.POST)
    public boolean analyzeZuanShiQuanTin() throws IOException {
        boolean result = CopyOfReadFile.readfile("F:\\桌面\\水平井资料");
        return result;
    }


    //Excel->Txt
    @RequestMapping(value = "/excelToTxt", method = RequestMethod.GET)
    public boolean excelToTxt() throws IOException {
//        boolean result = CopyOfReadFile.excelToTxt("F:\\桌面\\水平井资料 (2)\\spd");
        boolean result = CopyOfReadFile.excelToTxt("F:\\桌面\\exportFiles");
//        boolean result = CopyOfReadFile.excelToTxt("F:\\桌面\\水平井资料 (2)\\钻时全烃");
        return result;
    }
}
