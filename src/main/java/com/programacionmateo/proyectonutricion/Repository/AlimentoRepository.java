package com.programacionmateo.proyectonutricion.Repository;

import com.programacionmateo.proyectonutricion.Entity.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
}
