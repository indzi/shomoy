package com.bitex.shomoy.export;

import com.bitex.shomoy.db.DbContract;
import com.bitex.shomoy.db.PostgresHelper;
import javafx.scene.control.Cell;

import java.io.FileOutputStream;
import java.io.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.*;

/**
 * @author Neel Sinha (mailneelhere@gmail.com)
 * Date: 8/26/2018
 */
public class ExportToExcel {

    @Autowired
    DbContract dbContract;

    @Autowired
    PostgresHelper postgresHelper;

    static String [] array = new String[50];
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        readPostgres();
        writeExcelData();
    }
    public static void writeExcelData(){
        //create blank workbook
        /*HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet spreadsheet = workbook.createSheet("Sheet1");
        try{
            HSSFRow row = spreadsheet.createRow(0);
            org.apache.poi.ss.usermodel.Cell cell = row.createCell(0);
            String result = array[0] + " " + array[1] + " " + array[2];
            cell.setCellValue(result);
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Neel\\Desktop\\CreateWorkbook.xls"));
            workbook.write(out);
            out.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        System.out.println("createworkbook.xls created!");*/
    }
    public static void readPostgres() throws SQLException, ClassNotFoundException {
        PostgresHelper postgresHelper = ConnectToDb();
        postgresHelper.connect();
        ResultSet rs = postgresHelper.execQuery("select date, starttime, endtime, reason from timetable");
            while(rs.next()){
                String date = rs.getString("date");
                String startTime = rs.getString("starttime");
                String endTime = rs.getString("endtime");
                String reason = rs.getString("reason");
                array[0] = date;
                array[1] = startTime;
                array[2] = endTime;
                array[3] = reason;
            }
    }
    public static PostgresHelper ConnectToDb() {
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
    }
}
