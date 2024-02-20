package com.tutoria.demo.controller;

import com.tutoria.demo.documents.Usuario;
import com.tutoria.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @PostMapping("/addUser")
    public Usuario addUser(@RequestBody Usuario usuario)
    {
        return usuarioService.addUser(usuario);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/product")
    public Usuario addProduct2User(@RequestBody Map<String, String> ids)
    {
        System.out.println("A change was made here");
        String iduser = ids.get("idUserr");
        String idProduct = ids.get("idProductt");
        return usuarioService.addProduct2User(iduser, idProduct);
    }
}
