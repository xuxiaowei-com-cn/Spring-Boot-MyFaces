package cn.com.xuxiaowei.configuration;

import org.apache.myfaces.webapp.StartupServletContextListener;
import org.springframework.context.annotation.Configuration;

/**
 * 配置 Apache MyFaces 监听
 * <p>
 * 必须，不可使用 xml 配置
 * 原因：可能与项目启动加载顺序有关
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Configuration
public class CustomStartupServletContextListener extends StartupServletContextListener {

}
