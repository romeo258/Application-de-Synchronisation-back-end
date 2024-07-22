package com.example.geek_backend.service;

import com.example.geek_backend.domain.Tache;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TacheService {
    Tache createTache(Tache tache);
    Tache updateTache(Tache tache);
    Page<Tache> getTaches(int page, int size);
    Iterable<Tache> getTaches();
    Tache getTache(Long id);
    void deleteTache(Long id);
    Page<Tache> searchTaches(String nom, int page, int size);
    public List<Tache> syncTaches(List<Tache> taches);
}
