package dev.pro.shelter.controller;

import dev.pro.shelter.model.Report;
import dev.pro.shelter.service.ReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {
    public ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    @GetMapping
    public List<Report> readAllDailyReport(){
        return service.readAllDailyReport();
    }

    @PostMapping("/{id}")
    public void createWarning(@PathVariable Long id,String warn){
        service.createWarning(id, warn);
    }

}
