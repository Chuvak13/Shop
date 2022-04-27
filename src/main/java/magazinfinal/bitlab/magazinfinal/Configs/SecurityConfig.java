package magazinfinal.bitlab.magazinfinal.Configs;

import magazinfinal.bitlab.magazinfinal.Service.ShopUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,proxyTargetClass = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ShopUsersService shopUsersService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(shopUsersService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .authorizeRequests()
                    .antMatchers("/")
                    .permitAll()
                    .and()
                .formLogin()
                    .loginPage("/login2").permitAll()
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .loginProcessingUrl("/auth")
                    .defaultSuccessUrl("/")
                    .failureUrl("/login2?error")
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login2?logout");

        http.exceptionHandling().accessDeniedPage("/403");
        http.csrf().disable();
    }
}
