package com.chozoi.test.app.controller;

import com.chozoi.test.app.dtos.TastyDTO;
import com.chozoi.test.domain.service.TastyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasty")
public class TastyController {

    @Autowired
    private TastyService tastyService;

    @GetMapping(params = "name")        //http://localhost:8088/api/v1/tasty?name=kk
    @CrossOrigin(origins = "*")
    ResponseEntity<?> findByTastyByName(@RequestParam("name") String name){
        return tastyService.findByTasty(name);
    }

    @PostMapping                        //http://localhost:8088/api/v1/tasty
    @CrossOrigin(origins = "*")
    ResponseEntity<?> addTasty(@RequestBody TastyDTO tastyDTO){
        return tastyService.addTasty(tastyDTO);
    }

    @DeleteMapping(path = "/{id}")      //http://localhost:8088/api/v1/tasty/2
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> deleteTastyById(@PathVariable("id") int id){
        return tastyService.deleteTasty(id);
    }

    @PutMapping(path = "/{id}")         //http://localhost:8088/api/v1/tasty/1
    @CrossOrigin(origins = "*")
    ResponseEntity<?> updateTasty(@RequestBody TastyDTO tastyDTO,
                                 @PathVariable("id") int id){
        return tastyService.updateTasty(tastyDTO, id);
    }

    @GetMapping(params = "category_id")        //http://localhost:8088/api/v1/tasty?category_id=1
    @CrossOrigin(origins = "*")
    ResponseEntity<?> findByTastyByCategory(@RequestParam("category_id") int id){
        return tastyService.findByIdCate(id);
    }

    @GetMapping                        //http://localhost:8088/api/v1/tasty
    @CrossOrigin(origins = "*")
    ResponseEntity<?> getAllTasty(){
        return tastyService.getAllTasty();
    }
}
