package com.newegg.pr.core.db;

import com.newegg.pr.core.FieldSelect;
import com.newegg.pr.core.TableColumn;

import java.util.List;
import java.util.Map;

/**
 * @author vc80
 */
public interface DbService {

    /**
     * 查询表字段
     * @param tableName
     * @return
     *
     */
    public List<TableColumn> queryTableField(String tableName);

    /**
     * 查询字段的选项
     * @param tableName
     * @return
     */
    public List<Map<String,List<FieldSelect>>> queryFieldSelect(String tableName);

    /**
     * 查询的数据
     * @param tableName
     * @return
     */
    public List<Map<String,Object>> queryData(String tableName);


}
