package org.bag.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bag.dto.UpdaterProject;
import org.bag.dto.UpdaterProjectImage;
import org.bag.dto.UpdaterProjectListItem;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

public class JacksonTest {

    @Test
    public void Test(){
        String json = "{\n" +
                "  \"titel_en\": \"titel engels\",\n" +
                "  \"titel_zh\": \"city garden chinees\",\n" +
                "  \"locatie_en\": \"Location man\",\n" +
                "  \"locatie_nl\": \"Amstelveen\",\n" +
                "  \"locatie_zh\": \"ook iets plaates\",\n" +
                "  \"text_en\": \"Cool blabla\",\n" +
                "  \"text_zh\": \"sjingie sjongie\",\n" +
                "  \"titel_nl\": \"City Garden\",\n" +
                "  \"text_nl\": \"Dit is dus nieuwe sheisse vanuit putproject.sh\",\n" +
                "  \"images\": [{\"url\": \"www.jemoer.nl\"},{\"url\": \"www.doenogmaar1.nl\"}]\n" +
                "}";

       // UpdaterProject project = new UpdaterProject();
      //  project.getImages().add(new UpdaterProjectImage());

        ObjectMapper mapper = new ObjectMapper();
        try {
            UpdaterProject updaterProject = mapper.readValue(json, UpdaterProject.class);
            System.out.println(updaterProject.getImages().size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   // @Test
    public void restTest(){
        RestTemplate restTemplate = new RestTemplate();
        UpdaterProject forObject = restTemplate.getForObject("https://bag-java.herokuapp.com/updaterProject/7", UpdaterProject.class);
        Assert.notNull(forObject);
        System.out.println(forObject.getTitel_nl());
    }

    @Test
    public void restTestList(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<UpdaterProjectListItem>> response = restTemplate.exchange(
                "https://bag-java.herokuapp.com/updaterProjectList",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UpdaterProjectListItem>>(){});
        List<UpdaterProjectListItem> employees = response.getBody();
        System.out.println(employees.size());
    }

   // @Test
    public void addProject(){
        UpdaterProjectImage pimage = new UpdaterProjectImage(0,"https://verkenjegeest.com/wp-content/uploads/2016/08/23.-Liefde-die-te-mooi-was-om-waar-te-zijn.jpg",true,true);
        UpdaterProject updaterProject = new UpdaterProject(0,"vanuit test titel","locatie","tekst","titelen","titelzh","locatiezh","localttie","swdfsdf","asdf");
        updaterProject.getImages().add(pimage);

        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.put("https://bag-java.herokuapp.com/updaterProject",updaterProject,UpdaterProject.class);
        restTemplate.put("http://localhost:5000/updaterProject",updaterProject,UpdaterProject.class);
    }

   // @Test
    public void removeProject(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject("http://localhost:5000/removeProject/69",String.class);
    }
}
