package org.bag.service

import org.bag.domain.Project
import org.bag.dto.UpdaterProject
import org.bag.dto.UpdaterProjectImage
import org.bag.repositories.ImageRepository
import org.bag.repositories.ProjectRepository
import spock.lang.Specification

class UpdaterProjectServiceSpec extends Specification{
    def "Project inserten"(){
        given:
        def projectRepository = Mock(ProjectRepository)
        projectRepository.findAll() >> new ArrayList<Project>()
        def imageRepository = Mock(ImageRepository)
        def updaterProjectService = new UpdaterProjectService(projectRepository,imageRepository)
        def updaterProject = new UpdaterProject(0,"titel","loca","text","","","","","","")

        when: "normaal project toevoegen"
        updaterProject.images.add(new UpdaterProjectImage(1,"",true,true))
        updaterProjectService.putProject(updaterProject)

        then: "verwacht database calls"
        1 * projectRepository.save(!null)
        1 * imageRepository.save(!null)

        when: "Geen images verwacht exception"
        updaterProject.images.clear()
        updaterProjectService.putProject(updaterProject)

        then:
        thrown(Exception)
    }
}
