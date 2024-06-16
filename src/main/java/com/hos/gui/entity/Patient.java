package com.hos.gui.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: patient
 * @Author itmei
 * @Package com.hos.gui.entity
 * @Date 2024/6/14 10:47
 * @description: patient_entity
 */


@Data
@NoArgsConstructor
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
}
