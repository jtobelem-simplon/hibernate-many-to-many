package hibernate.mtm.controller;

import hibernate.mtm.model.Auteur;
import hibernate.mtm.repository.AuteurRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/auteurs")
public class AuteurController {

    private final AuteurRepository auteurRepository;

    public AuteurController(AuteurRepository auteurRepository) {
        this.auteurRepository = auteurRepository;
    }

    @GetMapping
    public @ResponseBody
    Iterable<Auteur> getAll() {
        return auteurRepository.findAll();
    }

    @GetMapping(path = "/{auteurID}")
    public @ResponseBody
    ResponseEntity<Auteur> getOne(@PathVariable long auteurID) {
        Optional<Auteur> optAuteur = auteurRepository.findById(auteurID);

        return optAuteur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
