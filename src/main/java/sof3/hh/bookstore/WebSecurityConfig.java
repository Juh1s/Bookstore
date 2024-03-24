package sof3.hh.bookstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import sof3.hh.bookstore.web.UserDetailServiceImpl;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;
import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration  
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

    @Autowired
    UserDetailServiceImpl userDetailsService;

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {

		http
        .authorizeHttpRequests(authorize -> authorize
			.requestMatchers("/", "/index").permitAll()
            .requestMatchers(antMatcher("/delete/**")).hasRole("ADMIN")
            .requestMatchers(toH2Console()).permitAll()
			.anyRequest().authenticated()
		)
        .csrf(csrf -> csrf
             .ignoringRequestMatchers(toH2Console())
        )
        .headers(headers -> headers
            .frameOptions(frameoptions -> frameoptions
                     .disable())
        )
		.formLogin(formlogin -> formlogin
			.loginPage("/login")
            .defaultSuccessUrl("/booklist", true)
            .permitAll()
		)
		.logout(logout -> logout
			.permitAll()
		);	
		return http.build();
	}

    /*@Bean
    public UserDetailsService userDetailsService() {
        List<UserDetails> users = new ArrayList<UserDetails>();

        //PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();

        users.add(user);

        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("USER", "ADMIN")
                .build();
        
        users.add(user2);
        
        return new InMemoryUserDetailsManager(users);
    }*/

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new
            BCryptPasswordEncoder());
    }
}