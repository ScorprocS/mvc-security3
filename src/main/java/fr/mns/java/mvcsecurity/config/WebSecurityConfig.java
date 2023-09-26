package fr.mns.java.mvcsecurity.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity( securedEnabled = true,jsr250Enabled = true,prePostEnabled = true)
public class WebSecurityConfig {
		
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home","/login").permitAll()
				.requestMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated()
			)
			//define custom login
			/*.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
			)*/
			.formLogin(withDefaults())
			.logout((logout) -> logout.permitAll());

		return http.build();
		
		 
	}
//https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/dao-authentication-provider.html
	 /*	@Bean
	    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder) {
	        UserDetails user = User.withUsername("user")
	            .password(passwordEncoder.encode("password"))
	            .roles("USER")
	            .build();

	        UserDetails admin = User.withUsername("admin")
	            .password(passwordEncoder.encode("admin"))
	            .roles("USER", "ADMIN")
	            .build();

	        return new InMemoryUserDetailsManager(user, admin);
	    }
	 
	*/
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http,  PasswordEncoder passwordEncoder) 
	  throws Exception {
	    return http.getSharedObject(AuthenticationManagerBuilder.class)
	      .userDetailsService(userDetailsService)
	      .passwordEncoder(passwordEncoder)
	      .and()
	      .build();
	}

}
