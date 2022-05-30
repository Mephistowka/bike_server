package com.crowdmarketing.model.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "systems")
public class System {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @Column(name = "user_id")
//    private Long userId;

    @Column(name = "tamper1")
    private Boolean tamper1;

    @Column(name = "tamper2")
    private Boolean tamper2;

    @Column(name = "gercon1")
    private Boolean gercon1;

    @Column(name = "gercon2")
    private Boolean gercon2;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }

    public Boolean getTamper1() {
        return tamper1;
    }

    public void setTamper1(Boolean tamper1) {
        this.tamper1 = tamper1;
    }

    public Boolean getTamper2() {
        return tamper2;
    }

    public void setTamper2(Boolean tamper2) {
        this.tamper2 = tamper2;
    }

    public Boolean getGercon1() {
        return gercon1;
    }

    public void setGercon1(Boolean gercon1) {
        this.gercon1 = gercon1;
    }

    public Boolean getGercon2() {
        return gercon2;
    }

    public void setGercon2(Boolean gercon2) {
        this.gercon2 = gercon2;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
