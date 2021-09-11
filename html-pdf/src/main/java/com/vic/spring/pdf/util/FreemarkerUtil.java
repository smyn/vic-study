package com.vic.spring.pdf.util;


import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.StringWriter;
import java.util.Map;

/**
 * @author vic
 * @date 9/2/2021 2:58 PM
 * @description Freemarker 工具类
 */
public class FreemarkerUtil {


    public static String createHtml(String templateName, Map<String,Object> params) throws Exception {
        File file = new File(FreemarkerUtil.class.getClassLoader().getResource("templates/pdf/").getPath());
        StringWriter writer = new StringWriter();
        FileTemplateLoader fileTemplateLoader = new FileTemplateLoader(file);
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setTemplateLoader(fileTemplateLoader);
        configuration.setDirectoryForTemplateLoading(file);
        configuration.setDefaultEncoding("UTF-8");
        Template template = configuration.getTemplate(templateName);
        template.process(params,writer);
        return writer.getBuffer().toString();
    }


}
