package com.bitex.shomoy.timesheet.repository;

import com.bitex.shomoy.timesheet.entity.TimeSheetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.text.ParseException;

/**
 * @author Neel Sinha (mailneelhere@gmail.com)
 * Date: 8/28/2018
 */
@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheetEntity, Long> {
}

