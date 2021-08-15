package com.vic.spring.mybatis.mybatisdemo.company.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import com.vic.spring.mybatis.mybatisdemo.base.dto.Response;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import  com.vic.spring.mybatis.mybatisdemo.company.service.ICompanyInfoService;
import com.vic.spring.mybatis.mybatisdemo.company.model.CompanyInfo;
import com.vic.spring.mybatis.mybatisdemo.company.dto.request.query.CompanyInfoQuery;
import com.vic.spring.mybatis.mybatisdemo.company.dto.request.form.CompanyInfoForm;
import org.springframework.web.bind.annotation.RestController;
import com.vic.spring.mybatis.mybatisdemo.base.controller.BaseController;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author vic
 * @since 2021-08-15
 */
@RestController
@RequestMapping("/company/companyInfo")
public class CompanyInfoController extends BaseController {

    @Autowired
    private ICompanyInfoService service;

    @GetMapping("{id}")
    public Response<CompanyInfo> getById(@PathVariable("id") Long id ){
        return Response.SUCCESS(service.selectById(id));
    }

    @GetMapping
    public Response<IPage<CompanyInfo>> getPage(CompanyInfoQuery query){
        return Response.SUCCESS(service.queryPage(query));
    }

    @PutMapping
    public Response<Long> add(@RequestBody  @Valid CompanyInfoForm form){
        return Response.SUCCESS(service.insert(form));
    }

    @PostMapping
    public Response<Integer> update(@RequestBody @Valid CompanyInfoForm form){
        return Response.SUCCESS(service.updateById(form));
    }

    @PostMapping("{id}")
    public Response<Integer> delete(@PathVariable("id") Long id ){
         return Response.SUCCESS(service.deleteById(id));
    }


}
