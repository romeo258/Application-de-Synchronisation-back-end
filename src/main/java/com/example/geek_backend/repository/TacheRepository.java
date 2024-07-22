package com.example.geek_backend.repository;

import com.example.geek_backend.domain.Tache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacheRepository extends PagingAndSortingRepository<Tache, Long>, ListCrudRepository<Tache, Long> {
    Page<Tache> findByNomContaining(String nom, Pageable pageable);
}
