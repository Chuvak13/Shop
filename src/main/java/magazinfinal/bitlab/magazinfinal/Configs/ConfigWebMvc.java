package magazinfinal.bitlab.magazinfinal.Configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.Locale;
@Configuration
public class ConfigWebMvc implements WebMvcConfigurer {
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("utf-8");
        return messageSource;
    }

    @Bean
    public CookieLocaleResolver localeResolver() {
        CookieLocaleResolver clr = new CookieLocaleResolver();
        clr.setDefaultLocale(new Locale("en"));
        clr.setCookieName("language");
        clr.setCookieMaxAge(3600);
        return clr;
    }

    @Bean
    public LocaleChangeInterceptor interceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lng");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }


//    @Autowired
//    private ApplicationContext applicationContext;
//    @Bean
//    public SpringResourceTemplateResolver templateResolver() {
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setApplicationContext(applicationContext);
//        templateResolver.setPrefix("/WEB-INF/templates/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode(TemplateMode.HTML);
//        templateResolver.setCacheable(true);
//        return templateResolver;
//    }
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        SpringTemplateEngine.addDialect(new SpringSecurityDialect());
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.setEnableSpringELCompiler(true);
//        return templateEngine;
//    }
//    @Bean
//    public ViewResolver viewResolver() {
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(templateEngine());
//        return viewResolver;
//    }
}
