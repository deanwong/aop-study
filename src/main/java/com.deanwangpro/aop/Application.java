package com.deanwangpro.aop;

import com.deanwangpro.aop.service.Person;
import com.deanwangpro.aop.service.Speakable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Created by i311609 on 08/02/2017.
 */
@SpringBootApplication
public class Application {

    @Autowired
    private Speakable personSpring;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            // spring aop
            System.out.println("******** spring aop ******** ");
            personSpring.sayHi();
            personSpring.sayBye();
            // jdk dynamic proxy
            System.out.println("******** jdk dynamic proxy ******** ");
            Speakable jdkProxy = PersonProxyFactory.newJdkProxy();
            jdkProxy.sayHi();
            jdkProxy.sayBye();
            // cglib dynamic proxy
            System.out.println("******** cglib proxy ******** ");
            Person cglibProxy = PersonProxyFactory.newCglibProxy();
            cglibProxy.sayHi();
            cglibProxy.sayBye();
            System.exit(0);
        };
    }

}