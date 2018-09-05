package com.bitex.shomoy.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author Neel Sinha (mailneelhere@gmail.com)
 * Date: 8/26/2018
 */
public class PostgresHelper {

    private Connection conn;
    private String host;
    private String dbName;
    private String user;
    private String pass;

    //we don't like this constructor
    protected PostgresHelper() {}

    public PostgresHelper(String host, String dbName, String user, String pass) {
        this.host = host;
        this.dbName = dbName;
        this.user = user;
        this.pass = pass;
    }

    public boolean connect() throws SQLException, ClassNotFoundException {
        if (host.isEmpty() || dbName.isEmpty() || user.isEmpty() || pass.isEmpty()) {
            throw new SQLException("Database credentials missing");
        }

        Class.forName("org.postgresql.Driver");
        this.conn = DriverManager.getConnection(
                this.host + this.dbName,
                this.user, this.pass);
        return true;
    }

    public int insert(String table, Map values) throws SQLException {

        int flag = 0;
        StringBuilder columns = new StringBuilder();
        StringBuilder vals = new StringBuilder();

        for (Object col : values.keySet()) {
            columns.append(col).append(",");

            if (values.get(col) instanceof String) {
                int size = values.size();
                StringBuilder append = vals.append("'");
                if(flag < size) {
                    append.append(values.get(col)).append("', ");
                    flag = flag + 1;
                }
                else {
                    append.append(values.get(col)).append("' ");
                }
            }
            else vals.append(values.get(col)).append(",");
        }

        columns.setLength(columns.length()-1);
        vals.setLength(vals.length()-1);

        String query = String.format("INSERT INTO %s (%s) VALUES (%s)", table,
                columns.toString(), vals.toString());
        query = query.replace(",)", ")");
        return this.conn.createStatement().executeUpdate(query);
    }

    public ResultSet execQuery(String query) throws SQLException {
        return this.conn.createStatement().executeQuery(query);
    }
}
