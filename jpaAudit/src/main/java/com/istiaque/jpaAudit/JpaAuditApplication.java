package com.istiaque.jpaAudit;

import com.istiaque.jpaAudit.audit.AuditorAwareImpl;
import com.istiaque.jpaAudit.model.User;
import com.istiaque.jpaAudit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaAuditApplication {
    @Autowired
    UserRepository userRepository;

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }

    public static void main(String[] args) {
//        new JpaAuditApplication().initData();
        SpringApplication.run(JpaAuditApplication.class, args);
    }

    @Bean
    public void initData() {
        User user = new User();
        user.setFirstName("Istiaque");
        user.setLastName("Hossain");
        user.setEmailId("panthaistiaque@gmail.com");
        userRepository.save(user);
    }
}
