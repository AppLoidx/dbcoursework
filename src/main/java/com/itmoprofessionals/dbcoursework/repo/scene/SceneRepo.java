package com.itmoprofessionals.dbcoursework.repo.scene;

import com.itmoprofessionals.dbcoursework.domain.scene.Scene;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SceneRepo extends JpaRepository<Scene, UUID> {
}
