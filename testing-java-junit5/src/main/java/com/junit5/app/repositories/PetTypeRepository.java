package com.junit5.app.repositories;

import com.junit5.app.models.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
