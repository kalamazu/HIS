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
        //这里填写127.0.0.1或者localhost都是可以的
        this.database_name = "HIS";
        //小写也可以
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

    /**
     * 病人查询
     * @param patientName
     * @return patient实例
     */
    public Patient getUserByUserName(String patientName) {
        try {
            String sql = "SELECT * FROM patient WHERE realname = ?";
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

    /*public boolean patientLogin(String patientID,String patientPwd){

        try {
            //patient_login  表中通过id查询密码与用户输入进行对比，即登陆验证
            String sql = "SELECT * FROM patient_login WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, patientID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                if(patientPwd.equals(rs.getString("pwd")))
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean DoctorLogin(String doctorID,String doctorPwd){

        try {
            //patient_login  表中通过id查询密码与用户输入进行对比，即登陆验证
            String sql = "SELECT * FROM doctor_login WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, doctorPwd);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                if(doctorPwd.equals(rs.getString("pwd")))
                    return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }*/

    /**
     * 管理员登录
     * @param manID
     * @param manPwd
     * @return
     */
    public boolean Login(String manID,String manPwd){

        try {
            //med  表中通过id查询密码与用户输入进行对比，即登陆验证
            String sql = "SELECT * FROM manager WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, manID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                if(manPwd.equals(rs.getString("pwd")))
                    return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }




/*    public boolean addUser(User newUser) {
        // 输入username、password、role，插入数据库
        try {
            String sql = "INSERT INTO usertable(username,password,role) VALUES(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, newUser.getUserName());
            pstmt.setString(2, newUser.getPassword());
            pstmt.setString(3, newUser.getUserRole());

            pstmt.executeUpdate();
            System.out.println("添加用户成功！");
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delUserByUserName(String userName) {
        try {
            String sql = "DELETE FROM usertable WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.executeUpdate();
            System.out.println("删除用户成功！");
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean modifyUser(Patient newPatient) {
        try {
            String sql = "UPDATE usertable SET username = ?, password = ?, role = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, newPatient.getUserName());
            pstmt.setString(2, newPatient.get());
            pstmt.setInt(4, newPatient.getId());
            pstmt.executeUpdate();
            System.out.println("修改用户成功！");
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/



    //查询根据业务添加


}
