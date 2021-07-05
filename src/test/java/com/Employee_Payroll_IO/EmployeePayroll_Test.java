package com.Employee_Payroll_IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeePayroll_Test {
    private static final String HOME = System.getProperty("Path","C:\\Users\\rekha\\Developer\\Employee_Payroll_IO");
    private static final String PLAY_WITH_NIO = "TempPlayGround";


    @Test
    public void GivenPathWhen_CheckedThenConfirm() throws  IOException{
        Path homePath = Paths.get(HOME);
        Assertions.assertTrue(Files.exists(homePath));

        Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        if (Files.exists(playPath)) FileUtils.deleteFiles(playPath.toFile());
        Assertions.assertTrue(Files.notExists(playPath));

        Files.createDirectory(playPath);
        Assertions.assertTrue(Files.exists(playPath));

        IntStream.range(1, 10).forEach(cntr -> {
            Path tempFile = Paths.get(playPath + "/temp" + cntr);
            Assertions.assertTrue(Files.notExists(tempFile));
            try {
                Files.createFile(tempFile);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            Assertions.assertTrue(Files.exists(tempFile));
        });

        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp"))
                .forEach(System.out::println);
    }

    @Test
    void GivenDirectoryWhenWatched_ListsAllTheActivites() throws IOException {
        Path dir = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
        new WatchService(dir).processEvents();
    }
}