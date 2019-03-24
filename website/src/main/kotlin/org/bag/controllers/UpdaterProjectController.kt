package org.bag.controllers

import mu.KotlinLogging
import org.bag.domain.Image
import org.bag.domain.Project
import org.bag.dto.UpdaterProject
import org.bag.dto.UpdaterProjectImage
import org.bag.dto.UpdaterProjectListItem
import org.bag.repositories.ImageRepository
import org.bag.repositories.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
open class UpdaterProjectController @Autowired constructor(
        private val projectRepository: ProjectRepository,
        private val imageRepository: ImageRepository){

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
    open fun updateProject(@RequestBody updaterProject: UpdaterProject) {
        if(updaterProject.images.size == 0)
            throw Exception("Empty images")

        var project: Project
        if(updaterProject.id == 0){
            logger.info { "New project '${updaterProject.titel_nl}'" }
            val images = ArrayList<Image>()
            var frontendIndex = -1
            var bannerIndex = -1
            for(i in updaterProject.images.indices){
                val updaterImage = updaterProject.images[i]
                if(updaterImage.isFrontend)
                    frontendIndex = i
                if(updaterImage.isBanner)
                    bannerIndex = i

                val image = Image(updaterImage.url)
                imageRepository.save(image)
                images.add(image)
            }

            if(bannerIndex == -1 || frontendIndex == -1)
                throw Exception("Geen banner of frontend image opgegeven")

            val order = projectRepository.findAll().count()+1
            project = Project(order, updaterProject.titel_nl, updaterProject.locatie_nl, updaterProject.text_nl, images, bannerIndex, frontendIndex)
            updateLanguageProperties(project, updaterProject)
        }
        else {
            logger.info { "Project update '${updaterProject.titel_nl}'" }
            val oproject = projectRepository.findById(updaterProject.id)
            if (!oproject.isPresent)
                throw Exception()

            project = oproject.get()
            project.titel_nl = updaterProject.titel_nl
            project.locatie_nl = updaterProject.locatie_nl
            project.text_nl = updaterProject.text_nl
            updateLanguageProperties(project, updaterProject)

            var frontendIndex = -1
            var bannerIndex = -1
            for(i in updaterProject.images.indices){
                val updaterImage = updaterProject.images[i]
                if(updaterImage.isFrontend)
                    frontendIndex = i
                if(updaterImage.isBanner)
                    bannerIndex = i

                if(updaterImage.id == 0) {
                    val image = Image(updaterImage.url)
                    imageRepository.save(image)
                    project.addImage(image)
                }
            }

            if(bannerIndex == -1 || frontendIndex == -1)
                throw Exception("Geen banner of frontend image opgegeven")
            project.setBannerImage(bannerIndex)
            project.setFrontendImage(frontendIndex)
        }

        projectRepository.save(project)
    }

    private fun updateLanguageProperties(project: Project, updaterProject: UpdaterProject) {
        project.titel_en = updaterProject.titel_en
        project.locatie_en = updaterProject.locatie_en
        project.text_en = updaterProject.text_en

        project.titel_zh = updaterProject.titel_zh
        project.locatie_zh = updaterProject.locatie_zh
        project.text_zh = updaterProject.text_zh
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