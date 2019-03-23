package org.bag.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler

import javax.sql.DataSource

@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    private val dataSource: DataSource? = null

    @Autowired
    private val accessDeniedHandler: CustomAccessDeniedHandler? = null

    @Autowired
    private val restAuthenticationEntryPoint: RestAuthenticationEntryPoint? = null

    @Autowired
    private val mySuccessHandler: MySavedRequestAwareAuthenticationSuccessHandler? = null

    private val myFailureHandler = SimpleUrlAuthenticationFailureHandler()

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.inMemoryAuthentication()
                .withUser("admin").password(encoder().encode("adminPass")).roles("ADMIN")
                .and()
                .withUser("user").password(encoder().encode("onzin")).roles("USER")
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers("/secret/project").authenticated()
                //   .antMatchers("/api/admin/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .successHandler(mySuccessHandler)
                .failureHandler(myFailureHandler)
                .and()
                .logout()
    }

    @Bean
    fun encoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    //    @Override
    //    protected void configure(HttpSecurity http) throws Exception {
    //        http
    //            .authorizeRequests()
    //                .antMatchers("/", "/home").permitAll()
    //                .anyRequest().authenticated()
    //                .and()
    //                .openidLogin()
    //                .and()
    //            .formLogin()
    //                .loginPage("/login")
    //                .permitAll()
    //                .and()
    //            .logout()
    //                .permitAll();
    //    }
    //
    //    @Bean
    //    @Override
    //    public UserDetailsService userDetailsService() {
    //        UserDetails user =
    //             User.withDefaultPasswordEncoder()
    //                .username("user")
    //                .password("password")
    //                .roles("USER")
    //                .build();
    //
    //        return new InMemoryUserDetailsManager(user);
    //    }
}