package com.spring.webmvc;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class DBConnectTest {

    private String userId = "hr";
    private String userPw = "hr";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    // oracle jdbc url
    private String driver = "oracle.jdbc.driver.OracleDriver";

    @Test
    void connectTest() {

        try {
            Class.forName(driver); // 드라이버 불러오기

            Connection conn = DriverManager.getConnection(url, userId, userPw);

            String sql = "SELECT first_name FROM employees";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("first_name"));
            }

        } catch (Exception e) {

        }
    }
}
