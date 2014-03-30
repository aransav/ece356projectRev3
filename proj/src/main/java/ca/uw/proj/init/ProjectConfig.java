/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.init;

import java.util.Properties;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 *
 * @author siva
 */
@Configuration
@ComponentScan("ca.uw.proj")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:project.properties")
public class ProjectConfig {

    private static final String DB_DRIVER = "db.driver";
    private static final String DB_URL = "db.url";
    private static final String DB_USERNAME = "db.username";
    private static final String DB_PASSWORD = "db.password";
    private static final String HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String HIBERNATE_SCAN = "entitymanager.packages.to.scan";
    private static final String HIBERNATE_HBM2DDL = "hibernate.hbm2ddl.auto";

    @Resource
    private Environment env;

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager t = new HibernateTransactionManager();
        t.setSessionFactory(sessionFactory().getObject());
        return t;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();

        sfb.setDataSource(dataSource());
        sfb.setPackagesToScan(env.getRequiredProperty(HIBERNATE_SCAN));

        Properties p = new Properties();
        p.put(HIBERNATE_SHOW_SQL, env.getRequiredProperty(HIBERNATE_SHOW_SQL));
        p.put(HIBERNATE_DIALECT, env.getRequiredProperty(HIBERNATE_DIALECT));
        p.put(HIBERNATE_HBM2DDL, env.getRequiredProperty(HIBERNATE_HBM2DDL));

        sfb.setHibernateProperties(p);

        return sfb;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setDriverClassName(env.getRequiredProperty(DB_DRIVER));
        ds.setUrl(env.getRequiredProperty(DB_URL));
        ds.setUsername(env.getRequiredProperty(DB_USERNAME));
        ds.setPassword(env.getRequiredProperty(DB_PASSWORD));

        return ds;
    }

    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver r = new UrlBasedViewResolver();
        r.setPrefix("/WEB-INF/pages/");
        r.setSuffix(".jsp");
        r.setViewClass(JstlView.class);
        return r;
    }

}
