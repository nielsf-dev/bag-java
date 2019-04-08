package org.bag.service

import org.bag.domain.Image
import org.bag.domain.Project
import org.bag.dto.UpdaterProject
import org.bag.dto.UpdaterProjectImage
import org.bag.repositories.ImageRepository
import org.bag.repositories.ProjectRepository
import spock.lang.Specification

class ProjectUpdaterSpec extends Specification{

    def "Project inserten"(){
        given: "Een standaard opzet"
        def updaterProject = new UpdaterProject(0,"titel","loca","text","","","","","","")
        def projectRepository = Mock(ProjectRepository)
        projectRepository.findAll() >> new ArrayList<Project>()
        def imageRepository = Mock(ImageRepository)
        def updaterProjectService = new ProjectUpdater(projectRepository,imageRepository)

        when: "Een normaal project word toegevoegd"
        updaterProject.images.add(new UpdaterProjectImage(1,"www.test.nl",true,true))
        updaterProjectService.update(updaterProject)

        then: "Verwacht database calls"
        1 * projectRepository.save({it.order == 1 && it.titel_nl == "titel"})
        1 * imageRepository.save({it.url == "www.test.nl"})

        when: "Geen images worden meegegeven"
        updaterProject.images.clear()
        updaterProjectService.update(updaterProject)

        then: "Verwacht een exception"
        thrown(Exception)
    }

    def "Project updaten"(){
        given: "Een bestaand project"
        def projectImages = [new Image("1.nl"),
                             new Image("2.nl"),
                             new Image("3.nl")]
        def project = new Project(2,"titel","loc","text", projectImages,1,2)
        def projectRepository = Mock(ProjectRepository)
        projectRepository.findById(2) >> new Optional<Project>(project)

        def imageRepository = Mock(ImageRepository)
        def updaterProjectService = new ProjectUpdater(projectRepository, imageRepository)

        def updaterProject = new UpdaterProject(2,"titel-update","loc-update","text-update","","","","","","")
        updaterProject.images = [new UpdaterProjectImage(1,"1.nl",true,false),
                                 new UpdaterProjectImage(2,"2.nl",false,true),
                                 new UpdaterProjectImage(3,"3.nl",false,false),
                                 new UpdaterProjectImage(0,"new.nl",false,false)]

        when: "Een update word uitgevoerd"
        updaterProjectService.update(updaterProject)

        then: "Verwacht een update van het bijbehorende project"
        project.titel_nl == "titel-update"
        project.locatie_nl == "loc-update"
        project.frontendImage.url == "1.nl"
        1 * projectRepository.save(project)
        1 * imageRepository.save({it.url == "new.nl"})
        project.images.find{i -> i.url == "3.nl"} != null

        when: "een plaatje word weggelaten vanuit de updater"
        updaterProject.images.remove(2)
        updaterProjectService.update(updaterProject)

        then: "verwacht een delete uit bijbehorende project"
        project.images.find{i -> i.url == "3.nl"} == null

        when: "alle plaatjes behalve 1 verwijdert"
        updaterProject.images.remove(0)
        updaterProject.images.remove(1)
        updaterProject.images[0].isFrontend = true
        updaterProject.images[0].isBanner = true
        updaterProjectService.update(updaterProject)

        then: "verwacht same bij bijbehorende project"
        project.images.size() == 1

        when: "niet bestaand plaatje toevoegen"
        updaterProject.images.add(new UpdaterProjectImage(187,"",false,false))
        updaterProjectService.update(updaterProject)

        then:
        thrown(Exception)
    }
}
