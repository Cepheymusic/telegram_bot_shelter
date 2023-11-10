package dev.pro.shelter.controller;

import dev.pro.shelter.exception.UsersException;
import dev.pro.shelter.service.CatAdopterService;
import dev.pro.shelter.service.DogAdopterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adopters")
public class AdoptersController {
    private final CatAdopterService catAdopterService;
    private final DogAdopterService dogAdopterService;

    public AdoptersController(CatAdopterService catAdopterService, DogAdopterService dogAdopterService) {
        this.catAdopterService = catAdopterService;
        this.dogAdopterService = dogAdopterService;
    }

    @PostMapping("/{type}/")
    public void createAdopter(@PathVariable String type, @RequestParam long idUser, @RequestParam long idPet, @RequestParam String address) {
        switch (type) {
            case ("dog"):
                dogAdopterService.registrationDogAdopter(idUser, idPet, address);
                break;
            case ("cat"):
                catAdopterService.registrationCatAdopter(idUser, idPet, address);
                break;
            default:
                throw new UsersException("неправильно указан тип для питомца");
        }
    }

    @GetMapping("/{type}/{id}")
    public void readAdopter(@PathVariable String type, @PathVariable int id) {
        switch (type) {
            case ("dog"):
                dogAdopterService.readDogAdopter(id);
                break;
            case ("cat"):
                catAdopterService.readCatAdopter(id);
                break;
            default:
                throw new UsersException("неправильно указан тип для питомца");
        }
    }

    @PutMapping("/{type}/")
    public void updateAdopter(@PathVariable String type, @RequestBody long idUser) {
        switch (type) {
            case ("dog"):
                dogAdopterService.updateDogAdopter(idUser);
                break;
            case ("cat"):
                catAdopterService.updateCatAdopter(idUser);
                break;
            default:
                throw new UsersException("неправильно указан тип для питомца");
        }
    }

    @DeleteMapping("/{type}/{id}")
    public void deleteAdopter(@PathVariable String type, @PathVariable int id) {
        switch (type) {
            case ("dog"):
                dogAdopterService.deleteDogAdopter(id);
                break;
            case ("cat"):
                catAdopterService.deleteCatAdopter(id);
                break;
            default:
                throw new UsersException("неправильно указан тип для питомца");
        }
    }
}
