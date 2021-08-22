package com.vic.spring.mybatis.mybatisdemo.base.dto;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseQuery<T>{

    private long size = 20;
    private long current = 1;
    private String order;

    private Wrapper<T> wrapper;

    protected QueryWrapper<T> queryWrapper(){
        if(wrapper != null){
            if( wrapper instanceof QueryWrapper){
                return (QueryWrapper)wrapper;
            }else{
                throw new RuntimeException("wrapper has been initialized type: "+wrapper.getClass());
            }
        }
        wrapper = new QueryWrapper<>();
        return (QueryWrapper)wrapper;
    }


    protected LambdaQueryWrapper<T> lambdaWrapper(){
        if(wrapper != null){
            if( wrapper instanceof LambdaQueryWrapper){
                return (LambdaQueryWrapper)wrapper;
            }else{
                throw new RuntimeException("wrapper has been initialized type: "+wrapper.getClass());
            }
        }
        wrapper = new QueryWrapper<T>().lambda();
        return (LambdaQueryWrapper)wrapper;
    }

     public  IPage<T> page() {
        Page<T> page = new Page<T>(current,size);
        List<OrderItem> orderItems = parse(order);
        if(orderItems != null && !orderItems.isEmpty()){
            page.setOrders(orderItems);
        }
        return page;
    }

    /**
     * 解析排序字符串
     * @param str
     * @return
     */
    private List<OrderItem> parse(String str){
        if(str == null){
            return null;
        }
        String [] orders = str.split(",");
        List<OrderItem> orderItems = new ArrayList<>();
        for (String orderItem: orders) {
            String [] items = orderItem.split(" ");
            if(items.length == 0){
                continue;
            }else if(items.length == 1 && StringUtils.hasLength(items[0].trim())){
                orderItems.add(OrderItem.asc(items[0].trim()));
            }else{
                if(items[1].trim().equalsIgnoreCase("desc")){
                    orderItems.add(OrderItem.desc(items[0].trim()));
                }else{
                    orderItems.add(OrderItem.asc(items[0].trim()));
                }
            }
        }
        return orderItems;
    }

    @JsonIgnore
    public Wrapper<T> wrapper() {
        setCustomerCondition();
        if(wrapper == null){
            wrapper = new QueryWrapper<T>();
        }
        return wrapper;
    }


    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setWrapper(Wrapper<T> wrapper) {
        this.wrapper = wrapper;
    }


    /**
     * 自定义查询条件
     */
    public abstract void setCustomerCondition();

    protected boolean notEmpty(Object s) {
        return  !ObjectUtils.isEmpty(s) && StringUtils.hasLength(s+"");
    }
}
