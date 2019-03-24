package org.bag.controllers

import mu.KotlinLogging
import org.bag.domain.Image
import org.bag.domain.Project
import org.bag.dto.UpdaterProject
import org.bag.repositories.ImageRepository
import org.bag.repositories.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
open class UpdaterProjectController @Autowired constructor(
        private val projectRepository: ProjectRepository,
        private val imageRepository: ImageRepository){

    private val logger = KotlinLogging.logger {  }

    @GetMapping("/secret/project")
    fun somethingSecret() : String{
        return "muchsecret"
    }

    @PutMapping("/project")
    @Transactional
    open fun updateProject(@RequestBody updaterProject: UpdaterProject) {
        if(updaterProject.images.size == 0)
            throw Exception("Empty images")

        var project: Project
        if(updaterProject.id == 0){
            val images = ArrayList<Image>()
            var frontendIndex = -1
            var bannerIndex = -1
            for(i in updaterProject.images.indices){
                val updaterImage = updaterProject.images[i]
                if(updaterImage.isFrontend)
                    frontendIndex = i
                else if(updaterImage.isBanner)
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
                else if(updaterImage.isBanner)
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

    fun getValidatedIndices(updaterProject: UpdaterProject): ValidatedIndices{
        var frontendIndex = -1
        var bannerIndex = -1
        for(i in updaterProject.images.indices){
            val updaterImage = updaterProject.images[i]
            if(updaterImage.isFrontend)
                frontendIndex = i
            else if(updaterImage.isBanner)
                bannerIndex = i
        }

        if(bannerIndex == -1 || frontendIndex == -1)
            throw Exception("Geen banner of frontend image opgegeven")

        return ValidatedIndices(frontendIndex, bannerIndex)
    }

    class ValidatedIndices(val frontendIndex:Int, val bannerIndex:Int)

    private fun updateLanguageProperties(project: Project, updaterProject: UpdaterProject) {
        project.titel_en = updaterProject.titel_en
        project.locatie_en = updaterProject.locatie_en
        project.text_en = updaterProject.text_en

        project.titel_zh = updaterProject.titel_zh
        project.locatie_zh = updaterProject.locatie_zh
        project.text_zh = updaterProject.text_zh
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