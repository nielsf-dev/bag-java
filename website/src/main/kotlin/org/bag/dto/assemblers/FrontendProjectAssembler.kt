package org.bag.dto.assemblers

import org.bag.domain.Project
import org.bag.dto.FrontendProject

import java.util.ArrayList
import java.util.Locale

/**
 * Maakt een [FrontendProject] aan obv een [project]
 */
class FrontendProjectAssembler(private val project: Project) {

    fun assemble(locale: Locale): FrontendProject {
        val langCode = locale.language
        return FrontendProject(project.id,
                project.getTitle(langCode),
                project.getLocatie(langCode),
                project.getText(langCode),
                project.getBannerImage().url,
                project.getFrontendImage().url,
                getImageList(project))
    }

    private fun getImageList(project: Project): List<String> {
        val images = ArrayList<String>()
        for (image in project.images) {
            images.add(image.url)
        }
        return images
    }


}
