package com.github._0x4248.JSH;

import java.lang.reflect.Method;
import java.util.*;

public class Commands {

    public static class CommandDefinition {
        public final String className;
        public final String methodName;

        public CommandDefinition(String className, String methodName) {
            this.className = className;
            this.methodName = methodName;
        }
    }

    private static final Map<String, CommandDefinition> commandMap = new HashMap<>();

    public Commands() {
        register("help", "com.github._0x4248.JSHBuiltin.help", "main");
        register("exit", "com.github._0x4248.JSHBuiltin.exit", "main");
    }

    public void register(String name, String className, String methodName) {
        commandMap.put(name, new CommandDefinition(className, methodName));
    }

    public Set<String> getCommandNames() {
        return commandMap.keySet();
    }

    public CommandDefinition get(String command) {
        return commandMap.get(command);
    }

    public boolean hasCommand(String name) {
        return commandMap.containsKey(name);
    }

    public static int execute(String name, String[] args) {
        CommandDefinition def = commandMap.get(name);
        if (def == null) {
            return ProcessRunner.RunCommand(name);
        }

        try {
            Class<?> clazz = Class.forName(def.className);
            Method method = clazz.getMethod(def.methodName, String[].class);
            method.invoke(null, (Object) args);
            return 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
