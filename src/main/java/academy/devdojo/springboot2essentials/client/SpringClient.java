package academy.devdojo.springboot2essentials.client;

import academy.devdojo.springboot2essentials.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> forEntity = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}", Anime.class, 6);
        log.info(forEntity);

        Anime object = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class, 6);
        log.info(object);

        Anime[] objectArray = new RestTemplate().getForObject("http://localhost:8080/animes/all", Anime[].class);

        log.info(Arrays.toString(objectArray));

        ResponseEntity<List<Anime>> exchange = new RestTemplate().exchange("http://localhost:8080/animes/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });

        log.info(exchange);
//
//        Anime kingdom = Anime.builder().name("Kingdom").build();
//        Anime kingdomSaved = new RestTemplate().postForObject("http://localhost:8080/animes/", kingdom, Anime.class);
//        log.info("Saved anime {}",kingdomSaved);

        Anime zatchbell = Anime.builder().name("Zatchbell").build();
        ResponseEntity<Anime> exchange1 = new RestTemplate().exchange("http://localhost:8080/animes/", HttpMethod.POST, new HttpEntity<>(zatchbell, createJsonHeader()), Anime.class);

        log.info("saved anime {}", exchange1);
    }

    public static HttpHeaders createJsonHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}
