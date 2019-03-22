package org.bag.service

import org.bag.domain.Project
import org.bag.domain.Image
import org.bag.dto.FrontendProject
import org.bag.dto.assemblers.FrontendProjectAssembler
import org.bag.repositories.ImageRepository
import org.bag.repositories.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import java.util.ArrayList
import java.util.Locale
import java.util.Optional

@Component
class FrontendProjectService @Autowired constructor (
        private val projectRepository: ProjectRepository,
        private val imageRepository: ImageRepository) {


    fun getProject(id: Int, locale: Locale): FrontendProject? {
        val optionalProject = projectRepository.findById(id)
        if (!optionalProject.isPresent)
            return null

        val project = optionalProject.get()
        return FrontendProjectAssembler(project).assemble(locale)
    }

    /**
     * Alle projecten in opgegeven Locale
     */
    fun getAllProjects(locale: Locale): List<FrontendProject> {
        val frontendProjects = ArrayList<FrontendProject>()
        val projects = projectRepository.findAll()
        for (project in projects) {
            val assembler = FrontendProjectAssembler(project)
            frontendProjects.add(assembler.assemble(locale))
        }
        return frontendProjects
    }

    private fun createProject(title: String, locatie: String, text: String, bannerIndex: Int, frontIndex: Int, vararg imageUrls: String): Project {
        val projectImages = ArrayList<Image>()
        for (imageUrl in imageUrls) {
            val image = Image(imageUrl)
            imageRepository.save(image)
            projectImages.add(image)
        }

        val project = Project(title, locatie, text, projectImages, bannerIndex, frontIndex)
        if (project.getTitle("") === "City Garden") {
            project.text_nl = "Amstelveen IS HEEL LEUK"
            project.text_en = "Amstelveen IS SO COOL"
            project.text_zh = "SJING SJONG"
            project.titel_en = "Amstelveen man"
            project.locatie_en = "Location man"
        }

        projectRepository.save(project)
        return project
    }

    fun createProjects() {
        val amstelveen = createProject("City Garden", "Amstelveen", "", 0, 1,
                "/upload/portfolio/CityGarden/citygardenavond.jpg",
                "https://res.cloudinary.com/bag187/image/upload/v1553254071/samples/imagecon-group.jpg",
                "/upload/portfolio/CityGarden/citygardenkop.jpg",
                "/upload/portfolio/CityGarden/citygardentuin.jpg")

        createProject("KSH Kinderservice hotel", "Amsterdam", "", 0, 0,
                "/upload/portfolio/KSH/DSCF3620.JPG",
                "/upload/portfolio/KSH/DSCF3626.JPG")

        createProject("Woon werk gebouw", "Amsterdam", "", 0, 2,
                "upload/portfolio/WoonwerkGebouw/IMG0045.jpg",
                "upload/portfolio/WoonwerkGebouw/IMG0046.jpg",
                "upload/portfolio/WoonwerkGebouw/IMG0047.jpg")

        createProject("Starterswoningen", "Amstelveen", "", 0, 0,
                "upload/portfolio/Starterswoningen/DSCF9671.JPG",
                "upload/portfolio/Starterswoningen/DSCF9683.JPG",
                "upload/portfolio/Starterswoningen/DSCF9664.JPG",
                "upload/portfolio/Starterswoningen/DSCF9669.JPG",
                "upload/portfolio/Starterswoningen/DSCF9670.JPG",
                "upload/portfolio/Starterswoningen/DSCF9676.JPG",
                "upload/portfolio/Starterswoningen/DSCF9685.JPG",
                "upload/portfolio/Starterswoningen/DSCF9690.JPG",
                "upload/portfolio/Starterswoningen/DSCF9711.JPG",
                "upload/portfolio/Starterswoningen/DSCF9718.JPG")

        createProject("Saendelft", "Deelplan 6", "", 0, 0,
                "upload/portfolio/Saendelft/saendelft02.jpg",
                "upload/portfolio/Saendelft/2.jpg")

        createProject("Westwijk deelplan 18", "Amsterdam", "", 0, 0,
                "/upload/portfolio/Westwijk/DSCF9936.JPG",
                "/upload/portfolio/Westwijk/DSCF9931.JPG")

        createProject("AZ", "Alkmaar", "", 1, 0,
                "upload/portfolio/AZ/DSCF4318.JPG",
                "upload/portfolio/AZ/DSCF4317.JPG",
                "upload/portfolio/AZ/IMG0005.jpg")

        createProject("Coop", "Amstelveen", "", 0, 0,
                "/upload/portfolio/coop/2.jpg",
                "/upload/portfolio/coop/1.jpg")

        createProject("Paviljoen Zhang Hao", "Amstelveen", "", 0, 0,
                "/upload/portfolio/ZhangHao/1.jpg",
                "/upload/portfolio/ZhangHao/2.jpg",
                "/upload/portfolio/ZhangHao/3.jpg")

        createProject("Appartamenten", "deelplan 4", "", 0, 0,
                "upload/portfolio/Deelplan4/unnamed.jpg",
                "upload/portfolio/Deelplan4/unnamed2.jpg")

        createProject("Gooise poort", "Amstelveen", "", 0, 0,
                "/upload/portfolio/Gooisepoort/DSCF0106.JPG",
                "/upload/portfolio/Gooisepoort/DSCF0124.JPG",
                "/upload/portfolio/Gooisepoort/DSCF0130.JPG",
                "/upload/portfolio/Gooisepoort/DSCF0133.JPG",
                "/upload/portfolio/Gooisepoort/IMG0029.jpg")

        createProject("Westwijk Zuidoost", "Amstelveen", "", 0, 2,
                "/upload/portfolio/WestwijkZuidoost/DSC_0256.jpeg",
                "/upload/portfolio/WestwijkZuidoost/DSC_0261.jpeg",
                "/upload/portfolio/WestwijkZuidoost/DSC_0265.jpeg")
    }
}
