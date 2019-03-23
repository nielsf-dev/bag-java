package org.bag.controllers

import mu.KotlinLogging
import org.bag.domain.Project
import org.bag.dto.UpdaterProject
import org.bag.repositories.ProjectRepository
import org.bag.service.FrontendProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class UpdaterProjectController @Autowired constructor(
        private val projectRepository: ProjectRepository){

    private val logger = KotlinLogging.logger {  }

    @GetMapping("/secret/project")
    fun somethingSecret() : String{
        return "muchsecret"
    }

    @PutMapping("/project/{id}")
    fun updateProject(@RequestBody project: UpdaterProject,
                      @PathVariable id: Integer) {
        val frontendImage = project.locatie_en
        logger.info { frontendImage }
    }

    @GetMapping("/getcomplete/{id}")
    fun getComplete(@PathVariable id: Int) : Project{
        val project = projectRepository.findById(id)
        if(project.isPresent)
            return project.get()
        else
            throw Exception()
    }
}