package dao;

import dbutil.DBUtil;
import org.junit.jupiter.api.Test;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LogDaoTest {
    LogDao logDao=new LogDao();
    LocalDateTime localDateTime=LocalDateTime.now();
    Map<String ,Integer>integerMap=new HashMap<>();


    @Test
    void saveLog() {
        logDao.saveLog(localDateTime,integerMap);

    }
}