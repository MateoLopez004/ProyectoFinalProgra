package com.programacionmateo.proyectonutricion.Controller;

import com.programacionmateo.proyectonutricion.DTO.DetallesRegistroDTO;
import com.programacionmateo.proyectonutricion.Service.DetallesRegistroService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/detallesregistro")
public class DetallesRegistroController {

    @Autowired
    private DetallesRegistroService detallesRegistroService;

    // Crear un nuevo Detalle de Registro
    @PostMapping
    public ResponseEntity<DetallesRegistroDTO> createDetallesRegistro(@RequestBody DetallesRegistroDTO detallesRegistroDTO) {
        DetallesRegistroDTO detalle = detallesRegistroService.addDetallesRegistro(detallesRegistroDTO);
        return new ResponseEntity<>(detalle, HttpStatus.CREATED);
    }

    // Obtener Detalle de Registro por ID
    @GetMapping("{id}")
    public ResponseEntity<DetallesRegistroDTO> getDetallesRegistroById(@PathVariable("id") Long detalleId) {
        DetallesRegistroDTO detalleDTO = detallesRegistroService.getbyidDetallesRegistro(detalleId);
        return ResponseEntity.ok(detalleDTO);
    }

    // Obtener todos los Detalles de Registro
    @GetMapping
    public ResponseEntity<List<DetallesRegistroDTO>> getAllDetallesRegistro() {
        List<DetallesRegistroDTO> detalles = detallesRegistroService.getAllDetallesRegistro();
        return ResponseEntity.ok(detalles);
    }

    // Actualizar un Detalle de Registro
    @PutMapping("{id}")
    public ResponseEntity<DetallesRegistroDTO> updateDetallesRegistro(@PathVariable("id") Long detalleId,
                                                                      @RequestBody DetallesRegistroDTO updatedDetalle) {
        DetallesRegistroDTO detalleDTO = detallesRegistroService.updateDetallesRegistro(updatedDetalle);
        return ResponseEntity.ok(detalleDTO);
    }

    // Eliminar un Detalle de Registro
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDetallesRegistro(@PathVariable("id") Long detalleId) {
        detallesRegistroService.deleteDetallesRegistro(detalleId);
        return ResponseEntity.ok("Detalle de registro eliminado correctamente.");
    }
}
