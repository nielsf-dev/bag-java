package org.bag.controllers

import mu.KotlinLogging
import org.bag.domain.Project
import org.bag.dto.UpdaterProject
import org.bag.repositories.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
open class UpdaterProjectController @Autowired constructor(
        private val projectRepository: ProjectRepository){

    private val logger = KotlinLogging.logger {  }

    @GetMapping("/secret/project")
    fun somethingSecret() : String{
        return "muchsecret"
    }

    @PutMapping("/project/{id}")
    @Transactional
    open fun updateProject(@RequestBody updaterProject: UpdaterProject,
                           @PathVariable id: Int) {

        val oproject = projectRepository.findById(id)
        if(!oproject.isPresent)
            throw Exception()

        val project = oproject.get()
        project.titel_nl = updaterProject.titel_nl
        project.locatie_nl = updaterProject.locatie_nl
        project.text_nl = updaterProject.text_nl

        project.titel_en = updaterProject.titel_en
        project.locatie_en = updaterProject.locatie_en
        project.text_en = updaterProject.text_en

        project.titel_zh = updaterProject.titel_zh
        project.locatie_zh = updaterProject.locatie_zh
        project.text_zh = updaterProject.text_zh

        projectRepository.save(project)
    }

    @GetMapping("/getcomplete/{id}")
    fun getComplete(@PathVariable id: Int) : Project{
        val project = projectRepository.findById(id)
        if(project.isPresent)
            return project.get()
        else
            throw Exception()
    }

    @GetMapping("/setcomplete")
    fun setComplete(@RequestBody project: Project) {

    }
}