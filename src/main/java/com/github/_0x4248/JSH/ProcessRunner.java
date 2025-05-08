package com.github._0x4248.JSH;

public class ProcessRunner {
    public static int RunCommand(String command) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            return process.waitFor();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return -1;
        }
    }
}

