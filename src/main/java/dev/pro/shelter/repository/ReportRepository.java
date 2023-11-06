package dev.pro.shelter.repository;

import dev.pro.shelter.model.EnumResolution;
import dev.pro.shelter.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {

    @Query(value = "select * from reports max(report_date) group by id_users where resolution is null")
    List<Report> dailyReport();//все столбцы сгруппированные по айди, с пустым статусом и с максимальной датой

    @Query(value = "select r report_data from table reports r where max(r report_date) group by r.id_users = :id_users" )
    LocalDate readDailyReportMaxDataParamsNative(@Param("id_users") Long idUsers);

    @Query(value = "select r id_users from table reports r where r.resolution = :resolution")
    List<Long> idAdoptersWithStatusParamsNative(@Param("resolution") EnumResolution resolution);

//    @Query(value = "select")
//    void isSent();
}
//    @Query(value = "select * from reports where (cast(max(report_date as date)) - cast (current_timestamp as date))=1")
//    List<Report> missed1Day();
//    @Query(value = "select * from reports where (cast(report_date as date) = cast (current_timestamp as date))>2")
//    List<Report> missedMoreThan2Days();
//    @Query(value = "select id, id_users, photo, diet, health, habits from reports where cast(report_date as date) = cast (current_timestamp as date)")
//    , nativeQuery = true