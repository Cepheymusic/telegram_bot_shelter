package dev.pro.shelter.repository;

import dev.pro.shelter.model.EnumResolution;
import dev.pro.shelter.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {

    @Query(value = "select * from reports max(report_date) group by id_users where resolution is null", nativeQuery = true)
    List<Report> dailyReport();//все столбцы сгруппированные по айди, с пустым статусом и с максимальной датой

    @Query(value = "select r.report_date from reports r where max(r.report_date) group by r.id_users = :id_users", nativeQuery = true )
    LocalDate readDailyReportMaxDataParamsNative(@Param("id_users") Long idUsers);

    @Query(value = "select r.id_users from reports r where r.resolution = :resolution", nativeQuery = true)
    List<Long> idAdoptersWithStatusParamsNative(@Param("resolution") EnumResolution resolution);
}
