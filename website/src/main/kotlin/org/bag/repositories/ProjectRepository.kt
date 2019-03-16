package org.bag.repositories

import org.bag.domain.Project
import org.springframework.data.repository.CrudRepository

interface ProjectRepository : CrudRepository<Project, Int>
