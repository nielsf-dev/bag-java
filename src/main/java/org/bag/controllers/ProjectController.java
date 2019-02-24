package org.bag.controllers;


import org.bag.dto.FrontendProject;
import org.bag.service.FrontendProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ProjectController {
    @GetMapping("/")
    public String getProject(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) throws Exception {
        FrontendProjectService service = new FrontendProjectService();
        FrontendProject project = service.getProject(-1);
        model.addAttribute("project",project);
        return "index";
    }

}
