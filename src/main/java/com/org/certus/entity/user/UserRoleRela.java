package com.org.certus.entity.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserRoleRela {
    @Id
    @GeneratedValue
    private Long id;

    private String userJobNumber;

    private String userId;

    private String roleCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserJobNumber() {
        return userJobNumber;
    }

    public void setUserJobNumber(String userJobNumber) {
        this.userJobNumber = userJobNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
