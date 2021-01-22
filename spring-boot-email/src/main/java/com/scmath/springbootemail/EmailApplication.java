package com.scmath.springbootemail;


import com.scmath.springbootemail.service.JavaMailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootApplication
public class EmailApplication {

	public static void main(String[] args) throws MessagingException, IOException {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(EmailApplication.class, args);

		JavaMailService javaMailService =  applicationContext.getBean(JavaMailService.class);

//		javaMailService.sendSimpleMail();
//		javaMailService.sendMimeMail();
	}

}
