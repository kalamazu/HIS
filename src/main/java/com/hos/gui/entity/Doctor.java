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
    private String id = "default";            // 医生编号
    private String realname = "default";      // 真实姓名
    private String deptname = "default";      // 所在科室
    private String registlevel = "普通";   // 挂号级别
    private Double registfee = 0.0;     // 挂号费

}
