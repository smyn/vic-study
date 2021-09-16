package com.newegg.pr.core.db;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.newegg.pr.base.util.JsonUtil;
import com.newegg.pr.core.TableColumn;
import com.newegg.pr.core.db.impl.MysqlAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BaseDbService implements IDbService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    private ISqlAdapter sqlAdapter = new MysqlAdapter();

    @Override
    public List<TableColumn> queryTableField(String tableName) {
        Map<String,Object> param = new HashMap<>();
        param.put("TABLE_NAME",tableName);
        List<Map<String,Object>> filedList = jdbcTemplate.queryForList(sqlAdapter.tableFieldSql(tableName),param);
        try {
            return JsonUtil.jsonToList(JsonUtil.toJsonString(filedList),TableColumn.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public List<Map<String, Object>> queryData(String tableName,Map<String,String> conditions) {
        return jdbcTemplate.queryForList(sqlAdapter.querySql(tableName),conditions);
    }

    @Override
    public void update(String tableName, Map<String, String> param) {
         jdbcTemplate.update(sqlAdapter.updateSql(tableName),param);
    }

    @Override
    public void insert(String tableName, Map<String, String> param) {
        jdbcTemplate.update(sqlAdapter.insertSql(tableName),param);
    }

    @Override
    public void delete(String tableName, Serializable id) {
        Map<String,Object> param = new HashMap<>();
        param.put("id",id);
        jdbcTemplate.update(sqlAdapter.deleteSql(tableName),param);
    }
}
