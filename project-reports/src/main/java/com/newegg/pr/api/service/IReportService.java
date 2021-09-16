package com.newegg.pr.api.service;

import com.newegg.pr.base.dto.Response;
import org.springframework.web.bind.annotation.PathVariable;

public interface IReportService {

    public Response reportHeader(@PathVariable(value = "reportName") String reportName);

    public Response reportData(@PathVariable(value = "reportName") String reportName);

    public Response reports();
}
