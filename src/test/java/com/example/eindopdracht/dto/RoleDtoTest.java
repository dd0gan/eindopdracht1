package com.example.eindopdracht.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RoleDtoTest {
    @Test
    public void testRoleDto() {
        RoleDto roleDto = new RoleDto();
        assertNotNull(roleDto);
    }
}
