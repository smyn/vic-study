package com.newegg.pr.core.db;

import com.newegg.pr.core.FieldSelect;
import com.newegg.pr.core.TableColumn;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author vc80
 */
public interface IDbService {

    /**
     * 查询表字段
     * @param tableName
     * @return
     *
     */
    public List<TableColumn> queryTableField(String tableName);


    /**
     * 查询的数据
     * @param tableName
     * @return
     */
    public List<Map<String,Object>> queryData(String tableName,Map<String,String> conditions);

    /**
     * 更新数据
     * @param tableName
     * @param param
     */
    public void update(String tableName,Map<String,String> param);

    /**
     * 新增数据
     * @param tableName
     * @param param
     */
    public void insert(String tableName,Map<String,String> param);

    /**
     * s删除数据
     * @param tableName
     * @param id
     */
    public void delete(String tableName, Serializable id);

}
