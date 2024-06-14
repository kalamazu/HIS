package com.hos.gui.entity;

/**
 * @Title: patient
 * @Author itmei
 * @Package com.hos.gui.entity
 * @Date 2024/6/14 10:47
 * @description: patient_entity
 */



public class Patient {
    private Integer id;			//病例号
    private String realname;		//患者姓名
    private String gender;			//患者性别
    private String cardnumber;		//身份证号
    private String birthdate;		//出生日期
    private Integer age;			//年龄
    private String homeaddress;	//家庭住址
    private String deptname;		//挂号科室
    private String doctorname;		//挂号医生
    private String registlevel;		//挂号级别
    private String isbook;			//是否需要病历本
    private Double registfee;		//挂号费
    private String registdate;		//挂号日期
    private String diagiosis;		//诊断结果
    private String prescription;		//处方药品（分号分割）
    private Double drugprice;		//药品总价
    private int visitstate;		//看诊状态（1:已挂号，2.看诊结束，3已取药，4.已退号）

    public Patient() {

    }

    public void Patient(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getRegistlevel() {
        return registlevel;
    }

    public void setRegistlevel(String registlevel) {
        this.registlevel = registlevel;
    }

    public String getIsbook() {
        return isbook;
    }

    public void setIsbook(String isbook) {
        this.isbook = isbook;
    }

    public Double getRegistfee() {
        return registfee;
    }

    public void setRegistfee(Double registfee) {
        this.registfee = registfee;
    }

    public String getRegistdate() {
        return registdate;
    }

    public void setRegistdate(String registdate) {
        this.registdate = registdate;
    }

    public String getDiagiosis() {
        return diagiosis;
    }

    public void setDiagiosis(String diagiosis) {
        this.diagiosis = diagiosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Double getDrugprice() {
        return drugprice;
    }

    public void setDrugprice(Double drugprice) {
        this.drugprice = drugprice;
    }

    public int getVisitstate() {
        return visitstate;
    }

    public void setVisitstate(int visitstate) {
        this.visitstate = visitstate;
    }

    public Patient(Integer id, String realname, String gender, String cardnumber, String birthdate, Integer age, String homeaddress, String deptname, String doctorname, String registlevel, String isbook, Double registfee, String registdate, String diagiosis, String prescription, Double drugprice, int visitstate) {
        this.id = id;
        this.realname = realname;
        this.gender = gender;
        this.cardnumber = cardnumber;
        this.birthdate = birthdate;
        this.age = age;
        this.homeaddress = homeaddress;
        this.deptname = deptname;
        this.doctorname = doctorname;
        this.registlevel = registlevel;
        this.isbook = isbook;
        this.registfee = registfee;
        this.registdate = registdate;
        this.diagiosis = diagiosis;
        this.prescription = prescription;
        this.drugprice = drugprice;
        this.visitstate = visitstate;
    }
}
