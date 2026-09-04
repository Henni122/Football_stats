package oslomet.fotballside.Service;

import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import oslomet.fotballside.DTO.PlayerDTO;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import static org.springframework.web.client.RestClient.builder;

@Service
public class FootballService {

    private final RestClient restClient;

    public FootballService(RestClient.Builder builder) {
        this.restClient = builder()
                .baseUrl("https://v3.football.api-sports.io")
                .defaultHeader("x-apisports-key", "f7b1392fae222d5f75cc58473a670453")
                .build();

    }

    public List<PlayerDTO> getPlayer(String search) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("players/profiles")
                        .queryParam("search", search)
                        .build())
                .retrieve()
                .body(new ParameterizedTypeReference<List<PlayerDTO>>() {});
    }

    /*
    public List<PlayerDTO> searchPlyer(String search) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/players")
                        .queryParam("search", search)
                        . build())
                .retrieve()
                .body(new ParameterizedTypeReference<List<PlayerDTO>>() {});
    }

     */
}

