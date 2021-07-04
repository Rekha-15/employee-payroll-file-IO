/***************************************************************
 *@purpose Implementing Employee Payroll Service Problem .
 *@author Rekha
 *@version 1.0
 *@since 3-07-2021
 **************************************************************/

package com.Employee_Payroll_IO;

/**
 * EmployeePayrollData is a class of public type Contains employee Id,employee
 * name and employee salary
 * 
 * @author rekha
 *
 */
public class EmployeePayRollData {
	/**
	 * Instance variable id, name salary
	 */
    int id;
    String name;
    Double salary;
    
    /**Constructor for EmployeePayrollData.
     *@param id;
     *@param name;
     * @param salary
      */

    public EmployeePayRollData(int id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public String toString() {
    	return " name=+'" +name + '\'' + "id=" + id +  ",salary=" + salary;
    	}
}
