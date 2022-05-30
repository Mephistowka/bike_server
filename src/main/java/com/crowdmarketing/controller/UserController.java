package com.crowdmarketing.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/v1/api/user")
@SecurityRequirement(name = "Authorization")
public class UserController {

    @GetMapping("/client")
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<String> getClient() {
        return ResponseEntity.ok("CLIENT");
    }

//    @GetMapping("/freelancer")
//    @PreAuthorize("hasRole('FREELANCER')")
//    public ResponseEntity<String> getFreelancer() {
//        return ResponseEntity.ok("FREELANCER");
//    }

//    @GetMapping("/moderator")
//    @PreAuthorize("hasRole('MODERATOR')")
//    public ResponseEntity<String> getModerator() {
//        return ResponseEntity.ok("MODERATOR");
//    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> getAdmin() {
        return ResponseEntity.ok("ADMIN");
    }
}
