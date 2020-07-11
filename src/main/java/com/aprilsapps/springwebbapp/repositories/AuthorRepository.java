package com.aprilsapps.springwebbapp.repositories;

import com.aprilsapps.springwebbapp.domain.Author;
import org.springframework.data.repository.CrudRepository;
//Spring data Jpa will provide implementation for us at run time.
public interface AuthorRepository extends CrudRepository<Author, Long> {


}
