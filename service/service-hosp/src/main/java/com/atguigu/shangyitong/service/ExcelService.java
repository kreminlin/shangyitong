package com.atguigu.shangyitong.service;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public interface ExcelService {

    void readAndAnalyzeFile(File file);
}
