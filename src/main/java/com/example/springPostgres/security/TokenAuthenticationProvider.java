package com.example.springPostgres.security;

import com.example.springPostgres.repositories.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

@Component
public class TokenAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) {
        Object token = authentication.getCredentials();
        return Optional
                .ofNullable(token)
                .flatMap(t ->
                        Optional.of(userAuthenticationService.authenticateByToken(String.valueOf(t)))
                                .map(u -> User.builder()
                                        .username(u.getUsername())
                                        .password(u.getPassword())
                                        .roles("user")
                                        .build()))
                .orElseThrow(() -> new BadCredentialsException("Invalid authentication token=" + token));
    }

}
