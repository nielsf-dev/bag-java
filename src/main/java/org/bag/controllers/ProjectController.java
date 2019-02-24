package org.bag.controllers;


import org.bag.dto.FrontendProject;
import org.bag.service.FrontendProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectController {
    @GetMapping("/")
    public String index(Model model) throws Exception {
        FrontendProjectService service = new FrontendProjectService();
        List<FrontendProject> allProjects = service.getAllProjects();
        model.addAttribute("projects", allProjects);
        return "index";
    }

    @GetMapping("/project")
    public String getProject(@RequestParam(name="id") Integer id, Model model) throws Exception {
        FrontendProjectService service = new FrontendProjectService();
        FrontendProject project = service.getProject(id);
        model.addAttribute("project",project);
        return "project";
    }

}
