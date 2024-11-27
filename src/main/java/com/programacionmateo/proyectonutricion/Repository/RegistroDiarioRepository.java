package com.programacionmateo.proyectonutricion.Repository;

import com.programacionmateo.proyectonutricion.Entity.RegistroDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistroDiarioRepository extends JpaRepository<RegistroDiario, Long> {
    Optional<RegistroDiario> findById(Long id);
}
