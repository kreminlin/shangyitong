package com.atguigu.shangyitong.utils;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelToTxtUtils {

    /**
     * 上传excel 转为 txt
     *
     * @param file     上传的文件
     * @param filePath 转换的文件
     * @param ishead   是否去除首行
     * @throws Exception
     */
    public void excelTotxt(File file, String filePath, Boolean ishead) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStream in = fileInputStream;
        String fileName = file.getName();
        Path target = Paths.get(filePath);
        if (java.nio.file.Files.exists(target)) {
            Files.delete(target);
        }
        java.nio.file.Files.createFile(target);
        //创建Excel工作薄
        Workbook work = getWorkbook(in, fileName);
        work.createCellStyle();
        BufferedWriter bufferedWriter = java.nio.file.Files.newBufferedWriter(target, Charset.forName("UTF-8"));
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;

        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }
            int hf = sheet.getFirstRowNum();
            int hl = sheet.getLastRowNum();

            if (ishead) {
                hf = hf + 1;
            }

            if (hf > hl) {
                continue;
            }

            for (int j = hf; j <= hl; j++) {
                row = sheet.getRow(j);
                if (row == null) {
                    continue;
                }
                StringBuilder strb = new StringBuilder();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    String s = excelTime(row.getCell(y));
                    if (y == row.getLastCellNum() - 1) {
                        strb.append(s + "\n");
                    } else {
                        strb.append(s + "\t");
                    }
                }
                bufferedWriter.append(strb.toString());
                strb = null;
            }
        }
        work.close();
        bufferedWriter.close();
    }

    /**
     * 判断文件格式
     *
     * @param inStr
     * @param fileName
     * @return
     * @throws Exception
     */
    public static Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook workbook = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(fileType)) {
            workbook = new HSSFWorkbook(inStr);
        } else if (".xlsx".equals(fileType)) {
            workbook = new XSSFWorkbook(inStr);
        } else {
            throw new Exception("请上传excel文件！");
        }
        return workbook;
    }

    /**
     * excel 时间判断 和 转换
     *
     * @param cell
     * @return
     */
    public static String excelTime(Cell cell) {
        String guarantee_time = "";
        try {
            if (DateUtil.isCellDateFormatted(cell)) {
                //用于转化为日期格式
                Date d = cell.getDateCellValue();
                DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                guarantee_time = formater.format(d);
                return guarantee_time;
            }
        } catch (Exception e) {
        }
        cell.setCellType(Cell.CELL_TYPE_STRING);
        return cell == null ? guarantee_time : cell.toString();
    }
}