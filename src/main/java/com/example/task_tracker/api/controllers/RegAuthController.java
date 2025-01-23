package com.example.task_tracker.api.controllers;

import com.example.task_tracker.api.dto.CustomerDto;
import com.example.task_tracker.api.services.CustomerService;
import com.example.task_tracker.api.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class RegAuthController {

    private final CustomerService customerService;
    private final ProjectService projectService;

    @GetMapping("/")
    public String startPage(){
        return "reg&auth/start-page";
    }

    @GetMapping("/general")
    public String general(Model model, Principal principal){
        model.addAttribute("projects", projectService.findAllByUser(principal));
        return "general";
    }

    @GetMapping("/registry")
    public String registry(){
        return "reg&auth/registry";
    }

    @PostMapping("/registry")
    public String registryP(CustomerDto customer){
        customerService.registry(customer);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "reg&auth/login";
    }

    @GetMapping("/failed-authorization")
    public String failAuth(){
        return "reg&auth/fail";
    }




}
