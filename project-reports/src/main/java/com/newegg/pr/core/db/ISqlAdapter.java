package com.newegg.pr.core.db;

public interface ISqlAdapter {

    public abstract String insertSql(String tableName);


    public abstract String updateSql(String tableName);


    public abstract String deleteSql(String tableName);


    public abstract String tableFieldSql(String tableName);

    public abstract String querySql(String tableName);
}
