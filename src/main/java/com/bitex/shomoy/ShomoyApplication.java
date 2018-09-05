package com.bitex.shomoy;

import com.bitex.shomoy.timesheet.controller.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.SQLException;
import java.text.ParseException;

@SpringBootApplication(scanBasePackages = {"com.bitex"})
public class ShomoyApplication implements CommandLineRunner {

    @Autowired
    TimeSheetService timeSheetService;

    public static void main(String[] args) throws ParseException, SQLException {
        SpringApplication.run(ShomoyApplication.class, args);
        SpringApplication.run(TimeSheetService.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

   /* @Override
    public void run(String... args) throws Exception {
        timeSheetService.inputDate();
    }*/
}
