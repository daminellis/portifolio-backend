package exercicio07.exercicio07.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

    @GetMapping()
    public String recommendMovie(@RequestParam String ambiente, @RequestParam String genero) {
        if (ambiente.equals("sci-fi")) {
            if (genero.equals("comedy")) {
                return "Men in Black";
            } else if (genero.equals("drama")) {
                return "Arrival";
            }
        } else if (ambiente.equals("medieval")) {
            if (genero.equals("comedy")) {
                return "Shrek";
            } else if (genero.equals("drama")) {
                return "Gladiator";
            }
        }
        return "Invalid parameters";
    }
}