package dev.pro.shelter.controller;

import dev.pro.shelter.model.EnumResolution;
import dev.pro.shelter.model.Report;
import dev.pro.shelter.repository.ReportRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ReportControllerTest {
    @Autowired
    TestRestTemplate restTemplate;
    @LocalServerPort
    int port;
    @MockBean
    ReportRepository reportRepository;
    static List<Report> report = List.of(new Report(1L, "test",
            "test",
            "test",
            LocalDate.now(),
            LocalDate.now(),
            EnumResolution.PROBATION_15DAY,
            false));

    @Test
    void readAllDailyReport_returnStatus200AndListReports() {
        when(reportRepository.dailyReport()).thenReturn((List<Report>) report);
        ResponseEntity<String> reportResponseEntity = restTemplate.getForEntity(
                "http://localhost:" + port + "/report", String.class);
        assertEquals(HttpStatus.OK, reportResponseEntity.getStatusCode());
    }
}