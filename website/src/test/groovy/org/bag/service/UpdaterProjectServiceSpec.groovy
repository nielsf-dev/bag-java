package org.bag.service

import org.bag.domain.Image
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
        updaterProject.images.add(new UpdaterProjectImage(1,"www.test.nl",true,true))
        updaterProjectService.putProject(updaterProject)

        then: "verwacht database calls"
        1 * projectRepository.save({it.order == 1 && it.titel_nl == "titel"})
        1 * imageRepository.save({it.url == "www.test.nl"})

        when: "Geen images verwacht exception"
        updaterProject.images.clear()
        updaterProjectService.putProject(updaterProject)

        then:
        thrown(Exception)
    }

    def "Project updaten"(){
        given:
            def projectImages = [new Image("1.nl"),
            new Image("2.nl"),
            new Image("3.nl")]
            def project = new Project(2,"titel","loc","text", projectImages,1,2)
            def projectRepository = Mock(ProjectRepository)
            projectRepository.findById(2) >> new Optional<Project>(project)

            def imageRepository = Mock(ImageRepository)
            def updaterProjectService = new UpdaterProjectService(projectRepository, imageRepository)

            def updaterProject = new UpdaterProject(2,"titel-update","loc-update","text-update","","","","","","")
            updaterProject.images = [new UpdaterProjectImage(1,"1.nl",true,false),
            new UpdaterProjectImage(2,"2.nl",false,true),
            new UpdaterProjectImage(3,"3.nl",false,false),
            new UpdaterProjectImage(0,"new.nl",false,false)]

        when:
            updaterProjectService.putProject(updaterProject)

        then:
            project.titel_nl == "titel-update"
            project.locatie_nl == "loc-update"
            project.frontendImage.url == "1.nl"
            1 * projectRepository.save(project)
            1 * imageRepository.save({it.url == "new.nl"})

        when: "plaatje niet meegegeven vanuit updater"
            updaterProject.images.remove(2)
            updaterProjectService.putProject(updaterProject)

        then: "verwacht dan een delete uit project"
            project.images.find{i -> i.url == "3.nl"} == null
    }
}
