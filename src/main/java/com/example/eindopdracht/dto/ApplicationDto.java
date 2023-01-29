package com.example.eindopdracht.dto;

import javax.validation.constraints.NotEmpty;

public class ApplicationDto {
    private Integer id;
    @NotEmpty
    private UserDto user;
    @NotEmpty
    private VacancyDto vacancy;
    @NotEmpty
    private String status;

    public ApplicationDto() {
    }

    public ApplicationDto(Integer id, UserDto user, VacancyDto vacancy) {
        this.id = id;
        this.user = user;
        this.vacancy = vacancy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public VacancyDto getVacancy() {
        return vacancy;
    }

    public void setVacancy(VacancyDto vacancy) {
        this.vacancy = vacancy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
