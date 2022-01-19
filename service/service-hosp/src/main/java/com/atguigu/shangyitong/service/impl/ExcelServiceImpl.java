package com.atguigu.shangyitong.service.impl;

import com.atguigu.shangyitong.controller.dto.OriginalPointDTO;
import com.atguigu.shangyitong.service.ExcelService;
import com.atguigu.shangyitong.utils.ExcelUtils;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ExcelServiceImpl implements ExcelService {

    /**
     * 文件读取，并解析数据
     *
     * @param file
     */
    @Override
    public void readAndAnalyzeFile(File file) {
        //读取原始测点数据
        String sheetName1 = "原始测点";
        String sheetName2 = "原始伽玛";
        String sheetName3 = "原始录井";
        /**
         * 1. spddev
         * 2. spd
         * 3. 钻时全烃
         */
        //spddev
        ExcelUtils.readModelWriteSpddev(file.getAbsolutePath(), sheetName1, OriginalPointDTO.class, file);
        //spd
//        ExcelUtils.readModelWriteSpd(file.getAbsolutePath(), sheetName2, OriginalGammaDTO.class, file);
        //钻时全烃
//        ExcelUtils.readModelWriteZuanShi(file.getAbsolutePath(), sheetName3, DrillOfHydrocarbonDTO.class, file);
    }

}
