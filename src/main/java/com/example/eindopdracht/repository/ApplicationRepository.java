package com.example.eindopdracht.repository;

import com.example.eindopdracht.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    public List<Application> findByVacancyId(Integer id);
}
