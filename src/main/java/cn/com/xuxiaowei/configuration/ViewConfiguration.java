package cn.com.xuxiaowei.configuration;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.faces.webapp.FacesServlet;

/**
 * JSF 配置
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Configuration
public class ViewConfiguration {

    public static final String SCOPE = "View";

    /**
     * 视图解析注册为 Bean
     */
    @Bean
    public static CustomScopeConfigurer viewScope() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();

        ImmutableMap.Builder<String, Object> stringObjectBuilder = new ImmutableMap.Builder<>();
        stringObjectBuilder.put(SCOPE, new ViewScope());
        ImmutableMap<String, Object> build = stringObjectBuilder.build();

        configurer.setScopes(build);

        return configurer;
    }

    /**
     * 自定义需要解析的 FacesServlet 后缀名注册为 Bean
     * <p>
     * 必须，不可使用 XML 配置
     * 原因：可能与项目启动加载顺序有关
     */
    @Bean
    public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
        FacesServlet facesServlet = new FacesServlet();
        ServletRegistrationBean<FacesServlet> servletRegistrationBean = new ServletRegistrationBean<>(facesServlet, "*.xhtml");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

}
