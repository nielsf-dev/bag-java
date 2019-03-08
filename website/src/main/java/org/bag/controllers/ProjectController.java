package org.bag.controllers;


import org.bag.dto.FrontendProject;
import org.bag.service.FrontendProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

@Controller
public class ProjectController {

    private FrontendProjectService frontendProjectService;

    @Autowired
    public ProjectController(FrontendProjectService projectService){
        this.frontendProjectService = projectService;
    }

    @PostConstruct
    public void init() throws Exception {
        frontendProjectService.createProjects();
    }

    @GetMapping("/")
    public String index(Model model) throws Exception {
        List<FrontendProject> allProjects = frontendProjectService.getAllProjects();
        model.addAttribute("projects", allProjects);
        return "index";
    }

    @GetMapping("/project")
    public String getProject(@RequestParam(name="id") Integer id, Model model, HttpServletRequest request) throws Exception {
        //Locale locale = RequestContextUtils.getLocale(request);
        RequestContext ctx = new RequestContext(request);
        Locale locale = ctx.getLocale();

        FrontendProject project = frontendProjectService.getProject(id);
        if(project == null)
            return "error";

        model.addAttribute("project",project);
        return "project";
    }

}
