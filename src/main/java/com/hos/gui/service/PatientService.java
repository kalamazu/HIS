package com.hos.gui.service;

/**
 * @Title: PatientService
 * @Author itmei
 * @Package com.hos.gui.service
 * @Date 2024/6/14 21:12
 * @description: to control Patient
 */
public class PatientService {
    //单例模式
    private static PatientService PatientServiceInstance = null;
    public static PatientService getInstance() {
        if (PatientServiceInstance == null) {
            PatientServiceInstance = new PatientService();
        }
        return PatientServiceInstance;
    }




}
