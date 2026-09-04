package oslomet.fotballside.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import oslomet.fotballside.DTO.PlayerDTO;
import oslomet.fotballside.DTO.PlayerDeserializer;
import oslomet.fotballside.Service.FootballService;

import java.util.List;


@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class FootballController {

    private final FootballService footballService;
    @Value("${app.api.key}")
    private String apiKey;

    public FootballController(FootballService footballService) {
        this.footballService = footballService;
    }


    @RequestMapping("/")
    public String landingPage() {
        return "Landing_page.html";
    }


    @GetMapping("https://v3.football.api-sports.io")
    public String testAPIKEY() {
        return apiKey;
    }


    //Henter ut spillerprofiler for enkeltspillere (f.eks. Lionel Messi)
    @GetMapping("/players/profiles")
    @ResponseBody
    public List<PlayerDTO> getPlayer(@RequestParam(name = "search") String search) {
        return footballService.getPlayer(search);
    }

/*
    @GetMapping("/spillere")
    @ResponseBody
    public List<PlayerDTO> searchPlayer(@RequestParam String search) {
        return footballService.searchPlyer(search);
    }

 */

}
