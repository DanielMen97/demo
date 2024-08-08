package com.proyectosgrt.demo.DTO;

public record ReporteSolicitudDTO(
    Long solicitud,
    String fechaCreacion,
    String categoria,
    String estado,
    String prioridad,
    String idCliente,
    String nombreCliente,
    String idTecnico,
    String nombreTecnico,
    String observacion,
    String diagnostico,
    String fechaCierre
) {
}
