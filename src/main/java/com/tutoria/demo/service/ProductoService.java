package com.tutoria.demo.service;

import com.tutoria.demo.documents.Product;
import com.tutoria.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    private ProductRepo productRepo;
    public Product addProduct(Product product)
    {
        System.out.println("hello from origin");
        return productRepo.save(product);
    }
    public Product getById(String id)
    {
        return productRepo.findById(id).orElse(null);
    }
    public Page<Product> getAllProducts(Pageable pageable)
    {
        return productRepo.findAll(pageable);
    }
}
