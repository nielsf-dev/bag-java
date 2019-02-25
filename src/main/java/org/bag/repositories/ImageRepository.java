package org.bag.repositories;

import org.bag.domain.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image,Integer> {
}
