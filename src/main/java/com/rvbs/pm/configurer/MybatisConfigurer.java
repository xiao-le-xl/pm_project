package com.rvbs.pm.configurer;

import static com.rvbs.pm.core.ProjectConstant.MAPPER_INTERFACE_REFERENCE;
import static com.rvbs.pm.core.ProjectConstant.MAPPER_PACKAGE;
import static com.rvbs.pm.core.ProjectConstant.MODEL_PACKAGE;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.github.jeffreyning.mybatisplus.base.MppSqlInjector;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * Mybatis & Mapper & PageHelper 配置
 */
@Configuration
public class MybatisConfigurer {

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource,MybatisPlusProperties propertie1,MppSqlInjector mppSqlInjector) throws Exception {
    	MybatisSqlSessionFactoryBean  factory = new MybatisSqlSessionFactoryBean ();
        factory.setDataSource(dataSource);
        factory.setTypeAliasesPackage(MODEL_PACKAGE);
        
       // 关键代码 设置 MyBatis-Plus 分页插件
        MyPaginationInterceptor m = new MyPaginationInterceptor();
        Interceptor[] plugins = {m.mybatisPlusInterceptor()};
        factory.setPlugins(plugins);
        
        // 添加全局配置，这里主要为了支持mppinjector
        GlobalConfig globalConfig = propertie1.getGlobalConfig();
        globalConfig.setSqlInjector(mppSqlInjector);
        factory.setGlobalConfig(globalConfig);
        
        //添加XML目录
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        return factory.getObject();
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage(MAPPER_PACKAGE);

        //配置通用Mapper，详情请查阅官方文档
        Properties properties = new Properties();
        properties.setProperty("mappers", MAPPER_INTERFACE_REFERENCE);
        properties.setProperty("notEmpty", "false");//insert、update是否判断字符串类型!='' 即 test="str != null"表达式内是否追加 and str != ''
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);

        return mapperScannerConfigurer;
    }
    
}

