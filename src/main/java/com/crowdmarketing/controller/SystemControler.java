package com.crowdmarketing.controller;

import com.crowdmarketing.model.dtos.SystemDto;
import com.crowdmarketing.model.user.entity.System;
import com.crowdmarketing.model.user.entity.User;
import com.crowdmarketing.repository.SystemRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/api/system")
@SecurityRequirement(name = "Authorization")
public class SystemControler {

    @Autowired
    private SystemRepository systemRepository;

    @GetMapping("")
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<List<System>> getUserSystem(@AuthenticationPrincipal User user) {
        String s = user.getEmail();
        return ResponseEntity.ok(systemRepository.findByUserId(((User) user).getId()));
    }

    @PostMapping("")
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<System> updateUserSystem(@AuthenticationPrincipal User user, @RequestBody SystemDto systemDto) {
        System sys = systemRepository.findById(systemDto.getId()).orElse(new System());
        if (systemDto.getId() != null)
            sys.setId(systemDto.getId());
        sys.setUser(user);
        if (systemDto.getGercon1() != null)
            sys.setGercon1(systemDto.getGercon1());
        if (systemDto.getGercon2() != null)
            sys.setGercon2(systemDto.getGercon2());
        if (systemDto.getTamper1() != null)
            sys.setTamper1(systemDto.getTamper1());
        if (systemDto.getTamper2() != null)
            sys.setTamper2(systemDto.getTamper2());

        System res = systemRepository.save(sys);

        return ResponseEntity.ok(sys);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<System> createUserSystem(@AuthenticationPrincipal User user) {
        System sys = new System();
        sys.setUser(user);
        sys.setGercon1(true);
        sys.setGercon2(true);
        sys.setTamper1(true);
        sys.setTamper2(true);

        System res = systemRepository.save(sys);

        return ResponseEntity.ok(sys);
    }

}