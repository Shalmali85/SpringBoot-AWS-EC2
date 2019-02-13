package com.javainuse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    private static final String RESOURCE_ID = "notify_api";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        /*http.
                anonymous().disable()
                .requestMatchers().antMatchers("/ping/**")
                .and().authorizeRequests()
                .antMatchers("/test/**").authenticated();
        *//*http.csrf().ignoringAntMatchers("/ping/all").and().authorizeRequests()
                .antMatchers("/**").authenticated();
       */
        http.csrf().disable().headers().frameOptions().sameOrigin().and(). authorizeRequests().anyRequest().anonymous().and().httpBasic().disable();



    }
}
