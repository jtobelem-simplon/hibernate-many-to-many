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

import hibernate.mtm.model.Auteur;
import hibernate.mtm.repository.AuteurRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/auteurs")
public class AuteurController {

@Autowired
private AuteurRepository auteurRepository;
	
	@GetMapping
	public @ResponseBody Iterable<Auteur> getAll() {
		return auteurRepository.findAll();
	}
	
	@GetMapping(path = "/{auteurID}")
	public @ResponseBody ResponseEntity<Auteur> getOne(@PathVariable long auteurID) {
		Optional<Auteur> optauteur = auteurRepository.findById(auteurID);
		
		if (optauteur.isPresent()) {
			return ResponseEntity.ok(optauteur.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}
