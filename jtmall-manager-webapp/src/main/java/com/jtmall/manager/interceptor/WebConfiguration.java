package com.jtmall.manager.interceptor;

/**
 * @Author Badribbit
 * @create 2020/2/21 23:29
 * @Define 对thymeleaf
 * @Tutorials
 * @Opinion
 */
//@Configuration
//public class WebConfiguration implements WebMvcConfigurer {
//
//    @Bean
//    public LocaleResolver localeResolver() {
//
//        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//        localeResolver.setDefaultLocale(new Locale("es", "ES"));
//        return localeResolver;
//    }
//
//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor() {
//
//        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//        localeChangeInterceptor.setParamName("lang");
//        return localeChangeInterceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        registry.addInterceptor(localeChangeInterceptor());
//    }
//
//    /**
//     * 对静态资源进行放行
//     * @param registry
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    }
//}