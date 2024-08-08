package com.proyectosgrt.demo.DTO;

public record EstPersonaDTO(
    String tipoDoc,
    String nodoc,
    String nombreCompleto,
    String correo,
    String celular,
    String sede,
    String cargo,
    String role,
    Boolean estado
) {

}
