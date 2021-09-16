package com.newegg.pr.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.newegg.pr.base.dto.*;
/**
 * @author vic
 * @date 9/16/2021 5:42 PM
 * @description TODO
 */
@RestController
@RequestMapping("api/report")
public class ReportController {

    @GetMapping("header/{reportName}")
    public Response reportHeader(@PathVariable(value = "reportName") String reportName){
        return null;
    }

    @GetMapping("data/{reportName}")
    public Response reportData(@PathVariable(value = "reportName") String reportName){
        return null;
    }
    @GetMapping
    public Response reports(){
        return null;
    }





}
