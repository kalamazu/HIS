package com.hos.gui.utils;

import com.hos.gui.entity.Doctor;
import com.hos.gui.entity.Manager;
import com.hos.gui.entity.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /**
     * 数据库配置信息
     */
    private SQL_UTILS() {
        //根据实际情况填写
        this.user = "root";
        this.password = "chenyinan";
        this.database_url = "localhost";
        //完整url
        //jdbc:mysql://localhost:3306/his?useSSL=false&serverTimezone=Asia/Shanghai
        this.database_name = "his";
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
     * 添加病人/挂号
     * @param patient
     */
    public void createPatient(Patient patient) {
        try {
            String sql = "INSERT INTO patient (realname, gender, cardnumber, birthdate, age, homeaddress, " +
                    "deptname, doctorname, registlevel, isbook, registfee, registdate, " +
                    "diagiosis, prescription, drugprice, visitstate,id ) VALUES " +
                    "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, patient.getRealname());
            pstmt.setString(2, patient.getGender());
            pstmt.setString(3, patient.getCardnumber());
            pstmt.setString(4, patient.getBirthdate());
            pstmt.setInt(5, patient.getAge());
            pstmt.setString(6, patient.getHomeaddress());
            pstmt.setString(7, patient.getDeptname());
            pstmt.setString(8, patient.getDoctorname());
            pstmt.setString(9, patient.getRegistlevel());
            pstmt.setBoolean(10, patient.getIsbook());
            pstmt.setDouble(11, patient.getRegistfee());
            pstmt.setString(12, patient.getRegistdate());
            pstmt.setString(13, patient.getDiagiosis());
            pstmt.setString(14, patient.getPrescription());
            pstmt.setDouble(15, patient.getDrugprice());
            pstmt.setInt(16, patient.getVisitstate());
            pstmt.setInt(17, patient.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    /**
     * 病人查询
     * @param patientName
     * @return patient实例
     */
    public Patient getPatientByName(String patientName) {
        try {
            String sql = "SELECT * FROM patient WHERE realname = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, patientName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setRealname(rs.getString("realname"));
                patient.setGender(rs.getString("gender"));
                patient.setCardnumber(rs.getString("cardnumber"));
                patient.setBirthdate(rs.getString("birthdate"));
                patient.setAge(rs.getInt("age"));
                patient.setHomeaddress(rs.getString("homeaddress"));
                patient.setDeptname(rs.getString("deptname"));
                patient.setDoctorname(rs.getString("doctorname"));
                patient.setRegistlevel(rs.getString("registlevel"));
                patient.setIsbook(rs.getBoolean("isbook"));
                patient.setRegistfee(rs.getDouble("registfee"));
                patient.setRegistdate(rs.getString("registdate"));
                patient.setDiagiosis(rs.getString("diagiosis"));
                patient.setPrescription(rs.getString("prescription"));
                patient.setDrugprice(rs.getDouble("drugprice"));
                patient.setVisitstate(rs.getInt("visitstate"));

                return patient;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * id查询
     * @param id
     * @return
     */
    public Patient getPatientById(String id) {
        try {
            String sql = "SELECT * FROM patient WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setRealname(rs.getString("realname"));
                patient.setGender(rs.getString("gender"));
                patient.setCardnumber(rs.getString("cardnumber"));
                patient.setBirthdate(rs.getString("birthdate"));
                patient.setAge(rs.getInt("age"));
                patient.setHomeaddress(rs.getString("homeaddress"));
                patient.setDeptname(rs.getString("deptname"));
                patient.setDoctorname(rs.getString("doctorname"));
                patient.setRegistlevel(rs.getString("registlevel"));
                patient.setIsbook(rs.getBoolean("isbook"));
                patient.setRegistfee(rs.getDouble("registfee"));
                patient.setRegistdate(rs.getString("registdate"));
                patient.setDiagiosis(rs.getString("diagiosis"));
                patient.setPrescription(rs.getString("prescription"));
                patient.setDrugprice(rs.getDouble("drugprice"));
                patient.setVisitstate(rs.getInt("visitstate"));

                return patient;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }






    /**
     * 修改/更新病人信息
     * @param patient
     */
    public void updatePatient(Patient patient) {
        try {
            String sql = "UPDATE patient SET realname = ?, gender = ?, cardnumber = ?, birthdate = ?, age = ?, homeaddress = ?, deptname = ?, doctorname = ?, registlevel = ?, isbook = ?, registfee = ?, registdate = ?, diagiosis = ?, prescription = ?, drugprice = ?, visitstate = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, patient.getRealname());
            pstmt.setString(2, patient.getGender());
            pstmt.setString(3, patient.getCardnumber());
            pstmt.setString(4, patient.getBirthdate());
            pstmt.setInt(5, patient.getAge());
            pstmt.setString(6, patient.getHomeaddress());
            pstmt.setString(7, patient.getDeptname());
            pstmt.setString(8, patient.getDoctorname());
            pstmt.setString(9, patient.getRegistlevel());
            pstmt.setBoolean(10, patient.getIsbook());
            pstmt.setDouble(11, patient.getRegistfee());
            pstmt.setString(12, patient.getRegistdate());
            pstmt.setString(13, patient.getDiagiosis());
            pstmt.setString(14, patient.getPrescription());
            pstmt.setDouble(15, patient.getDrugprice());
            pstmt.setInt(16, patient.getVisitstate());
            pstmt.setInt(17, patient.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除病人
     * 备用方法
     * @param id
     */
    public void deletePatientById(int id) {
        try {
            String sql = "DELETE FROM patient WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 更新医生信息
     * @param doctor
     */
    public void updateDoctor(Doctor doctor) {
        try {
            String sql = "UPDATE doctor SET realname = ?, deptname = ?, registlevel = ?, registfee = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, doctor.getRealname());
            pstmt.setString(2, doctor.getDeptname());
            pstmt.setString(3, doctor.getRegistlevel());
            pstmt.setDouble(4, doctor.getRegistfee());
            pstmt.setString(5, doctor.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查找医生
     * @param id
     * @return
     */
    public Doctor getDoctorById(String id) {
        try {
            String sql = "SELECT * FROM doctor WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(rs.getString("id"));
                doctor.setRealname(rs.getString("realname"));
                doctor.setDeptname(rs.getString("deptname"));
                doctor.setRegistlevel(rs.getString("registlevel"));
                doctor.setRegistfee(rs.getDouble("registfee"));
                return doctor;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 按照科室查询，返回一个集合
     * @param dep
     * @return
     */
    public List<Doctor> getDoctorsByDep(String dep,String level) {
        List<Doctor> doctors = new ArrayList<>();
        try {
            String sql = "SELECT * FROM doctor WHERE deptname = ? AND registlevel  = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dep);
            pstmt.setString(2, level);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(rs.getString("id"));
                doctor.setRealname(rs.getString("realname"));
                doctor.setDeptname(rs.getString("deptname"));
                doctor.setRegistlevel(rs.getString("registlevel"));
                doctor.setRegistfee(rs.getDouble("registfee"));
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return doctors;
    }


    public Doctor getDoctorByName(String name) {
        try {
            String sql = "SELECT * FROM doctor WHERE realname = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(rs.getString("id"));
                doctor.setRealname(rs.getString("realname"));
                doctor.setDeptname(rs.getString("deptname"));
                doctor.setRegistlevel(rs.getString("registlevel"));
                doctor.setRegistfee(rs.getDouble("registfee"));
                return doctor;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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

    public boolean isExistManager(String managerid){

        try {
            //med  表中通过id查询密码与用户输入进行对比，即登陆验证
            String sql = "SELECT * FROM manager WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, managerid);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                if(managerid.equals(rs.getString("id")))
                    return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


    /**
     * 验证用户名合理性
     * @param username
     * @return
     */
    public boolean isValidUsername(String username) {
        // 用户名只能包含字母、数字和下划线
        String usernameRegex = "^[a-zA-Z0-9_]+$";
        Pattern pattern = Pattern.compile(usernameRegex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    /**
     * 验证密码合理性
     * @param password
     * @return
     */
    public boolean isValidPassword(String password) {
        //可以包含字母、数字和特殊字符
        String passwordRegex = "^[a-zA-Z0-9!@#$%^&*()_+=\\\\-{}\\\\[\\\\]:;\\\"'<>,.?/]+$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }


    /**
     * 即用户注册
     * @param manager
     */
    public void createManager(Manager manager) {
        try {
            String sql = "INSERT INTO manager (id, pwd) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, manager.getId());
            pstmt.setString(2, manager.getPwd());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 修改账户密码
     * @param manager
     */
    public void updateManager(Manager manager) {
        try {
            String sql = "UPDATE manager SET pwd = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, manager.getPwd());
            pstmt.setString(2, manager.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除管理员
     * 备用方法
     * @param id
     */
    public void deleteManagerById(String id) {
        try {
            String sql = "DELETE FROM manager WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
