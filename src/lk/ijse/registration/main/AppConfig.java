package lk.ijse.registration.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("lk.ijse.registration")
@Import(JPAConfig.class)
public class AppConfig {

}
