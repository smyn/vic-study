package com.vic.spring.mybatis.mybatisdemo.generator;


import com.baomidou.mybatisplus.generator.config.INameConvert;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Set;

/**
 * @author vic
 * @date 8/14/2021 3:27 PM
 * @description TODO
 */
public class NsNameConvert implements INameConvert {

    private StrategyConfig config;

    public NsNameConvert(StrategyConfig config) {
        this.config = config;
    }

    @Override
    public String entityNameConvert(TableInfo tableInfo) {
        String name = tableInfo.getName().substring(3);
        name = NamingStrategy.capitalFirst(NamingStrategy.underlineToCamel(name));
        return name;
    }

    @Override
    public String propertyNameConvert(TableField field) {
        String name = this.processName(field.getName(), config.getColumnNaming(),null);
        return name;
    }






    private String processName(String name, NamingStrategy strategy, Set<String> prefix) {
        String propertyName;
        if (prefix.size() > 0) {
            if (strategy == NamingStrategy.underline_to_camel) {
                propertyName = NamingStrategy.removePrefixAndCamel(name, prefix);
            } else {
                propertyName = NamingStrategy.removePrefix(name, prefix);
            }
        } else if (strategy == NamingStrategy.underline_to_camel) {
            propertyName = NamingStrategy.underlineToCamel(name);
        } else {
            propertyName = name;
        }
        return propertyName;
    }

}
