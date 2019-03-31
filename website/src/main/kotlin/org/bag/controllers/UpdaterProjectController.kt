package org.bag.controllers

import mu.KotlinLogging
import org.bag.domain.Image
import org.bag.domain.Project
import org.bag.dto.UpdaterProject
import org.bag.dto.UpdaterProjectImage
import org.bag.dto.UpdaterProjectListItem
import org.bag.repositories.ImageRepository
import org.bag.repositories.ProjectRepository
import org.bag.service.UpdaterProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
open class UpdaterProjectController @Autowired constructor(
        private val projectRepository: ProjectRepository,
        private val updaterProjectService: UpdaterProjectService){

    private val logger = KotlinLogging.logger {  }

    @GetMapping("/updaterProjectList")
    open fun listProjects() : List<UpdaterProjectListItem>{
        val projects = projectRepository.findAll(Sort.by("order"))
        val updaterProjects = ArrayList<UpdaterProjectListItem>()
        for(project in projects){
            updaterProjects.add(UpdaterProjectListItem(project.id,project.titel_nl))
        }
        return updaterProjects
    }

    @PutMapping("/updaterProject")
    @Transactional
    open fun putProject(@RequestBody updaterProject: UpdaterProject) {
        if(updaterProject.images.size == 0)
            throw Exception("Empty images")
        updaterProjectService.putProject(updaterProject)
    }


    @GetMapping("/removeProject/{id}")
    open fun removeProject(@PathVariable id: Int) {
        projectRepository.deleteById(id);
    }

    @GetMapping("/updaterProject/{id}")
    open fun getProject(@PathVariable id: Int) : UpdaterProject{
        val oproject = projectRepository.findById(id)
        if(oproject.isPresent) {
            val project = oproject.get()
            val updaterProject = UpdaterProject(
                    project.id,
                    project.titel_nl,
                    project.locatie_nl,
                    project.text_nl,
                    project.titel_en,
                    project.titel_zh,
                    project.locatie_en,
                    project.locatie_zh,
                    project.text_en,
                    project.text_zh
            )

            for(image in project.images){
                val isBanner = image == project.getBannerImage()
                val isFrontend = image == project.getFrontendImage()
                val updaterProjectImage = UpdaterProjectImage(image.id,image.url,isFrontend,isBanner)
                updaterProject.images.add(updaterProjectImage)
            }

            return updaterProject
        }
        else
            throw Exception("project niet gevonden")
    }
}