package dev.pro.shelter.repository;

import dev.pro.shelter.model.Report;
import dev.pro.shelter.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report,Long> {
    @Query(value = "select id, id_users, photo, diet, health, habits from reports where cast(report_date as date) = cast (current_timestamp as date)")
    List<Report> dailyReport ();
    //, nativeQuery = true
    //@Query(value = "select * from reports where cast(report_date as date) = cast (current_timestamp as date)")
}
