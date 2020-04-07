package hibernate.mtm.controller;

import hibernate.mtm.model.Titre;
import hibernate.mtm.repository.TitreRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/titres")
public class TitreController {

    private final TitreRepository titreRepository;

    public TitreController(TitreRepository titreRepository) {
        this.titreRepository = titreRepository;
    }

    @GetMapping
    public @ResponseBody
    Iterable<Titre> getAll() {
        return titreRepository.findAll();
    }

    @GetMapping(path = "/{titreID}")
    public @ResponseBody
    ResponseEntity<Titre> getOne(@PathVariable long titreID) {
        Optional<Titre> optTitre = titreRepository.findById(titreID);

		return optTitre.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

//	@PatchMapping(path = "/{titreID}")
//	public @ResponseBody Titre update(@PathVariable long titreID, @RequestBody Titre updatedTitre) {
//		updatedTitre.setId(titreID);
//		return titreRepository.save(updatedTitre);
//	}

}

