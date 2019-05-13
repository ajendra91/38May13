package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringDeveloper5Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringDeveloper5Application.class, args);
	}
	
	
	@Autowired
	private OAuth2AuthorizedClientService authorizedClientService;
	
	

	@GetMapping("/app")
	public String index(Model model, OAuth2AuthenticationToken authentication) {
		OAuth2AuthorizedClient authorizedClient =
				this.authorizedClientService.loadAuthorizedClient(
						authentication.getAuthorizedClientRegistrationId(),
						authentication.getName());
		
		return authentication.getName()+""+authorizedClient.getClientRegistration().getClientName();
	}
	
	@GetMapping("/login/oauth2/code/github")
	public String github(Model model, OAuth2AuthenticationToken authentication) {
		OAuth2AuthorizedClient authorizedClient =
				this.authorizedClientService.loadAuthorizedClient(
						authentication.getAuthorizedClientRegistrationId(),
						authentication.getName());
		
		return authentication.getName()+""+authorizedClient.getClientRegistration().getClientName();
	}

}
