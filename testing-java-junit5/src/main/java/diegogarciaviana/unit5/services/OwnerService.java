package diegogarciaviana.unit5.services;

import diegogarciaviana.unit5.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
 }
