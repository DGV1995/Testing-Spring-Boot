package diegogarciaviana.unit5.repositories;


import diegogarciaviana.unit5.model.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
