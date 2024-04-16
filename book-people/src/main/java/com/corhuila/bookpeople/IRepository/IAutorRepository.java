package com.corhuila.bookpeople.IRepository;

import com.corhuila.bookpeople.Document.Autor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutorRepository extends MongoRepository<Autor, String> {
}
