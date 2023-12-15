package com.tutoria.demo.documents;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Document
@Getter
@Setter
public class Usuario {
    @Id
    private String _id;
    private String usernaame;
    private String gender;
    private Address address;
    @DBRef
    private Product product;
}
