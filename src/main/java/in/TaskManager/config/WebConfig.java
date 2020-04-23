package in.TaskManager.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author B Shashidhar
 *
 * 
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "in.HealthAndGlowbel.controller" })
public class WebConfig extends WebMvcConfigurerAdapter {

}