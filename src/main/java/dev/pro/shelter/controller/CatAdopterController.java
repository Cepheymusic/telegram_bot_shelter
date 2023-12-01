package dev.pro.shelter.controller;

import dev.pro.shelter.exception.UsersException;
import dev.pro.shelter.model.Cat;
import dev.pro.shelter.model.CatAdopter;
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
@RequestMapping("/catAdopters")
public class CatAdopterController {
    private final CatAdopterService catAdopterService;

    public CatAdopterController(CatAdopterService catAdopterService) {
        this.catAdopterService = catAdopterService;
    }

    @Operation(
            summary = "Создание усыновителя с присваением ему кота",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Усыновитель создан",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            },
            tags = "CatAdopter"
    )
    @PostMapping
    public CatAdopter createAdopter(@Parameter(description = "id усыновителя", example = "1") @RequestParam long idUser,
                                    @Parameter(description = "id животного", example = "1") @RequestParam long idPet,
                                    @Parameter(description = "Адрес усыновителя", example = "New York, Middle Street, 245") @RequestParam String address) {
        return catAdopterService.registrationCatAdopter(idUser, idPet, address);
    }

    @Operation(
            summary = "Поиск усыновителя по id животного",
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
            tags = "CatAdopter"
    )
    @GetMapping("/{id}")
    public CatAdopter readAdopter(@Parameter(description = "id животного", example = "1") @PathVariable int id) {
        return catAdopterService.readCatAdopter(id);

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
            tags = "CatAdopter"
    )
    @PutMapping
    public CatAdopter updateAdopter(@Parameter(description = "id усыновителя", example = "1") @RequestParam long idUser,
                                    @Parameter(description = "Данные усыновителя") @RequestBody CatAdopter catAdopter) {
        return catAdopterService.updateCatAdopter(idUser, catAdopter);
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
            tags = "CatAdopter"
    )
    @DeleteMapping("/{id}")
    public CatAdopter deleteAdopter(@Parameter(description = "id усыновителя", example = "1") @PathVariable int id) {
        return catAdopterService.deleteCatAdopter(id);

    }
}
