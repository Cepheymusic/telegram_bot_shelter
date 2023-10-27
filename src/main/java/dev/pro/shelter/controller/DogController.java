package dev.pro.shelter.controller;

import dev.pro.shelter.model.Dog;
import dev.pro.shelter.service.DogService;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/dog")
public class DogController {
    public DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @PostMapping
    public Dog createDog(@RequestBody Dog dog) {
        return dogService.createDog(dog);
    }

    @GetMapping("{id}")
    public Dog readDog(@PathVariable long id) {
        return dogService.readDog(id);
    }

    @PutMapping("/{id}")
    public Dog updateDog(@PathVariable long id, @RequestBody Dog dog) {
        return dogService.updateDog(id, dog);
    }

    @DeleteMapping("/{id}")
    public Dog deleteDog(@PathVariable long id) {
        return dogService.deleteDog(id);
    }
}
