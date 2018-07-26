package com.example.base.config

import com.github.pagehelper.PageInterceptor
import com.zaxxer.hikari.HikariDataSource
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.session.ExecutorType
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.SqlSessionTemplate
import org.mybatis.spring.annotation.MapperScan
import org.omg.PortableInterceptor.Interceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.util.*
import javax.sql.DataSource

@Configuration
@MapperScan(basePackages = ["com.example"], annotationClass = Mapper::class)
@EnableTransactionManagement
@PropertySource("classpath:datasource.properties")
class DataSourceConfig {

    @Autowired
    private lateinit var env: Environment

    @Bean(name = ["primaryDataSource"], destroyMethod = "close")
    @Primary
    fun dataSource(): DataSource {
        val profile = env.activeProfiles[0]
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .type(HikariDataSource::class.java)
                .url(env.getProperty("$profile.db.url"))
                .username(env.getProperty("$profile.db.username"))
                .password(env.getProperty("$profile.db.password"))
                .build()
    }

    @Bean("sqlSessionFactory")
    fun sqlSessionFactory(dataSource: DataSource): SqlSessionFactoryBean {
        val sqlSessionFactory = SqlSessionFactoryBean()
        sqlSessionFactory.setDataSource(dataSource)
        sqlSessionFactory.setPlugins(arrayOf(initPageInterceptor()))
        return sqlSessionFactory
    }

    @Bean("sqlSessionTemplate")
    fun sqlSessionTemplate(sqlSessionFactory: SqlSessionFactory): SqlSessionTemplate {
        val configuration = sqlSessionFactory.configuration
        configuration.isCallSettersOnNulls = true
        configuration.isMapUnderscoreToCamelCase = true
        return SqlSessionTemplate(sqlSessionFactory, ExecutorType.REUSE)
    }

    @Bean("dataSourceTransactionManager")
    fun transactionManager(dataSource: DataSource): PlatformTransactionManager {
        return DataSourceTransactionManager(dataSource)
    }

    private fun initPageInterceptor(): PageInterceptor {
        val pageInterceptor = PageInterceptor()
        val properties = Properties()
        properties.setProperty("helperDialect", "postgresql")
        pageInterceptor.setProperties(properties)
        return pageInterceptor
    }
}