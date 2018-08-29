package chessGameBackend.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:/db.properties")
public class HibernateConfig {

    @Autowired
    private Environment environment;

    @Bean
    public SessionFactory getSessionFactory() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(this.getSettings())
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addPackage("chessGameBackend.model")
                .buildMetadata();

        SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder();
        return sessionFactoryBuilder.build();
    }

    private Map<String, String> getSettings() {
        Map<String, String> settings = new HashMap<>();
        settings.put(AvailableSettings.DRIVER, environment.getProperty("driver"));
        settings.put(AvailableSettings.DIALECT, environment.getProperty("dialect"));
        settings.put(AvailableSettings.URL, environment.getProperty("url"));
        settings.put(AvailableSettings.USER, environment.getProperty("user"));
        settings.put(AvailableSettings.PASS, environment.getProperty("pass"));
        settings.put(AvailableSettings.HBM2DDL_AUTO, environment.getProperty("hbm2dll_auto"));

        return settings;
    }

}
