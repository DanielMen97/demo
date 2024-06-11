package com.proyectosgrt.demo.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Personas implements UserDetails {

    @Id
    private String nodoc;
    private String pnom;
    private String snom;
    private String pape;
    private String sape;
    private String correo;
    private String celular;
    private String pass;
    private String rol;
    private Integer idsede;
    private Integer iddoc;
    private Integer idcargo;
    private boolean estado;
    @ManyToOne
    @JoinColumn(name = "role")
    private Roles role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {


        return List.of(new SimpleGrantedAuthority(role.getRol().name()));
    }
    @Override
    public String getPassword() {
        return pass;
    }
    @Override
    public String getUsername() {
        return correo;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return estado;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return estado;
    }

}
