package com.programacionmateo.proyectonutricion.Repository;

import com.programacionmateo.proyectonutricion.Entity.DetallesRegistro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesRegistroRepository extends JpaRepository<DetallesRegistro, Long> {
}
