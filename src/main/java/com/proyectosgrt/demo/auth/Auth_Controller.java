package com.proyectosgrt.demo.auth;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class Auth_Controller {

  @PostMapping(value = "login")
  public String login() {
      return "Login from public endpoint";
  }
}
