package org.yjr.config.adapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AppWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Value("${soft.softPath}")
    private String softPath;
    @Value("${soft.softResourcePath}")
    private String softResourcePath;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler(softPath).addResourceLocations(softResourcePath);
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
