package com.vic.spring.pdf.util;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author vic
 * @date 9/2/2021 3:28 PM
 * @description TODO
 */
public class StringUtils {


    /**
     * 使用正则表达式批量替换字符串
     * @param text 需要替换的字符串
     * @param params  将${key} 替换为  Map中对应的value
     * @return
     */
    private static String replace(String text, Map<String,String> params){
        if(params == null || params.isEmpty()){
            return text;
        }
        String patternString = "\\$\\{(" + org.apache.commons.lang3.StringUtils.join(params.keySet(), "|") + ")\\}";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            matcher.appendReplacement(sb, params.get(matcher.group(1)));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
