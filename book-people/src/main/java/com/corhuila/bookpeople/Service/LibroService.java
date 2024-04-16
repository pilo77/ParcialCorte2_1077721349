package com.corhuila.bookpeople.Service;

import com.corhuila.bookpeople.Document.Libro;
import com.corhuila.bookpeople.IRepository.ILibroRepository;
import com.corhuila.bookpeople.IService.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService implements ILibroService {

    //Conectar con los datos - IRepository
    // Inyección de dependencia
    @Autowired
    private ILibroRepository repository;


    @Override
    public List<Libro> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Libro> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Libro save(Libro libro) {
        return repository.save(libro);
    }

    @Override
    public void update(Libro libro, String id) {
        //Obtener el objeto libro y el id
        //Verificar con el id, si exiten los datos
        Optional<Libro> ps = repository.findById(id);

        //Cargar nuevo objeto
        if (!ps.isEmpty()){
            Libro libroUpdate = ps.get();
            libroUpdate.setTitulo(libro.getTitulo());
            libroUpdate.setIsbn(libro.getIsbn());
            libroUpdate.setGenero(libro.getGenero());
            libroUpdate.setAnioPublication(libro.getAnioPublication());
            libroUpdate.setSinopsis(libro.getSinopsis());
            libroUpdate.setAutor(libro.getAutor());
            //Actualizar el objeto libro
            repository.save(libroUpdate);
        }else{
            System.out.println("No existe el libro");
        }
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}

