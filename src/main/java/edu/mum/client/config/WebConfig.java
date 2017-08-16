package edu.mum.client.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Rabin Shrestha on 8/16/2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan("edu.mum.client")
@EnableAspectJAutoProxy
public class WebConfig extends WebMvcConfigurerAdapter {

}
