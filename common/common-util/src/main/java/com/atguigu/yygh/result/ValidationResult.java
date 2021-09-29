package com.atguigu.yygh.result;

import lombok.Data;

import java.util.Map;

/**
 * 校验结果
 *
 * @author lizhilong
 */
@Data
public class ValidationResult {

    // 校验结果是否有错
    private boolean hasErrors;

    // 校验错误信息
    private Map<String, String> errorMsg;
}