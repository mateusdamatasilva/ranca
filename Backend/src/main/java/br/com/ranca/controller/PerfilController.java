package br.com.ranca.controller;

import br.com.ranca.model.Perfil;
import br.com.ranca.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Valid
public class PerfilController {

    private final PerfilRepository perfilRepository;

    @Autowired
    public PerfilController(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @GetMapping(path = "perfil")
    public ResponseEntity<List<Perfil>>listAll(){
        return new ResponseEntity<>(perfilRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "perfil/{id}")
    public ResponseEntity<Perfil>listOne(@PathVariable Long id){
        return new ResponseEntity<Perfil>(perfilRepository.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping(path = "perfil")
    public ResponseEntity<String>saveProfile(@RequestBody Perfil perfil){
        perfilRepository.save(perfil);
        return ResponseEntity.ok("Perfil criado com sucesso");
    }

    @DeleteMapping(path = "perfil/{id}")
    public ResponseEntity<String>deleteProfile(@PathVariable Long id){
        perfilRepository.deleteById(id);
        return ResponseEntity.ok("Perfil deletado com sucesso");
    }
}
