package com.hos.gui.utils;

import com.hos.gui.entity.Doctor;
import com.hos.gui.entity.Manager;
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
     * 添加病人
     */
    public void createPatient(Patient patient) {
        try {
            String sql = "INSERT INTO patient (realname, gender, cardnumber, birthdate, age, homeaddress, deptname, doctorname, registlevel, isbook, registfee, registdate, diagiosis, prescription, drugprice, visitstate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            pstmt.setString(10, patient.getIsbook());
            pstmt.setDouble(11, patient.getRegistfee());
            pstmt.setString(12, patient.getRegistdate());
            pstmt.setString(13, patient.getDiagiosis());
            pstmt.setString(14, patient.getPrescription());
            pstmt.setDouble(15, patient.getDrugprice());
            pstmt.setInt(16, patient.getVisitstate());
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
    public Patient getUserByUserName(String patientName) {
        try {
            String sql = "SELECT * FROM patient WHERE realname = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, patientName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Patient patient = new Patient();

/*                patient.setId(Integer.parseInt(rs.getString("id")));
                patient.setRealname(rs.getString("realname"));
                patient.setGender(rs.getString("gender"));
                patient.setAge(rs.getInt("age"));
                patient.setHomeaddress(rs.getString("homeaddress"));
                patient.setCardnumber(rs.getString("cardnumber"));
                patient.setDeptname(rs.getString("deptname"));
                patient.setDoctorname(rs.getString("doctorname"));
                patient.setCardnumber(rs.getString("registlevel"));
                patient.setCardnumber(rs.getString("registdate"));*/



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
                patient.setIsbook(rs.getString("isbook"));
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
     * 改
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
            pstmt.setString(10, patient.getIsbook());
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
     * 删
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
            String sql = "UPDATE doctor SET realname = ?, password = ?, deptname = ?, registlevel = ?, registfee = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, doctor.getRealname());
            pstmt.setString(2, doctor.getPassword());
            pstmt.setString(3, doctor.getDeptname());
            pstmt.setString(4, doctor.getRegistlevel());
            pstmt.setDouble(5, doctor.getRegistfee());
            pstmt.setString(6, doctor.getId());
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
                doctor.setPassword(rs.getString("password"));
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

 */

}
