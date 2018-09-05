package com.bitex.shomoy;

import com.bitex.shomoy.timesheet.controller.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.text.ParseException;

@SpringBootApplication
public class ShomoyApplication {

    @Autowired
    TimeSheetService timeSheetService;

    public static void main(String[] args) throws ParseException, SQLException {
        SpringApplication.run(ShomoyApplication.class, args);
    }


}
