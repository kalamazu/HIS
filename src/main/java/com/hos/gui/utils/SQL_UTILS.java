package com.hos.gui.utils;

import com.hos.gui.entity.Patient;

import java.sql.*;

/**
 * @Title: SQL_UTILS
 * @Author itmei
 * @Package com.hos.gui.utils
 * @Date 2024/6/14 10:53
 * @description: creat connection
 */
public class SQL_UTILS {
    public boolean isConnected = false; // 数据库连接状态
    Connection conn = null; // 数据库连接
    private String user;
    private String password;
    private String database_name;
    private String database_url;
    private static SQL_UTILS instance; // 单例模式

    public Patient currentUser;

    private SQL_UTILS() {
        this.user = "root";
        this.password = "chenyinan";
        this.database_url = "localhost";jdbc:mysql://localhost:3306/his?useSSL=false&serverTimezone=Asia/Shanghai
        //127.0.0.1
        this.database_name = "HIS";
    }

    // 单例
    public static SQL_UTILS getInstance() {
        if (instance == null) {
            instance = new SQL_UTILS();
            instance.connectToDatabase();
        }
        return instance;
    }

    private void connectToDatabase() {
        System.out.println("连接数据库...");
        try {
            System.out.println("Drive");
            Class.forName("com.mysql.cj.jdbc.Driver"); // 加载JDBC驱动程序
            System.out.println("成功加载MySQL JDBC驱动！");
            conn = DriverManager.getConnection("jdbc:mysql://"
                    + database_url + ":3306/"
                    + database_name +
                    "?useUnicode=true&characterEncoding=UTF-8", user, password);
            System.out.println("成功连接到数据库！");
            isConnected = true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("加载MySQL JDBC驱动失败！");
            System.out.println("连接数据库失败！");
            System.out.println(e.getMessage());
        }
    }
    //getConnection
    public Connection getConnection() { // 获取数据库连接
        return conn;
    }

    public void closeConnection() { // 关闭数据库连接
        System.out.println("正在关闭连接...");
        try {
            if (conn != null) {
                conn.close();
                System.out.println("关闭连接成功！");
            }
        } catch (SQLException e) {
            System.out.println("关闭连接失败！");
            System.out.println(e.getMessage());
        }
    }

    public Patient getUserByUserName(String patientName) {
        try {
            String sql = "SELECT * FROM patient_table WHERE realname = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, patientName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Patient patient = new Patient();

                patient.setId(Integer.parseInt(rs.getString("id")));
                patient.setRealname(rs.getString("realname"));
                patient.setGender(rs.getString("gender"));
                patient.setAge(rs.getInt("age"));
                patient.setHomeaddress(rs.getString("homeaddress"));
                patient.setCardnumber(rs.getString("cardnumber"));
                patient.setDeptname(rs.getString("deptname"));
                patient.setDoctorname(rs.getString("doctorname"));
                patient.setCardnumber(rs.getString("registlevel"));
                patient.setCardnumber(rs.getString("registdate"));
                return patient;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //查询根据业务添加


}
