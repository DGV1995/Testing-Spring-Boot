package com.junit5.app.services;

import com.junit5.app.models.Owner;
import java.util.*;

public interface OwnerService {

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
    Set<Owner> findAll();
    Owner findById(Long id);
    void save(Owner owner);
    void delete(Owner owner);
    void deleteById(Long id);

}
