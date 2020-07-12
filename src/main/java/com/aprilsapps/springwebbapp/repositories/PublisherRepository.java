package com.aprilsapps.springwebbapp.repositories;

import com.aprilsapps.springwebbapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
