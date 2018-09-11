package lk.ijse.registration.main;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("file:${user.dir}/resource/application.properties")
public class JPAConfig {

    @Autowired
    private Environment env;



    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter){
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(dataSource);
        lcemfb.setJpaVendorAdapter(jpaVendorAdapter);
        lcemfb.setPackagesToScan("lk.ijse.registration.entity");
        return lcemfb;


    }
    @Bean
    public DataSource dataSource(){
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName(env.getRequiredProperty("hibernate.conenction.driver_class"));
        bds.setUrl(env.getRequiredProperty("hibernate.connection.url"));
        bds.setUsername(env.getRequiredProperty("hibernate.connection.username"));
        bds.setPassword(env.getRequiredProperty("hibernate.connection.password"));
        bds.setMaxTotal(env.getRequiredProperty("hibernate.max_total",Integer.class));
        bds.setInitialSize(env.getRequiredProperty("hibernate.init_size",Integer.class));
        bds.setMaxIdle(env.getRequiredProperty("hibernate.max_idle",Integer.class));
        return bds;

    }
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
        va.setDatabase(Database.MYSQL);
        va.setShowSql(env.getRequiredProperty("hibernate.show_sql", Boolean.class));
        va.setGenerateDdl(env.getRequiredProperty("hibernate.generate_ddl",Boolean.class));
        va.setDatabasePlatform(env.getRequiredProperty("hibernate.dialect"));
        return va;
    }



    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);

    }

}
