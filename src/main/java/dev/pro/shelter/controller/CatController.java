package dev.pro.shelter.controller;

import dev.pro.shelter.model.Cat;
import dev.pro.shelter.service.CatService;
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

    @GetMapping("/{id}")
    public Cat readCat(@PathVariable int id) {
        return catService.readCat(id);
    }

    @PutMapping
    public Cat updateCat(@RequestBody Cat cat) {
        return catService.updateCat(cat);
    }

    @DeleteMapping("/{id}")
    public Cat deleteCat(@PathVariable int id) {
        return catService.deleteCat(id);
    }
}
