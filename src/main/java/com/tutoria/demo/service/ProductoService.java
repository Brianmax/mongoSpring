package com.tutoria.demo.service;

import com.tutoria.demo.documents.Product;
import com.tutoria.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    private ProductRepo productRepo;
    public Product addProduct(Product product)
    {
        return productRepo.save(product);
    }
    public Product getById(String id)
    {
        return productRepo.findById(id).orElse(null);
    }
}
