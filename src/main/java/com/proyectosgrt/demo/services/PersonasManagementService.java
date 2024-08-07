package com.proyectosgrt.demo.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyectosgrt.demo.DTO.EstPersonaDTO;
import com.proyectosgrt.demo.DTO.ListPersonasDTO;
import com.proyectosgrt.demo.DTO.ListaTecnicosDTO;
import com.proyectosgrt.demo.DTO.PersonasDTO;
import com.proyectosgrt.demo.DTO.TablaPersonasDTO;
import com.proyectosgrt.demo.DTO.UserDTO;
import com.proyectosgrt.demo.models.Personas;
import com.proyectosgrt.demo.repository.Repository_Personas;

@Service
public class PersonasManagementService {

  @Autowired
  private Repository_Personas repository_Personas;

  @Autowired
  private JWTUtils jwtUtils;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public Personas createUser(PersonasDTO dto) {
    Personas personas = new Personas();
    personas.setNodoc(dto.getNodoc());
    personas.setPnom(dto.getPnom());
    personas.setSnom(dto.getSnom());
    personas.setPape(dto.getPape());
    personas.setSape(dto.getSape());
    personas.setCelular(dto.getCelular());
    personas.setCorreo(dto.getCorreo());
    personas.setPass(passwordEncoder.encode(dto.getPass()));
    personas.setIdsede(dto.getIdsede());
    personas.setIddoc(dto.getIddoc());
    personas.setRole(dto.getRole());
    personas.setIdcargo(dto.getIdcargo());
    personas.setEstado(dto.isEstado());

    return repository_Personas.save(personas);
  }

  public PersonasDTO login(PersonasDTO log) {
    PersonasDTO personas = new PersonasDTO();
    authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(log.getCorreo(), log.getPass()));

    var user = repository_Personas.findByCorreo(log.getCorreo()).orElseThrow();
    var jwt = jwtUtils.generateToken(user);
    var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
    personas.setToken(jwt);
    personas.setRefreshToken(refreshToken);
    personas.setExpirationTime("24Hrs");
    personas.setRole(user.getRole());
    personas.setNodoc(user.getNodoc());

    return personas;
  }

  public List<TablaPersonasDTO> getListTablaPersonas() {
    List<TablaPersonasDTO> listaTablaPersonas = repository_Personas.getListTablePersonas();
    return listaTablaPersonas;
  }

  public List<ListaTecnicosDTO> getListTecnicosDTO() {
    List<ListaTecnicosDTO> listaTecnicos = repository_Personas.getListTecnicos();
    return listaTecnicos;
  }

  public List<ListPersonasDTO> getListaPersonas() {
    List<ListPersonasDTO> listaPersonas = repository_Personas.getAllPersonas();
    return listaPersonas;
  }

  // public Optional<Personas> getUserById(String nodoc){
  // Optional<Personas> persona = repository_Personas.findById(nodoc);
  // return persona;
  // }

  public UserDTO getUserByNodoc(String nodoc) {
    UserDTO persona = repository_Personas.getUserDTO(nodoc);
    return persona;
  }

  public TablaPersonasDTO getUserByNodocSer(String nodoc) {
    TablaPersonasDTO persona = repository_Personas.getUserByNodocRep(nodoc);
    return persona;
  }

  public Personas updateUser(String nodoc, Personas user) {
    Personas persona = repository_Personas.findById(nodoc).get();
    persona.setCelular(user.getCelular());
    persona.setEstado(user.isEstado());
    persona.setIdcargo(user.getIdcargo());
    persona.setIddoc(user.getIddoc());
    persona.setIdsede(user.getIdsede());
    persona.setPnom(user.getPnom());
    persona.setSnom(user.getSnom());
    persona.setSape(user.getSape());
    persona.setPape(user.getPape());

    if (user.getPass() != null && !user.getPass().isEmpty()) {
      persona.setPass(passwordEncoder.encode(user.getPass()));
    }

    return repository_Personas.save(persona);
  }

  public List<EstPersonaDTO> getEstPersonas() {
      return repository_Personas.getEstPersonasDTO();
  }
}