package com.atguigu.shangyitong.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.atguigu.shangyitong.handler.CustomCellWriteHandler;
import com.atguigu.shangyitong.listen.ExcelSpdListener;
import com.atguigu.shangyitong.listen.ExcelSpddevListener;
import com.atguigu.shangyitong.listen.ExcelZuanShiListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.util.IOUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Excel工具类
 */
@Slf4j
public class ExcelUtils {

    /**
     * 导出Excel(07版.xlsx)到指定路径下
     *
     * @param path      路径
     * @param excelName Excel名称
     * @param sheetName sheet页名称
     * @param clazz     Excel要转换的类型
     * @param data      要导出的数据
     */
    public static void export2File(String path, String excelName, String sheetName, Class clazz, List data) {
        String fileName = path.concat(excelName).concat(ExcelTypeEnum.XLSX.getValue());
        EasyExcel.write(fileName, clazz).sheet(sheetName).doWrite(data);
    }

    /**
     * 导出Excel(07版.xlsx)到web
     *
     * @param response  响应
     * @param excelName Excel名称
     * @param sheetName sheet页名称
     * @param clazz     Excel要转换的类型
     * @param data      要导出的数据
     * @throws Exception
     */
    public static void export2Web(HttpServletResponse response, String excelName, String sheetName, Class clazz, List data) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码
        excelName = URLEncoder.encode(excelName, "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + excelName + ExcelTypeEnum.XLSX.getValue());
        EasyExcel.write(response.getOutputStream(), clazz).sheet(sheetName).doWrite(data);
    }

    /**
     * 将指定位置指定名称的Excel导出到web
     *
     * @param response  响应
     * @param path      文件路径
     * @param excelName 文件名称
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String export2Web4File(HttpServletResponse response, String path, String excelName) throws UnsupportedEncodingException {
        File file = new File(path.concat(excelName).concat(ExcelTypeEnum.XLSX.getValue()));
        if (!file.exists()) {
            return "文件不存在！";
        }

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码
        excelName = URLEncoder.encode(excelName, "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + excelName + ExcelTypeEnum.XLSX.getValue());

        try (
                FileInputStream in = new FileInputStream(file);
                ServletOutputStream out = response.getOutputStream();
        ) {
            IOUtils.copy(in, out);
            return "导出成功！";
        } catch (Exception e) {
            log.error("导出文件异常：", e);
        }

        return "导出失败！";
    }

    //读Excel--SPDDEV
    public static <T> void readModelWriteSpddev(String fileName, String sheetName, Class<T> domainClass, File file) {
        EasyExcel.read(fileName, domainClass, new ExcelSpddevListener(file)).sheet(sheetName).doRead();
    }

    //读Excel--SPD
    public static <T> void readModelWriteSpd(String fileName, String sheetName, Class<T> domainClass, File file) {
        EasyExcel.read(fileName, domainClass, new ExcelSpdListener(file)).sheet(sheetName).doRead();
    }

    //读Excel--钻时全烃
    public static <T> void readModelWriteZuanShi(String fileName, String sheetName, Class<T> domainClass, File file) {
        EasyExcel.read(fileName, domainClass, new ExcelZuanShiListener(file)).sheet(sheetName).doRead();
    }

    public static <T> void noModelWrite(String fileName, String sheetName, List data, Class<T> domainClass) {
        EasyExcel.write(fileName, domainClass).registerWriteHandler(new CustomCellWriteHandler()).sheet(sheetName).doWrite(data);
    }

}
