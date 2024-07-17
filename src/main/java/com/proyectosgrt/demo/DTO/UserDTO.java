package com.proyectosgrt.demo.DTO;

public record UserDTO(
   String nodoc,
   String pnom,
   String snom,
   String pape,
   String sape,
   String celular,
   String correo,
   Integer idsede,
   Integer iddoc,
   Integer idcargo,
   String role,
   boolean estado
) {
  
}
