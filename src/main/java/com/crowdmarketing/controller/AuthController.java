package com.crowdmarketing.controller;

import com.crowdmarketing.model.requests.AuthRequest;
import com.crowdmarketing.model.requests.SignupRequest;
import com.crowdmarketing.service.user.RegistrationService;
import com.crowdmarketing.service.user.UserDetailServiceImpl;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@CrossOrigin
@RestController
@RequestMapping("/v1/api/user")
public class AuthController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    @PostMapping("/registration")
    public ResponseEntity<String> register(@RequestBody @Valid SignupRequest signupRequest) {

        return registrationService.register(signupRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest authenticationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {

        return userDetailService.login(authenticationRequest);
    }

    @SneakyThrows
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        logoutSuccessHandler.onLogoutSuccess(request,response,authentication);
        return ResponseEntity.ok("logout success");
    }

}
