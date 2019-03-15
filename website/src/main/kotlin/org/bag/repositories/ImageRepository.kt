package org.bag.repositories

import org.bag.domain.Image
import org.springframework.data.repository.CrudRepository

interface ImageRepository : CrudRepository<Image, Int>
