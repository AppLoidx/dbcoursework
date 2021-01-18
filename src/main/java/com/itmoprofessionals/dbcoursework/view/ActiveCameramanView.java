package com.itmoprofessionals.dbcoursework.view;

import com.itmoprofessionals.dbcoursework.repo.employee.ContractRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/active/cameraman")
public class ActiveCameramanView {
    private final ContractRepo contractRepo;

    public ActiveCameramanView(ContractRepo contractRepo) {
        this.contractRepo = contractRepo;
    }

    @GetMapping
    public String cameramanView(Model model) {
        model.addAttribute("cameramans", contractRepo.activeCameraman());
        return "active_cameramans";
    }
}
