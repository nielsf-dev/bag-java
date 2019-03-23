package org.bag.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bag.dto.UpdaterProject;
import org.bag.dto.UpdaterProjectImage;
import org.junit.Test;

import java.io.IOException;

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

        UpdaterProject project = new UpdaterProject();
        project.getImages().add(new UpdaterProjectImage());

        ObjectMapper mapper = new ObjectMapper();
        try {
            UpdaterProject updaterProject = mapper.readValue(json, UpdaterProject.class);
            System.out.println(updaterProject.getImages().size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
