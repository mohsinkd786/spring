package com.mohsinkd786;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.derby.drda.NetworkServerControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.util.SocketUtils;
import org.springframework.util.StringUtils;

@SpringBootApplication // that is @Configuration @EnableAutoConfiguration @ComponentScan
@EnableSpringConfigured // for spring-aspects
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(final String[] args) throws UnknownHostException, Exception {
		setDerbySystemHome();
		final ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		final String derbyPortString = applicationContext.getEnvironment().getProperty("derby.port");
		startDerbyNetworkServer(derbyPortString);
	}

	private static void setDerbySystemHome() {
		final String derbySystemHomeKey = "derby.system.home";
		final String derbySystemHomeValue = System.getProperty(derbySystemHomeKey);
		if (derbySystemHomeValue == null) {
			final String userHomeValue = System.getProperty("user.home");
			System.setProperty(derbySystemHomeKey, userHomeValue);
		}
		log.info("Directory {} is location for Derby databases, file derby.log and configuration file derby.properties",
				System.getProperty(derbySystemHomeKey));
	}

	@Bean
	@Autowired
	public CommandLineRunner startCommandLineRunner(final ApplicationContext applicationContext) {
		return args -> {
			log.info("Spring Application started.");
			// displayAllBeans(applicationContext);
		};
	}

	private static void startDerbyNetworkServer(final String derbyPort) throws Exception {
		log.info("Starting Derby Network Server with derby.port={}", derbyPort);
		final boolean useDefaultPort = StringUtils.isEmpty(derbyPort);
		final NetworkServerControl server;
		if (useDefaultPort) {
			server = new NetworkServerControl();
		} else {
			final int configuredPortNumber = Integer.parseInt(derbyPort);
			final int derbyPortNumber = configuredPortNumber != 0 ? configuredPortNumber
					: SocketUtils.findAvailableTcpPort(10000);
			server = new NetworkServerControl(InetAddress.getByName("localhost"), derbyPortNumber);
		}
		final PrintWriter printWriter = new PrintWriter(System.out);
		// Starts the Derby network server in a separate thread:
		server.start(printWriter);
		// System.out.println(server.getCurrentProperties());
	}

	private static void displayAllBeans(final ApplicationContext applicationContext) {
		System.out.println("Application.displayAllBeans:");
		final String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		for (final String beanName : allBeanNames) {
			System.out.println(beanName);
		}
	}

}
