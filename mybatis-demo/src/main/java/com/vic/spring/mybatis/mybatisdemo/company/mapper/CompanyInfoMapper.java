package com.vic.spring.mybatis.mybatisdemo.company.mapper;

import com.vic.spring.mybatis.mybatisdemo.company.model.CompanyInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author vic
 * @since 2021-08-15
 */
@Mapper
public interface CompanyInfoMapper extends BaseMapper<CompanyInfo> {

}
