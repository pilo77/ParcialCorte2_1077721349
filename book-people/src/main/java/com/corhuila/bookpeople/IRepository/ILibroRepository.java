package com.corhuila.bookpeople.IRepository;

import com.corhuila.bookpeople.Document.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibroRepository extends MongoRepository<Libro, String> {
}
