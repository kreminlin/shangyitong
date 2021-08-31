//package com.atguigu.swagger_common;
//
//import lombok.Data;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//@ConfigurationProperties("swagger")
//public class SwaggerProperties {
//    /**
//     * 是否开启swagger
//     */
//    private Boolean enabled;
//    /**
//     * swagger解析的包路径
//     */
//    private String basePackage;
//    /**
//     * swagger解析的url路径
//     */
//    private List<String> basePath = new ArrayList<>();
//    /**
//     * 在basePath基础上需要排除的url规则
//     */
//    private List<String> excludePath = new ArrayList<>();
//    /**
//     * 标题
//     */
//    private String title = "";
//    /**
//     * 描述
//     */
//    private String description = "";
//    /**
//     * 版本
//     */
//    private String version = "";
//    /**
//     * 许可证
//     */
//    private String license = "";
//    /**
//     * 许可证URL
//     */
//    private String licenseUrl = "";
//    /**
//     * host信息
//     */
//    private String host = "";
//}
