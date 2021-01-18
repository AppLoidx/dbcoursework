package com.itmoprofessionals.dbcoursework.view;

import com.itmoprofessionals.dbcoursework.domain.scene.Scene;
import com.itmoprofessionals.dbcoursework.repo.scene.SceneRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@Controller
public class SceneView {
    private final SceneRepo sceneRepo;

    public SceneView(SceneRepo sceneRepo) {
        this.sceneRepo = sceneRepo;
    }

    @GetMapping("/scene/{sceneUUID}")
    public String scene(@PathVariable("sceneUUID") String sceneUUID, Model model) {
        Optional<Scene> byId = sceneRepo.findById(UUID.fromString(sceneUUID));
        if (byId.isPresent()) {
            model.addAttribute("scene", byId.get());
            return "scene";
        } else {
            return "error";
        }
    }
}
