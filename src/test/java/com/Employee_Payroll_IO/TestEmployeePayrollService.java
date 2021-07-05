package com.Employee_Payroll_IO;

import com.Employee_Payroll_IO.EmployeePayrollData;
import com.Employee_Payroll_IO.EmployeePayrollService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestEmployeePayrollService {
    @Test
    public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries() {

        EmployeePayrollData[] arrayOfEmps = {new EmployeePayrollData(1231,"Rekha",55000.00),
                                             new EmployeePayrollData(1232,"Rashmi",84000.00),
                                             new EmployeePayrollData(1233,"Ramya",15000.00)
                                            };

        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
        employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assertions.assertEquals(3,entries);
    }
}
