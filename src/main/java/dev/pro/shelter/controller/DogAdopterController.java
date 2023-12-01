package dev.pro.shelter.controller;

import dev.pro.shelter.exception.UsersException;
import dev.pro.shelter.model.Cat;
import dev.pro.shelter.model.CatAdopter;
import dev.pro.shelter.model.DogAdopter;
import dev.pro.shelter.service.CatAdopterService;
import dev.pro.shelter.service.DogAdopterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dogAdopter")
public class DogAdopterController {
    private final DogAdopterService dogAdopterService;

    public DogAdopterController(DogAdopterService dogAdopterService) {
        this.dogAdopterService = dogAdopterService;
    }

    @Operation(
            summary = "Создание усыновителя с присваением ему собаки",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Усыновитель создан",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            },
            tags = "DogAdopter"
    )
    @PostMapping
    public DogAdopter createAdopter(@Parameter(description = "id усыновителя", example = "1") @RequestParam long idUser,
                                    @Parameter(description = "id животного", example = "1") @RequestParam long idPet,
                                    @Parameter(description = "Адрес усыновителя", example = "New York, Middle Street, 245") @RequestParam String address) {
        return dogAdopterService.registrationDogAdopter(idUser, idPet, address);
    }

    @Operation(
            summary = "Поиск усыновителя id животного",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Усыновитель найден",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Cat.class)
                            )
                    )
            },
            tags = "DogAdopter"
    )
    @GetMapping("/{id}")
    public DogAdopter readAdopter(@Parameter(description = "id животного", example = "1") @PathVariable int id) {
        return dogAdopterService.readDogAdopter(id);
    }

    @Operation(
            summary = "Изменение данных усыновителя",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Данные усыновителя изменены",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Cat.class)
                            )
                    )
            },
            tags = "DogAdopter"
    )
    @PutMapping
    public DogAdopter updateAdopter(@Parameter(description = "id усыновителя", example = "1") @RequestBody long idUser,
                                    @Parameter(description = "Данные усыновителя") @RequestBody DogAdopter dogAdopter) {
        return dogAdopterService.updateDogAdopter(idUser, dogAdopter);
    }

    @Operation(
            summary = "Удаление усыновителя по id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Усыновитель удалён",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Cat.class)
                            )
                    )
            },
            tags = "DogAdopter"
    )
    @DeleteMapping("/{id}")
    public DogAdopter deleteAdopter(@Parameter(description = "id усыновителя", example = "1") @PathVariable int id) {
        return dogAdopterService.deleteDogAdopter(id);
    }
}
