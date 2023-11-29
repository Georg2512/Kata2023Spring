package web.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        registerHiddenFieldFilter(servletContext);
    }

    private void registerHiddenFieldFilter(ServletContext servletContext) {

        servletContext.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter()).
                addMappingForUrlPatterns(null, true, "/*");
    }
//    // Метод, указывающий на класс конфигурации
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return null;
//    }
//
//
//    // Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения jsp.
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class<?>[]{
//                WebConfig.class
//        };
//    }
//
//
//    /* Данный метод указывает url, на котором будет базироваться приложение */
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }

}