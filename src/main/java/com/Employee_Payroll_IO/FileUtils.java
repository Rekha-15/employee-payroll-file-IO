/***************************************************************
 *@purpose Implementing Employee Payroll Service Problem .
 *@author Rekha
 *@version 1.0
 *@since 3-07-2021
 **************************************************************/
package com.Employee_Payroll_IO;

import java.io.File;

public class FileUtils {
    public static boolean deleteFiles(File contentsToDelete) {
        File[] allContents = contentsToDelete.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteFiles(file);
            }
        }
        return contentsToDelete.delete();
    }
}