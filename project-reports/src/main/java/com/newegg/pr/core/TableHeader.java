package com.newegg.pr.core;

import java.util.List;

/**
 * @author vic
 * @date 9/16/2021 5:20 PM
 * @description 表头
 */
public class TableHeader {

    List<Condition> conditions;

    List<TableColumn> columns;

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public List<TableColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<TableColumn> columns) {
        this.columns = columns;
    }
}
