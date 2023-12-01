package dev.pro.shelter.controller;

import dev.pro.shelter.model.Cat;
import dev.pro.shelter.model.Report;
import dev.pro.shelter.service.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {
    public ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }
    @Operation(
            summary = "Поиск всех отчётов",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Отчёты найдены",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Report.class)
                            )
                    )
            },
            tags = "Reports"
    )
    @GetMapping
    public List<Report> readAllDailyReport(){
        return service.readAllDailyReport();
    }
    @Operation(
            summary = "Создание придупреждения для усыновителя",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Предупреждение создано",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Report.class)
                            )
                    )
            },
            tags = "Reports"
    )
    @PostMapping("/{id}")
    public void createWarning(@PathVariable Long chatId,
                              @Parameter(description = "Текст предупреждения", example = "Вы не отправили отчёт") String warn){
        service.createWarning(chatId, warn);
    }

}
