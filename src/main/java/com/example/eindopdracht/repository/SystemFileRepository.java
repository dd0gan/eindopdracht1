package com.example.eindopdracht.repository;

import com.example.eindopdracht.model.SystemFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemFileRepository extends JpaRepository<SystemFile, Integer> {
    public SystemFile findByFileId(String fileId);
}
