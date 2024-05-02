package k24.op1.dogbackend;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(antMatcher("/css/**")).permitAll() // Enable CSS when logged out
                        .requestMatchers("/dogstore").permitAll() // Allow access to dogstore page for everyone
                        .requestMatchers("/register").permitAll() // Allow access to dogstore page for everyone

                        .anyRequest().authenticated())
                .formLogin(formLogin -> formLogin
                        .loginPage("/login") // login sivu.
                        .defaultSuccessUrl("/dogstore", true) // frontpage uudelleenm ohjaus
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutRequestMatcher(antMatcher("/logout"))
                        .logoutSuccessUrl("/dogstore"));
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
