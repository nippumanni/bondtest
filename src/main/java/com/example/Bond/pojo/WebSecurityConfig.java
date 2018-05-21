package com.example.Bond.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	BondService bondservice;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser("user1").password("user1Pass").roles("USER");
    }
	
	 @Override
    protected void configure(HttpSecurity http) throws Exception {
 
        http.csrf().disable();
 
        // The pages does not require login
        http.authorizeRequests().antMatchers("/", "/loginn", "/logout").permitAll();
 
        // /userInfo page requires login as ROLE_USER or ROLE_ADMIN.
        // If no login, it will redirect to /login page.
        http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
 
     	
	
    // For ADMIN only.
    http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");

    // When the user has logged in as XX.
    // But access a page that requires role YY,
    // AccessDeniedException will be thrown.
    http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

    // Config for Login Form
    http.authorizeRequests().and().formLogin()//
            // Submit URL of login page.
            .loginProcessingUrl("/j_spring_security_check") // Submit URL
            .loginPage("/login")//
            .defaultSuccessUrl("/userAccountInfo")//
            .failureUrl("/login?error=true")//
            .usernameParameter("username")//
            .passwordParameter("password")
            // Config for Logout Page
            .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
// all other pages as not in login....
}
}
