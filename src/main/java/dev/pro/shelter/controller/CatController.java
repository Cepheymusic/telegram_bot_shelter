package dev.pro.shelter.controller;

import dev.pro.shelter.model.Cat;
import dev.pro.shelter.service.CatService;
import dev.pro.shelter.service.DogService;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/cat")
public class CatController {
    public CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @PostMapping
    public Cat createCat(@RequestBody Cat cat) {
        return catService.createCat(cat);
    }

    @GetMapping("{id}")
    public Cat readCat(@PathVariable long id) {
        return catService.readCat(id);
    }

    @PutMapping("/{id}")
    public Cat updateCat(@PathVariable long id, @RequestBody Cat cat) {
        return catService.updateCat(id, cat);
    }

    @DeleteMapping("/{id}")
    public Cat deleteCat(@PathVariable long id) {
        return catService.deleteCat(id);
    }
}
