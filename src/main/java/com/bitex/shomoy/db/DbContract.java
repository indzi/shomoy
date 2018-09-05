package com.bitex.shomoy.db;

import org.springframework.stereotype.Component;

/**
 * @author Neel Sinha (mailneelhere@gmail.com)
 * Date: 8/26/2018
 */
public interface DbContract {

    public static final String HOST = "jdbc:postgresql://localhost:5432/";

    public static final String DB_NAME = "time_sheet";

    public static final String USERNAME = "postgres";

    public static final String PASSWORD = "postgres";

}

