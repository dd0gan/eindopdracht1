package com.example.eindopdracht.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RoleTest {

    @Test
    public void testRole() {
        Role role = new Role("test");
        assertNotNull(role);
    }
}
