package com.example.switer.config;

import com.example.switer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                    .antMatchers("/", "/registration", "/static/**", "/activate/*").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }
//    @Bean
//    public UserDetailsService userDetailService(){
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//  }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .usersByUsernameQuery("select username, password, active from usr where username=?")
//                .authoritiesByUsernameQuery("select u.username, ur.roles from usr u inner join user_role ur on u.id = ur.user_id where u.username=?")
//        ;
    }
}
