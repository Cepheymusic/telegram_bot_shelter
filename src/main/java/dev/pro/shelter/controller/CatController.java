package dev.pro.shelter.controller;

import dev.pro.shelter.model.Cat;
import dev.pro.shelter.service.CatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.hibernate.annotations.Type;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cat")
public class CatController {
    public CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @Operation(
            summary = "Добавление кота в базу данных",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Кот добавлен",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Cat.class)
                            )
                    )
            },
            tags = "Cats"
    )
    @PostMapping
    public Cat createCat(@RequestBody Cat cat) {
        return catService.createCat(cat);
    }

    @Operation(
            summary = "Поиск кота по id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Кот по id найден",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Cat.class)
                            )
                    )
            },
            tags = "Cats"
    )
    @GetMapping("/{id}")

    public Cat readCat(@Parameter(description = "id кота", example = "1") @PathVariable int id) {
        return catService.readCat(id);
    }
    @Operation(
            summary = "Изменение данных кота",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Данные кота изменены",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Cat.class)
                            )
                    )
            },
            tags = "Cats"
    )
    @PutMapping
    public Cat updateCat(@RequestBody Cat cat) {
        return catService.updateCat(cat);
    }
    @Operation(
            summary = "Удаление кота из базы данных",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Кот удалён",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Cat.class)
                            )
                    )
            },
            tags = "Cats"
    )
    @DeleteMapping("/{id}")
    public Cat deleteCat(@Parameter(description = "id кота", example = "1") @PathVariable int id) {
        return catService.deleteCat(id);
    }
}
