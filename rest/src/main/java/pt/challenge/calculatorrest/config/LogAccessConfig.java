package pt.challenge.calculatorrest.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.access.tomcat.LogbackValve;

@Configuration
public class LogAccessConfig {
	
	@Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> containerCustomizer(){
        return new WebServerFactoryCustomizer<TomcatServletWebServerFactory>() {
			public void customize(TomcatServletWebServerFactory factory) {
                LogbackValve  logbackValve = new LogbackValve();
                logbackValve.setFilename("logback-access.xml");
                factory.addContextValves(logbackValve);
			}
        };
    }

}
