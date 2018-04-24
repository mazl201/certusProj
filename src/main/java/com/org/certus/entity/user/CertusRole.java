package com.org.certus.entity.user;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CertusRole {

    @Id
    @GeneratedValue
    private Long id;

    private String roleCode;

    private String roleName;

    private String roleUpperName;

    @Transient
    private Set<CertusUser> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleUpperName() {
        return roleUpperName;
    }

    public void setRoleUpperName(String roleUpperName) {
        this.roleUpperName = roleUpperName;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    //NotFound : 意思是找不到引用的外键数据时忽略，NotFound默认是exception
    @NotFound(action = NotFoundAction.IGNORE)
    public Set<CertusUser> getUsers() {
        return users;
    }

    public void setUsers(Set<CertusUser> users) {
        this.users = users;
    }
}
