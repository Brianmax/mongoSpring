package com.tutoria.demo.service;

import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import com.tutoria.demo.documents.Product;
import com.tutoria.demo.documents.Usuario;
import com.tutoria.demo.repository.ProductRepo;
import com.tutoria.demo.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private ProductRepo productRepo;
    public Usuario addUser(Usuario usuario)
    {
        return usuarioRepo.save(usuario);
    }
    public Usuario findById(String id){
        return usuarioRepo.findById(id).orElse(null);
    }
    // metodo para agregar un producto
    public Usuario addProduct2User(String idUser, String idProduct)
    {
        Usuario usuarioDb = usuarioRepo.findById(idUser).orElse(null);
        Product product = productRepo.findById(idProduct).orElse(null);
        usuarioDb.setProduct(product);
        return usuarioRepo.save(usuarioDb);
    }
    public Page<Usuario> findAll(Pageable pageable)
    {
	    return usuarioService.findAll(pageable);
    }
}
