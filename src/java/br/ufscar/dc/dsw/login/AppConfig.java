package br.ufscar.dc.dsw.login;

import javax.sql.DataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public AppConfig() throws ClassNotFoundException {
        dataSource = JDBCUtil.getDataSource();
    }

    public void configure(AuthenticationManagerBuilder builder)
            throws Exception {

        builder.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select email, senha, ativo"
                        + " from Usuario where email = ?")
                .authoritiesByUsernameQuery("select email, nome "
                        + "from Papel where email = ?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }
}