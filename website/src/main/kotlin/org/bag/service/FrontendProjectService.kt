package org.bag.service

import com.cloudinary.Cloudinary
import com.cloudinary.utils.ObjectUtils
import org.bag.domain.Project
import org.bag.domain.Image
import org.bag.dto.FrontendProject
import org.bag.dto.assemblers.FrontendProjectAssembler
import org.bag.repositories.ImageRepository
import org.bag.repositories.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component
import java.io.File

import java.util.ArrayList
import java.util.HashMap
import java.util.Locale
import java.util.Optional

@Component
class FrontendProjectService @Autowired constructor (
        private val projectRepository: ProjectRepository) {

    fun getProject(id: Int, locale: Locale): FrontendProject? {
        val optionalProject = projectRepository.findById(id)
        if (!optionalProject.isPresent)
            return null

        val project = optionalProject.get()
        return FrontendProjectAssembler(project).assemble(locale)
    }

    /**
     * Alle projecten in opgegeven [locale]
     */
    fun getAllProjects(locale: Locale): List<FrontendProject> {
        val frontendProjects = ArrayList<FrontendProject>()
        val projects = projectRepository.findAll(Sort.by("order"))
        for (project in projects) {
            val assembler = FrontendProjectAssembler(project)
            frontendProjects.add(assembler.assemble(locale))
        }
        return frontendProjects
    }
}
