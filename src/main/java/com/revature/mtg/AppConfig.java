package com.revature.mtg;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class AppConfig {
    private DbDataSource dbDataSource;

    public AppConfig(DbDataSource dbDataSource) {
        this.dbDataSource = dbDataSource;
    }

    public DataSource AppConfig() {
        String url ="jdbc:postgresql://p1-db:5432/postgres";
        String username = "postgres";
        String password = "postgres";
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }
}
