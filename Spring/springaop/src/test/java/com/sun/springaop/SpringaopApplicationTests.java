package com.sun.springaop;

import com.sun.springaop.securty.CurrentUserHodler;
import com.sun.springaop.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.Current;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringaopApplicationTests {

    @Autowired
    ProductService productService;

    @Test
    public void annoInsertTests() {
        CurrentUserHodler.set("tom");
        productService.delete(1L);
    }

    @Test
    public void adminInsert(){
        CurrentUserHodler.set("admin");
        productService.delete(1L);
    }

}
