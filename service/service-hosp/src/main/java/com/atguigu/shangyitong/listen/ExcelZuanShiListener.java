package com.atguigu.shangyitong.listen;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.atguigu.shangyitong.controller.dto.DrillOfHydrocarbonDTO;
import com.atguigu.shangyitong.utils.ExcelUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcelZuanShiListener extends AnalysisEventListener<Object> {

    //private UserService userService;
    private File file;
    String sheetName = "原始录井";

    public ExcelZuanShiListener(File file) {
        this.file = file;
    }

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 45000000;
    List<Object> list = new ArrayList<>();

    @SneakyThrows
    @Override
    public void invoke(Object data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
//        log.info("解析到一条数据:{}", data);
        list.add(data);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @SneakyThrows
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
        log.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() throws IOException {
        log.info("{}条数据，开始存储数据库！", list.size());
        if (!CollectionUtils.isEmpty(list)) {
            int lastChar = file.getParent().lastIndexOf("\\");
            String fileName = file.getParent().substring(lastChar);
            ExcelUtils.noModelWrite("F:\\桌面\\exportFiles2\\" + fileName + "_钻时全烃.xls", sheetName, list, DrillOfHydrocarbonDTO.class);
        }
        log.info("存储数据库成功！");
    }

}
