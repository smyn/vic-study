package com.vic.spring.mybatis.mybatisdemo.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.vic.spring.mybatis.mybatisdemo.base.controller.BaseController;
import com.vic.spring.mybatis.mybatisdemo.base.mode.BaseModel;
import com.vic.spring.mybatis.mybatisdemo.base.service.BaseService;
import com.vic.spring.mybatis.mybatisdemo.base.service.IBaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author vic
 * @date 8/14/2021 1:56 PM
 * @description TODO
 */
public class CodeGenerator {



    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir")+"\\mybatis-demo";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("vic");
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/staffing?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("company");
        pc.setParent("com.vic.spring.mybatis.mybatisdemo");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);

        strategy.setSuperEntityClass(BaseModel.class);
        strategy.setEntityLombokModel(false);
        strategy.setRestControllerStyle(true);
        // 公共父类
        strategy.setSuperControllerClass(BaseController.class);
        strategy.setSuperServiceClass(IBaseService.class);
        strategy.setSuperServiceImplClass(BaseService.class);
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id","deleted","in_user","in_date","last_edit_user","last_edit_date");
        strategy.setInclude("ns_company_info");
        strategy.setControllerMappingHyphenStyle(false);
        strategy.setTablePrefix("ns_");
//        strategy.setNameConvert(new NsNameConvert(strategy));
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new NsFreemarkerTemplateEngine());
        mpg.execute();
    }


}
