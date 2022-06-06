package com.bikeserver.model.user;

import com.bikeserver.model.user.entity.Role;
import com.bikeserver.model.user.entity.User;
import com.bikeserver.model.requests.SignupRequest;
import com.bikeserver.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class UserMapper {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registrationToEntity(SignupRequest signupRequest) {
        return User.builder()
                .firstName(signupRequest.getFirstName())
                .lastName(signupRequest.getLastName())
                .username(signupRequest.getUsername())
                .email(signupRequest.getEmail())
                .password(passwordEncoder.encode(signupRequest.getPassword()))
                .roles(getDefaultRoles())
                .created(LocalDateTime.now())
                .modified(LocalDateTime.now())
                .build();
    }

    private Set<Role> getDefaultRoles() {
        Set<Role> roles = new HashSet<>();
        roles.add(getClientRole());
        return roles;
    }

//    private Role getFreelancerRole() {
//        return roleRepository.findRoleByRole(RoleName.ROLE_FREELANCER.name());
//    }

    private Role getClientRole() {
        return roleRepository.findRoleByRole(RoleName.ROLE_CLIENT.name());
    }
}
