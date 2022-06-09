package com.carros;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class StarsController {

  private final CarrosRepository repository;

  StarsController(CarrosRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/carros")
  List<Carros> all() {
    return repository.findAll();
  }

  @PostMapping("/carros")
  Carros newCarros(@RequestBody Carros newCarros) {
    return repository.save(newCarros);
  }
  
  @GetMapping("/carros/{id}")
  Carros one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new NotFoundException(id));
  }

  @PutMapping("/carros/{id}")
  Carros replaceStarsModel(@RequestBody Carros newCarros, @PathVariable Long id, String modelo, String nome, String placa, String km) {
    
    return repository.findById(id)
      .map(carros -> {
    	carros.setModelo(newCarros.getModelo());
    	carros.setNome(newCarros.getNome());
    	carros.setPlaca(newCarros.getPlaca());
    	carros.setKm(newCarros.getKm());
        return repository.save(carros);
      })
      .orElseGet(() -> {
    	  newCarros.setId(id);
        return repository.save(newCarros);
      });
  }

  @DeleteMapping("/carros/{id}")
  void delete(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
