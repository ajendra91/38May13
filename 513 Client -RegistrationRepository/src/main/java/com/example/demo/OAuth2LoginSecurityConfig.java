package com.example.demo;/*package com.example.demo;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;

@Configuration
public class OAuth2LoginSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	public ClientRegistrationRepository clientRegistrationRepository;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.mvcMatchers("/create-message").hasAuthority("CREATE_MESSAGE")
		.mvcMatchers("/read-message").hasAuthority("READ_MESSAGE")
		.mvcMatchers("/update-message").hasAuthority("UPDATE_MESSAGE")
		.mvcMatchers("/delete-message").hasAuthority("DELETE_MESSAGE")
		.mvcMatchers("/manage-message").hasAuthority("MANAGE_MESSAGE")
		.and()
		.oauth2Login()
			.userInfoEndpoint()
				.userAuthoritiesMapper(this.oktaUserAuthoritiesMapper());
	}

	@Bean
	public InMemoryOAuth2AuthorizedClientService clientRegistrationRepository() {
		return new InMemoryOAuth2AuthorizedClientService(this.clientRegistrationRepository);
	}
	
	private GrantedAuthoritiesMapper oktaUserAuthoritiesMapper() {
		
		String issuerClaim = "https://dev-829719.oktapreview.com";
		String authoritiesClaimName = "authorities";
		
		return (authorities) ->
				authorities.stream()
					.filter(OidcUserAuthority.class::isInstance)
					.map(OidcUserAuthority.class::cast)
					.filter(userAuthority -> userAuthority.getIdToken().getIssuer().toString().equals(issuerClaim))
					.filter(userAuthority -> userAuthority.getUserInfo().containsClaim(authoritiesClaimName))
					.map(userAuthority -> userAuthority.getUserInfo().getClaimAsString(authoritiesClaimName))
					.flatMap(Collection::stream)
					.map(SimpleGrantedAuthority::new)
					.Collect(Collectors.toCollection(LinkedHashSet::new));
					
					
					
	}	

}*/
