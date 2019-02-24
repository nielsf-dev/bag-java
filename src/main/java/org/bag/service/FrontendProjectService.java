package org.bag.service;

import org.bag.domain.Project;
import org.bag.domain.ProjectImage;
import org.bag.dto.FrontendProject;
import org.bag.dto.assemblers.FrontendProjectAssembler;

import java.util.ArrayList;
import java.util.List;

public class FrontendProjectService {
    public FrontendProject getProject(int id) throws Exception {
        List<FrontendProject> allProjects = getAllProjects();
        return allProjects.stream().filter(p -> p.getId() == id).distinct().findFirst().get();
    }

    private FrontendProject createFrontendProject(int id, String title, String locatie, int bannerIndex, int frontIndex, String... images) throws Exception {
        ArrayList<ProjectImage> projectImages = new ArrayList<>();
        for (String image :  images) {
            projectImages.add(new ProjectImage(image));
        }

        Project project = new Project(id, title, locatie, projectImages, bannerIndex, frontIndex);
        FrontendProjectAssembler assembler = new FrontendProjectAssembler(project);

        return assembler.assemble();
    }

    public List<FrontendProject> getAllProjects() throws Exception {
        ArrayList<FrontendProject> frontendProjects = new ArrayList<>();

        frontendProjects.add(createFrontendProject(1,"City Garden", "Amstelveen", 0, 1,
                "/upload/portfolio/CityGarden/citygardenavond.jpg",
                "/upload/portfolio/CityGarden/citygardenkop.jpg",
                "/upload/portfolio/CityGarden/citygardentuin.jpg"));

        frontendProjects.add(createFrontendProject(2,"KSH Kinderservice hotel", "Amsterdam", 0, 0,
                "/upload/portfolio/KSH/DSCF3620.JPG",
                "/upload/portfolio/KSH/DSCF3626.JPG"));

        frontendProjects.add(createFrontendProject(3,"Woon werk gebouw", "Amsterdam", 0, 2,
                "upload/portfolio/WoonwerkGebouw/IMG0045.jpg",
                "upload/portfolio/WoonwerkGebouw/IMG0046.jpg",
                "upload/portfolio/WoonwerkGebouw/IMG0047.jpg"));

        frontendProjects.add(createFrontendProject(4,"Starterswoningen", "Amstelveen", 0, 0,
                "upload/portfolio/Starterswoningen/DSCF9671.JPG",
                "upload/portfolio/Starterswoningen/DSCF9683.JPG",
                "upload/portfolio/Starterswoningen/DSCF9664.JPG",
                "upload/portfolio/Starterswoningen/DSCF9669.JPG",
                "upload/portfolio/Starterswoningen/DSCF9670.JPG",
                "upload/portfolio/Starterswoningen/DSCF9676.JPG",
                "upload/portfolio/Starterswoningen/DSCF9685.JPG",
                "upload/portfolio/Starterswoningen/DSCF9690.JPG",
                "upload/portfolio/Starterswoningen/DSCF9711.JPG",
                "upload/portfolio/Starterswoningen/DSCF9718.JPG"));

        frontendProjects.add(createFrontendProject(5,"Saendelft", "Deelplan 6", 0, 0,
                "upload/portfolio/Saendelft/saendelft02.jpg",
                "upload/portfolio/Saendelft/2.jpg"));

        frontendProjects.add(createFrontendProject(6,"Westwijk deelplan 18", "Amsterdam", 0, 0,
                "/upload/portfolio/Westwijk/DSCF9936.JPG",
                "/upload/portfolio/Westwijk/DSCF9931.JPG"));

        frontendProjects.add(createFrontendProject(7,"AZ", "Alkmaar", 1, 0,
                "upload/portfolio/AZ/DSCF4318.JPG",
                "upload/portfolio/AZ/DSCF4317.JPG",
                "upload/portfolio/AZ/IMG0005.jpg"));

        frontendProjects.add(createFrontendProject(8,"Coop", "Amstelveen", 0, 0,
                "/upload/portfolio/coop/2.jpg",
                "/upload/portfolio/coop/1.jpg"));

        frontendProjects.add(createFrontendProject(9,"Paviljoen Zhang Hao", "Amstelveen", 0, 0,
                "/upload/portfolio/ZhangHao/1.jpg",
                "/upload/portfolio/ZhangHao/2.jpg",
                "/upload/portfolio/ZhangHao/3.jpg"));

        frontendProjects.add(createFrontendProject(10,"Appartamenten", "deelplan 4", 0, 0,
                "upload/portfolio/Deelplan4/unnamed.jpg",
                "upload/portfolio/Deelplan4/unnamed2.jpg"));

        frontendProjects.add(createFrontendProject(11,"Gooise poort", "Amstelveen", 0, 0,
                "/upload/portfolio/Gooisepoort/DSCF0106.JPG",
                "/upload/portfolio/Gooisepoort/DSCF0124.JPG",
                "/upload/portfolio/Gooisepoort/DSCF0130.JPG",
                "/upload/portfolio/Gooisepoort/DSCF0133.JPG",
                "/upload/portfolio/Gooisepoort/IMG0029.jpg"));

       frontendProjects.add(createFrontendProject(12,"Westwijk Zuidoost", "Amstelveen", 0, 2,
                "/upload/portfolio/WestwijkZuidoost/DSC_0256.jpeg",
                "/upload/portfolio/WestwijkZuidoost/DSC_0261.jpeg",
                "/upload/portfolio/WestwijkZuidoost/DSC_0265.jpeg"));


        return frontendProjects;
    }
}
