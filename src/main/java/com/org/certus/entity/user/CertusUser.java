package com.org.certus.entity.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class CertusUser implements UserDetails {
    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    private String userJobNumber;

    private String password;

    private String userId;

    @Transient
    private List<CertusRole> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserJobNumber() {
        return userJobNumber;
    }

    public void setUserJobNumber(String userJobNumber) {
        this.userJobNumber = userJobNumber;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        List<CertusRole> roles = this.getRoles();
        for (CertusRole role : roles) {
            auths.add(new SimpleGrantedAuthority(role.getRoleUpperName()));
        }
        return auths;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userJobNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    @JoinTable(name = "certus_user_roles", joinColumns = {@JoinColumn(name = "certus_user_id")}, inverseJoinColumns =
            {@JoinColumn
                    (name = "roles_id")})
    public List<CertusRole> getRoles() {
        return roles;
    }

    public void setRoles(List<CertusRole> roles) {
        this.roles = roles;
    }
}
