package com.newegg.pr.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import static org.springdoc.core.Constants.API_DOCS_URL;


/**
 * @author vic
 * @date 8/10/2021 8:42 AM
 * @description 配置 Swagger
 * @update by84
 */
@Configuration
public class OpenApiConfig {

    @Autowired
    private ServletContext context;
    @Value(API_DOCS_URL)
    private String apiDocsUrl;

    @Bean
    public OpenAPI apiDocs() {
        OpenAPI openApi =  new CustomOpenAPI()
                .info(new Info().title("Newegg Staffing Portal API").description("Newegg Staffing").version("1.0"));
        openApi.addServersItem(newServer("https://apis-dev.newegg.org/staffing", "GDEV"))
                .addServersItem(newServer("https://apis-gqc.newegg.org/staffing", "GQC"))
                .addServersItem(newServer("https://sandboxapis.newegg.org/staffing", "PRE"))
                .addServersItem(newServer("https://apis.newegg.org/staffing", "PRD"));
        return openApi;
    }

    private Server newServer(String url, String env) {
        Server server = new Server();
        server.setUrl(url);
        server.setDescription(env);
        return server;
    }

    private class CustomOpenAPI extends OpenAPI {

        @Override
        public synchronized List<Server> getServers() {
            List<Server> servers = super.getServers();
            String defaultUrl = defaultUrl();
            if(StringUtils.isNotBlank(defaultUrl)) {
                Server local = newServer(defaultUrl, "LOCAL");
                if(!servers.contains(local)) {
                    servers.add(0, local);
                }
            }
            return servers;
        }

        private String defaultUrl() {
            Optional<RequestAttributes> requestAttributes = Optional.ofNullable(RequestContextHolder.getRequestAttributes());
            if(requestAttributes.isEmpty()) {
                return null;
            }
            HttpServletRequest request = ((ServletRequestAttributes)requestAttributes.get()).getRequest();
            // ref: org.springdoc.webmvc.api.OpenApiWebMvcResource#getServerUrl()
            String requestUrl = decode(request.getRequestURL().toString());
            return requestUrl.substring(0, requestUrl.length() - apiDocsUrl.length());
        }

        private String decode(String requestUrl) {
            try {
                return URLDecoder.decode(requestUrl, StandardCharsets.UTF_8.toString());
            } catch (UnsupportedEncodingException e) {
                return requestUrl;
            }
        }
    }
}
