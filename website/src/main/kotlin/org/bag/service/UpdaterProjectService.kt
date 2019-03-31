package org.bag.service

import mu.KotlinLogging
import org.bag.domain.Image
import org.bag.domain.Project
import org.bag.dto.UpdaterProject
import org.bag.dto.UpdaterProjectImage
import org.bag.repositories.ImageRepository
import org.bag.repositories.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * [Project] CRUD functionaliteit voor de Updater.
 */
@Component
class UpdaterProjectService @Autowired constructor(
        private val projectRepository: ProjectRepository,
        private val imageRepository: ImageRepository){

    private val logger = KotlinLogging.logger {  }

    /**
     * Update of insert een [Project] aan de hand van een [updaterProject]
     */
    fun putProject(updaterProject: UpdaterProject){
        if(updaterProject.id == 0){
            insertProject(updaterProject)
        }
        else {
            updateProject(updaterProject)
        }
    }

    /**
     * [Project] updaten adhv [updaterProject]
     */
    private fun updateProject(updaterProject: UpdaterProject) {
        logger.info { "Project update '${updaterProject.titel_nl}'" }
        val oproject = projectRepository.findById(updaterProject.id)
        if (!oproject.isPresent)
            throw Exception()

        val project = oproject.get()
        project.titel_nl = updaterProject.titel_nl
        project.locatie_nl = updaterProject.locatie_nl
        project.text_nl = updaterProject.text_nl
        updateLanguageProperties(project, updaterProject)

        var frontendIndex = -1
        var bannerIndex = -1
        for (i in updaterProject.images.indices) {
            val updaterImage = updaterProject.images[i]
            if (updaterImage.isFrontend)
                frontendIndex = i
            if (updaterImage.isBanner)
                bannerIndex = i

            if (updaterImage.id == 0) {
                val image = Image(updaterImage.url)
                imageRepository.save(image)
                project.addImage(image)
            }
        }
        removeImagesIfNotPresent(project,updaterProject.images)

        if (bannerIndex == -1 || frontendIndex == -1)
            throw Exception("Geen banner of frontend image opgegeven")
        project.setBannerImage(bannerIndex)
        project.setFrontendImage(frontendIndex)
        projectRepository.save(project)
    }

    /**
     * Verwijder plaatjes uit [project] als ze niet meer voorkomen tussen [updaterImages]
     */
    private fun removeImagesIfNotPresent(project: Project, updaterImages: ArrayList<UpdaterProjectImage>) {
        val notPresent = project.images.filter { updaterImages.find { updaterProjectImage -> updaterProjectImage.url == it.url } == null }
        for(image in notPresent) {
            project.removeImage(image)
            imageRepository.delete(image)
        }
    }

    /**
     * Nieuw project inserten adhv [updaterProject]
     */
    private fun insertProject(updaterProject: UpdaterProject) {
        logger.info { "New project '${updaterProject.titel_nl}'" }
        val images = ArrayList<Image>()
        var frontendIndex = -1
        var bannerIndex = -1
        for (i in updaterProject.images.indices) {
            val updaterImage = updaterProject.images[i]
            if (updaterImage.isFrontend)
                frontendIndex = i
            if (updaterImage.isBanner)
                bannerIndex = i

            val image = Image(updaterImage.url)
            imageRepository.save(image)
            images.add(image)
        }

        if (bannerIndex == -1 || frontendIndex == -1)
            throw Exception("Geen banner of frontend image opgegeven")

        val order = projectRepository.findAll().count() + 1
        val project = Project(order, updaterProject.titel_nl, updaterProject.locatie_nl, updaterProject.text_nl, images, bannerIndex, frontendIndex)
        updateLanguageProperties(project, updaterProject)
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
}