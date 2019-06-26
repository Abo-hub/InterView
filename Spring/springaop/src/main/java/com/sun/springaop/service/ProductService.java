package com.sun.springaop.service;

import com.sun.springaop.domain.Product;
import com.sun.springaop.securty.AdminOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {


    @Autowired
    AuthService authService;

    @AdminOnly
    public void insert(Product product){
        //authService.checkAccess();
        System.out.println("Insert product");
    }

    @AdminOnly
    public void delete(Long id){
        //authService.checkAccess();
        System.out.println("Delete product");
    }

}
