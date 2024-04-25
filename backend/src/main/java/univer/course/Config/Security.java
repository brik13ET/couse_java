package univer.course.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class
Security{

    @Bean
    UserDetailsManager users(DataSource dataSource, PasswordEncoder passwordEncoder)
    {
        var dm = new JdbcUserDetailsManager(dataSource);
        var admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder().encode("my_super_admin_pass"))
                    .roles("ADMIN")
                    .build();
        if (!dm.userExists("admin"))
            dm.createUser(admin);

        System.out.println(admin.getPassword());

        return dm;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        return security
                .csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/login")  .permitAll()
                        .requestMatchers("/home")   .permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/building").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,   "/building").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,    "/building").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,    "/building").hasAnyRole("USER","ADMIN")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
