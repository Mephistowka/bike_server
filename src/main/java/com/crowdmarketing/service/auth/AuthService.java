package com.crowdmarketing.service.auth;

import com.crowdmarketing.config.jwt.JWTTokenHelper;
import com.crowdmarketing.model.requests.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Component
public class AuthService {

    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private JWTTokenHelper jWTTokenHelper;

    public String getJwt(AuthRequest authenticationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {
        final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jWTTokenHelper.generateToken(authentication, null);
    }
}
