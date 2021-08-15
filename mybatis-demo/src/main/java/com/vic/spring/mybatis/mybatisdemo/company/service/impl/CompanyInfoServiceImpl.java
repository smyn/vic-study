package com.vic.spring.mybatis.mybatisdemo.company.service.impl;


import com.vic.spring.mybatis.mybatisdemo.company.model.CompanyInfo;
import com.vic.spring.mybatis.mybatisdemo.company.dto.request.query.CompanyInfoQuery;
import com.vic.spring.mybatis.mybatisdemo.company.dto.request.form.CompanyInfoForm;
import com.vic.spring.mybatis.mybatisdemo.company.mapper.CompanyInfoMapper;
import com.vic.spring.mybatis.mybatisdemo.company.service.ICompanyInfoService;
import com.vic.spring.mybatis.mybatisdemo.base.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author vic
 * @since 2021-08-15
 */
@Service
public class CompanyInfoServiceImpl extends BaseService<CompanyInfo,CompanyInfoForm,CompanyInfoQuery> implements ICompanyInfoService {

   private static final Logger logger = LoggerFactory.getLogger(CompanyInfoServiceImpl.class);

   @Autowired
   private CompanyInfoMapper mapper;

    @Override
    protected BaseMapper<CompanyInfo> mapper() {
        return mapper;
    }

    @Override
    protected CompanyInfo model() {
        return new CompanyInfo();
    }

}
