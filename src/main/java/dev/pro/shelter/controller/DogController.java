package dev.pro.shelter.controller;

import dev.pro.shelter.model.Cat;
import dev.pro.shelter.model.Dog;
import dev.pro.shelter.service.DogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/dog")
public class DogController {
    public DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }
    @Operation(
            summary = "Добавление собаки в базу данных",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Собака добавлена",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Dog.class)
                            )
                    )
            },
            tags = "Dogs"
    )
    @PostMapping
    public Dog createDog(@RequestBody Dog dog) {
        return dogService.createDog(dog);
    }
    @Operation(
            summary = "Поиск собаки",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Собака найдена",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Dog.class)
                            )
                    )
            },
            tags = "Dogs"
    )
    @GetMapping("/{id}")
    public Dog readDog(@PathVariable int id) {
        return dogService.readDog(id);
    }
    @Operation(
            summary = "Изменение данных собаки",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Данные собаки изменены",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Dog.class)
                            )
                    )
            },
            tags = "Dogs"
    )
    @PutMapping
    public Dog updateDog(@RequestBody Dog dog) {
        return dogService.updateDog(dog);
    }
    @Operation(
            summary = "Удаление собаки из базы данных",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Собака удалена",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Dog.class)
                            )
                    )
            },
            tags = "Dogs"
    )
    @DeleteMapping("/{id}")
    public Dog deleteDog(@PathVariable int id) {
        return dogService.deleteDog(id);
    }
}
