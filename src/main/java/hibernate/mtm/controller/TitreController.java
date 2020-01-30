package hibernate.mtm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hibernate.mtm.model.Titre;
import hibernate.mtm.repository.TitreRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/titres")
public class TitreController {
	
	@Autowired
	private TitreRepository titreRepository;
	
	@GetMapping
	public @ResponseBody Iterable<Titre> getAll() {
		return titreRepository.findAll();
	}
	
	@GetMapping(path = "/{titreID}")
	public @ResponseBody ResponseEntity<Titre> getOne(@PathVariable long titreID) {
		Optional<Titre> optTitre = titreRepository.findById(titreID);
		
		if (optTitre.isPresent()) {
			return ResponseEntity.ok(optTitre.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}

