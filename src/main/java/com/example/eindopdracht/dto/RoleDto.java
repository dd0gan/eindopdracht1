package com.example.eindopdracht.dto;

import javax.validation.constraints.NotEmpty;

public class RoleDto {
    @NotEmpty
    private String rolename;

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
