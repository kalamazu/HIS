package com.hos.gui.service;

import com.hos.gui.utils.SQL_UTILS;

/**
 * @Title: DoctorService
 * @Author itmei
 * @Package com.hos.gui.service
 * @Date 2024/6/14 21:05
 * @description: doctor
 */
public class DoctorService {
    //单例模式
    private static DoctorService DoctorServiceInstance = null;
    public static DoctorService getInstance() {
        if (DoctorServiceInstance == null) {
            DoctorServiceInstance = new DoctorService();
        }
        return DoctorServiceInstance;
    }
}
