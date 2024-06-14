package com.hos.gui.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: Doctor
 * @Author itmei
 * @Package com.hos.gui.entity
 * @Date 2024/6/14 19:44
 * @description: doctor_bean
 */

@Data
@NoArgsConstructor
public class Doctor {
    private String id;            // 医生编号
    private String realname;      // 真实姓名
    private String password;      // 密码
    private String deptname;      // 所在科室
    private String registlevel;   // 挂号级别
    private Double registfee;     // 挂号费

}
