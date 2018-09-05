package com.bitex.shomoy.timesheet.controller;

import com.bitex.shomoy.db.DbContract;
import com.bitex.shomoy.db.PostgresHelper;
import com.bitex.shomoy.timesheet.entity.TimeSheetEntity;
import com.bitex.shomoy.timesheet.enums.ReasonType;
import com.bitex.shomoy.timesheet.repository.TimeSheetRepository;
import com.bitex.shomoy.timesheet.service.TimesheetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Neel Sinha (mailneelhere@gmail.com)
 * Date: 8/26/2018
 */
@Component
public class TimeSheetService {

    @Autowired
    TimeSheetRepository timeSheetRepository;

    public Map vals = new HashMap();

    public void inputDate() throws ParseException, SQLException {
        TimeSheetEntity timeSheetEntity = new TimeSheetEntity();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Please enter the date: ");
        String inputDate = reader.next();
        String date = formatter.format((TemporalAccessor) new Date());
        timeSheetEntity.setDate(date);
        vals.put("date", inputDate);

        System.out.println("Please enter the start time: ");
        String inputStartTime = reader.next();
        vals.put("starttime", inputStartTime);
        timeSheetEntity.setStartTime(inputStartTime);

        System.out.println("Please enter the end time: ");
        String inputEndTime = reader.next();
        vals.put("endtime", inputEndTime);
        timeSheetEntity.setEndTime(inputEndTime);

        reader.nextLine();
        System.out.println("Please enter the reason: ");
        String reason = reader.nextLine();
        vals.put("reason", reason);
        timeSheetEntity.setReason(reason);

        System.out.println("Please enter the reason type: ");
        Enum inputReasonTypeEnum;
        String inputReasonType = reader.next();
        vals.put("reasonType", inputReasonType);
        if(inputReasonType == "WORK"){
            inputReasonTypeEnum = ReasonType.WORK;
        } else {
            inputReasonTypeEnum = ReasonType.FREE;
        }
        timeSheetEntity.setReasonType(inputReasonTypeEnum);

        timeSheetRepository.save(timeSheetEntity);
        //once finished
        reader.close();
        System.out.println(vals);
    }




/*
        public PostgresHelper ConnectToDb() {
            PostgresHelper client = new PostgresHelper(
                    DbContract.HOST,
                    DbContract.DB_NAME,
                    DbContract.USERNAME,
                    DbContract.PASSWORD);

            try {
                if (client.connect()) {
                    System.out.println("DB connected");
                }

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

            return client;
    }*/
}
