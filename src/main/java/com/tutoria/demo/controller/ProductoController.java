package com.tutoria.demo.controller;

import com.tutoria.demo.documents.Product;
import com.tutoria.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product)
    {
        return productoService.addProduct(product);
    }
    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable String id)
    {
        return productoService.getById(id);
    }
}