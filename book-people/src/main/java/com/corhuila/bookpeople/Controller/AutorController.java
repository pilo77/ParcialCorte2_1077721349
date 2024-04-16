package com.corhuila.bookpeople.Controller;

import com.corhuila.bookpeople.Document.Autor;
import com.corhuila.bookpeople.IService.IAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/autor")

public class AutorController {
    @Autowired
    private IAutorService service;

    @GetMapping()
    public List<Autor> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Autor> findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping()
    public Autor save(@RequestBody Autor autor) {
        return service.save(autor);
    }


    @PutMapping("/{id}")
    public void update(@RequestBody Autor autor, @PathVariable String id) {
        service.update(autor, id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}



