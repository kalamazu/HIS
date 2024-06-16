package com.hos.gui.Test;

import com.hos.gui.entity.Doctor;
import com.hos.gui.entity.Patient;
import com.hos.gui.utils.SQL_UTILS;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Test
 * @Author itmei
 * @Package com.hos.gui.Test
 * @Date 2024/6/14 13:18
 * @description: test
 */

public class test {


    //不好使
    @Test
    public void testSQLconnection(){
        Patient patient = SQL_UTILS.getInstance().getPatientByName("李四");
        System.out.println(patient);

    }

    @Test
    public void testSQLreturn(){
        //Test Clayton
        List<Doctor> doctors = SQL_UTILS.getInstance().getDoctorsByDep("儿科","普通号");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    public static void main(String[] args) {
        String name = "张三";
//        Patient patient = SQL_UTILS.getInstance().getPatientByName(name);
/*        Patient patient1 = new Patient();
        patient1.setId(43);
        patient1.setAge(12);
        SQL_UTILS.getInstance().createPatient(patient1);*/
//        SQL_UTILS.getInstance().deletePatientById(6);

//        System.out.println(patient);
        //Test git
        //Test GitHub
/*        Doctor doctor  = SQL_UTILS.getInstance().getDoctorById("1");
        System.out.println(doctor);*/
/*        Doctor doctor = new Doctor();
        doctor.setId("1");
        SQL_UTILS.getInstance().updateDoctor(doctor);*/
        List<Doctor> doctors = SQL_UTILS.getInstance().getDoctorsByDep("儿科","副主任医师");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

}
