package com.tutoria.demo.controller;

import com.tutoria.demo.documents.Product;
import com.tutoria.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product)
    {
        System.out.println("Creating user from main branch");
        return productoService.addProduct(product);
    }
    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable String id)
    {
        System.out.println("Getting a product in Jwt");
        return productoService.getById(id);
    }
    @PreAuthorize("hasRole('PROFESSOR')")
    @GetMapping("/bye")
    public String sayGoodBye()
    {
        System.out.println("Saying good bye from main branch");
        System.out.println("Another change was made here");
        return "Good bye";
    }
    @GetMapping("/findAll")
    public Page<Product> getAllProducts(Pageable pageable)
    {
        return productoService.getAllProducts(pageable);
    }
    @GetMapping("/hello")
    public String helloCollaborator()
    {
	    return "Hello from colaborator";
    }
}
