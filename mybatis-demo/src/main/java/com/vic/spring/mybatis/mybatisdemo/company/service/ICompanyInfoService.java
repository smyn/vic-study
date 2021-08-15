package com.vic.spring.mybatis.mybatisdemo.company.service;

import com.vic.spring.mybatis.mybatisdemo.company.model.CompanyInfo;
import com.vic.spring.mybatis.mybatisdemo.company.dto.request.query.CompanyInfoQuery;
import com.vic.spring.mybatis.mybatisdemo.company.dto.request.form.CompanyInfoForm;
import com.vic.spring.mybatis.mybatisdemo.base.service.IBaseService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author vic
 * @since 2021-08-15
 */
public interface ICompanyInfoService extends IBaseService<CompanyInfo,CompanyInfoForm,CompanyInfoQuery> {

}
