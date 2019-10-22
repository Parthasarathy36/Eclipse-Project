package com.hcl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class FilterSecurityImplementation extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Sara").password("darling").roles("Director").and()
				.withUser("Paru").password("darling").roles("Actor");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/success").access("hasRole('Director')")
		.antMatchers("/failure").access("hasRole('Actor')")
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/success").failureUrl("/loginpage?error")
		.and().logout().logoutSuccessUrl("/login?logout");

		http.csrf().disable();
		System.out.println("Hai");
	}
	
}	
