package com.aprilsapps.springwebbapp.repositories;

import com.aprilsapps.springwebbapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
