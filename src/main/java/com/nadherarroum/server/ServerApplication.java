package com.nadherarroum.server;

import com.nadherarroum.server.enumeration.Status;
import com.nadherarroum.server.model.Server;
import com.nadherarroum.server.repo.ServerRepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

import java.util.Arrays;

import static com.nadherarroum.server.enumeration.Status.SERVER_DOWN;
import static com.nadherarroum.server.enumeration.Status.SERVER_UP;


@SpringBootApplication
@Configuration
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	/*@Bean
	CommandLineRunner run (ServerRepo serverRepo){
		return args -> {
			serverRepo.save(new Server(
					null, "192.168.1.8",
					"Ubuntu Linux", "8 GB",
					"Personal PC", "http://localhost:8090/server/image/server1.png",
					Status.SERVER_UP)
			);
			serverRepo.save(new Server(
					null, "192.168.1.5",
					"Android", "3 GB",
					"Smart Server", "http://localhost:8090/server/image/server2.png",
					Status.SERVER_UP)
			);
			serverRepo.save(new Server(
					null, "192.168.1.4",
					"Windows", "16 GB",
					"Personal PC", "http://localhost:8090/server/image/server3.png",
					Status.SERVER_UP)
			);
			serverRepo.save(new Server(
					null, "192.168.1.32",
					"Windows", "32 GB",
					"Mailing Server", "http://localhost:8090/server/image/server4.png",
					Status.SERVER_UP)
			);
		};
	}*/

//	@Bean
//	public FilterRegistrationBean corsFilter() {
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration config = new CorsConfiguration();
//		config.setAllowCredentials(Boolean.TRUE);
//		config.addAllowedOrigin(CorsConfiguration.ALL);
//		config.addAllowedHeader(CorsConfiguration.ALL);
//		config.addAllowedMethod(CorsConfiguration.ALL);
//		source.registerCorsConfiguration("/**", config);
//		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//		bean.setOrder(0);
//		return bean;
//	}

	@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://192.168.100.104:4000"); // Origine autorisée
        config.addAllowedHeader("*"); // Autoriser tous les en-têtes
        config.addAllowedMethod("*"); // Autoriser toutes les méthodes (GET, POST, etc.)
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Appliquer pour tous les endpoints
        
        return new CorsFilter(source);
    }
}

}
