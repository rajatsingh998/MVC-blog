package SpringDemo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan({"SpringDemo"})
public class ApplicationContextConfig {
    @Bean
    public InternalResourceViewResolver viewResolver()
    {
        InternalResourceViewResolver resolver= new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/View/");
        resolver.setSuffix(".jsp");
        return  resolver;
    }
}
