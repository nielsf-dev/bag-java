package org.bag.controllers

import mu.KotlinLogging
import org.bag.service.FrontendProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.support.RequestContext
import java.util.*
import javax.servlet.http.HttpServletRequest

@Controller
class ProjectController @Autowired constructor(
        private val frontendProjectService: FrontendProjectService) {

    private val logger = KotlinLogging.logger {}

    @GetMapping("/")
    fun index(model: Model, request: HttpServletRequest): String {
        val ctx = RequestContext(request)
        val locale = ctx.locale

        val allProjects = frontendProjectService.getAllProjects(locale)
        logger.debug { "Returning ${allProjects.size} projects for index using lang ${locale.language}" }
        model.addAttribute("projects", allProjects)
        return "index"
    }

    @GetMapping("/project")
    fun getProject(@RequestParam(name = "id") id: Int, model: Model, request: HttpServletRequest): String {
        val ctx = RequestContext(request)
        val locale = ctx.locale

        val project = frontendProjectService.getProject(id, locale) ?: return "error"
        logger.debug{ "Returning ${project.title} with id $id using lang ${locale.language}"}
        model.addAttribute("project", project)
        return "project"
    }

}
