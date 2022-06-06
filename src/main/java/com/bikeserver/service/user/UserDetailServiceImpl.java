package com.bikeserver.service.user;

import com.bikeserver.model.requests.AuthRequest;
import com.bikeserver.model.responses.AuthResponse;
import com.bikeserver.repository.UserRepository;
import com.bikeserver.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService loginService;

    @Override
    public UserDetails loadUserByUsername(String str) throws UsernameNotFoundException {
        return userRepository.findByUsername(str);
    }

    public ResponseEntity<AuthResponse> login(AuthRequest authenticationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {

        AuthResponse authResponse = new AuthResponse();
        String jwt = loginService.getJwt(authenticationRequest);
        authResponse.setToken(jwt);

        return ResponseEntity.ok(authResponse);
    }

}
