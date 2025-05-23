package dao;

import dbutil.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;

import static utility.ErrorWriter.saveError;

public class LogDao {
public void saveLog(LocalDateTime localDateTime, Map<String , Integer>logMap){
    String sqlQuery = "INSERT INTO logs_count (timestamp, errorcount, warningcount, infocount) VALUES (?, ?, ?, ?)";
    try(
            Connection connection = DBUtil.getConnection();
            PreparedStatement ps=connection.prepareStatement(sqlQuery);

            ) {
        ps.setObject(1,localDateTime);
        ps.setInt(2,logMap.getOrDefault("ERROR",0));
        ps.setInt(3,logMap.getOrDefault("WARNING",0));
        ps.setInt(4,logMap.getOrDefault("INFO",0));

        int rows=ps.executeUpdate();
        System.out.println("Data saved in a db "+rows);
    } catch (SQLException e) {
       // throw new RuntimeException(e);
        saveError("SQL ERROR");
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
}
}
