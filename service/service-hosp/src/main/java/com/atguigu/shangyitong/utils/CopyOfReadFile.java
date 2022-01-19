package com.atguigu.shangyitong.utils;

import com.atguigu.shangyitong.service.ExcelService;
import com.atguigu.shangyitong.service.impl.ExcelServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Component
@Slf4j
public class CopyOfReadFile {

    public CopyOfReadFile() {
    }

    /**
     * 读取某个文件夹下的所有文件(支持多级文件夹)
     */
    public static boolean readfile(String filepath) throws FileNotFoundException, IOException {
        try {
            File file = new File(filepath);
            if (!file.isDirectory() && file.getName().equals("水平井随钻分析数据图表.xls")) {
                System.out.println("文件");
                System.out.println("path=" + file.getPath());
                System.out.println("absolutepath=" + file.getAbsolutePath());
                System.out.println("name=" + file.getName());
            } else if (file.isDirectory()) {
                System.out.println("当前文件夹： " + file.getPath());
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
//                for (int i = 0; i < 3; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory() && readfile.getName().contains("水平井随钻分析数据图表.xls")) {
//                        System.out.println("path=" + readfile.getPath());
                        System.out.println("absolutepath=" + readfile.getAbsolutePath());
                        System.out.println("name=" + readfile.getName());
                        ExcelService excelService = new ExcelServiceImpl();
                        excelService.readAndAnalyzeFile(readfile);
                    } else if (readfile.isDirectory()) {
                        readfile(filepath + "\\" + filelist[i]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return true;
    }

    /**
     * 删除某个文件夹下的所有文件夹和文件
     */
    public static boolean deletefile(String delpath) throws FileNotFoundException, IOException {
        try {
            File file = new File(delpath);
            if (!file.isDirectory()) {
                System.out.println("1");
                file.delete();
            } else if (file.isDirectory()) {
                System.out.println("2");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File delfile = new File(delpath + "\\" + filelist[i]);
                    if (!delfile.isDirectory()) {
                        System.out.println("path=" + delfile.getPath());
                        System.out.println("absolutepath="
                                + delfile.getAbsolutePath());
                        System.out.println("name=" + delfile.getName());
                        delfile.delete();
                        System.out.println("删除文件成功");
                    } else if (delfile.isDirectory()) {
                        deletefile(delpath + "\\" + filelist[i]);

                    }
                }
                file.delete();
            }
        } catch (FileNotFoundException e) {
            System.out.println("deletefile()   Exception:" + e.getMessage());
        }
        return true;
    }


    /**
     * 读取某个文件夹下的所有文件(支持多级文件夹)
     */
    public static boolean excelToTxt(String filepath) throws FileNotFoundException, IOException {
        try {
            String filePath = "F:\\桌面\\txt\\";
            File file = new File(filepath);
            if (!file.isDirectory()) {
                System.out.println("文件");
                System.out.println("path=" + file.getPath());
                System.out.println("absolutepath=" + file.getAbsolutePath());
                System.out.println("name=" + file.getName());
//                int lastChar = file.getParent().lastIndexOf("\\");
//                String fileName = file.getParent().substring(lastChar);
//                String targetPath = filePath + fileName + "_spddev.txt";
//                ExcelToTxtUtils.excelTotxt(file, targetPath, false);
            } else if (file.isDirectory()) {
                System.out.println("当前文件夹： " + file.getPath());
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
//                for (int i = 0; i < 3; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {
                        System.out.println("path=" + readfile.getPath());
                        System.out.println("absolutepath=" + readfile.getAbsolutePath());
                        System.out.println("name=" + readfile.getName());
                        String[] lastChars = readfile.getName().split("\\.");
                        String fileName = lastChars[0];
//                        String targetPath1 = filePath + fileName + "_spd.txt";
                        String targetPath2 = filePath + fileName + "_spddev.txt";
//                        String targetPath3 = filePath + fileName + "_钻时全烃.txt";
//                        log.info("this is target {}" + targetPath);
                        ExcelToTxtUtils excelToTxtUtils = new ExcelToTxtUtils();
                        excelToTxtUtils.excelTotxt(readfile, targetPath2, false);
                    } else if (readfile.isDirectory()) {
                        readfile(filepath + "\\" + filelist[i]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}