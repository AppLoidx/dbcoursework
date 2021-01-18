package com.itmoprofessionals.dbcoursework.view;

import com.itmoprofessionals.dbcoursework.domain.item.Prop;
import com.itmoprofessionals.dbcoursework.repo.item.PropRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping
public class PropView {
    private final PropRepo propRepo;

    public PropView(PropRepo propRepo) {
        this.propRepo = propRepo;
    }

    @GetMapping("/props")
    public String propsView(Model model) {
        model.addAttribute("props", propRepo.findAll());

        return "props";
    }

    @GetMapping("/prop/{propUUID}")
    public String propView(@PathVariable("propUUID") String uuidString, Model model) {
        Optional<Prop> prop = propRepo.findById(UUID.fromString(uuidString));
        if (prop.isPresent()) {
            model.addAttribute("prop", prop.get());
            return "prop";
        } else {
            return "error";
        }

    }
}
