package com.Employee_Payroll_IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollFileIOService {
    public static String PAYROLL_FILE_NAME = "payroll-file.txt";

    public void writeData(List<EmployeePayrollData> employeePayRollList) {
        StringBuffer empBuffer = new StringBuffer();
        employeePayRollList.forEach(employee -> {
            String employeeDataString = employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });
        try {
            Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());//StandardCharsets.UTF_8
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printData() {
        try {
            Files.lines(new File(PAYROLL_FILE_NAME).toPath()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    public List<EmployeePayrollData> readData() {
        List<EmployeePayrollData> employeePayRollList = new ArrayList<>();
        try {
            Files.lines(new File(PAYROLL_FILE_NAME).toPath()).map(String::trim).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeePayRollList;
    }
}