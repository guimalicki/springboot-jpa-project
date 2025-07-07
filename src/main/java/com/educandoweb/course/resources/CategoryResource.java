package com.educandoweb.course.resources;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.CategoryService;
import com.educandoweb.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Recurso web implementado por um controlador Rest
@RequestMapping(value = "/categories") //Indica o nome do recurso
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") //Indica que será passado um id na url
    public ResponseEntity<Category> findById(@PathVariable Long id) { //@PathVariable indica o valor que virá na url
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
