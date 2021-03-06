package edu.mum.client.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Rabin Shrestha on 8/15/2017.
 */
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan("edu.mum.client")
public class MvcConfig extends WebMvcConfigurerAdapter {

    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/static/images*//**")
                .addResourceLocations("/static/images/");
    }*/
}