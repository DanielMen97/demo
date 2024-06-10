package com.proyectosgrt.demo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonasDTO {

  private String nodoc;
  private String pnom;
  private String snom;
  private String pape;
  private String sape;
  private String celular;
  private String correo;
  private String rol;
  private String pass;
  private Integer idsede;
  private Integer iddoc;
  private Integer idcargo;
  private boolean estado;
  private String token;
  private String refreshToken;
  private String expirationTime; 

}
