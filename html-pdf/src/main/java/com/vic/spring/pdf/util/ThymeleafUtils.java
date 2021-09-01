package com.vic.spring.pdf.util;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

public class ThymeleafUtils {

    public static String generateHtmlFromMap(TemplateEngine templateEngine, Map<String, Object> receiptInfoMap, String templateName) {
        Context context = new Context();
        for (Map.Entry<String, Object> entry : receiptInfoMap.entrySet()) {
            context.setVariable(((Map.Entry) entry)
                            .getKey()
                            .toString(),
                    entry.getValue());
        }
        return templateEngine.process(templateName, context);
    }

}
