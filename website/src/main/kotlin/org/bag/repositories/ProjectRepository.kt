package org.bag.repositories

import org.bag.domain.Project
import org.springframework.data.repository.PagingAndSortingRepository

interface ProjectRepository : PagingAndSortingRepository<Project, Int>
