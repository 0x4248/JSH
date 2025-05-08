package com.github._0x4248.JSH;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal;

public class Prompt {
    public static String defaultPrompt = "$ ";
    public static Terminal terminal;
    public static LineReader reader;

    public static String getPrompt() {
        return defaultPrompt;
    }

    public static String showPrompt() {
        String line;
        try {
            line = reader.readLine(getPrompt());
        } catch (UserInterruptException | EndOfFileException e) {
            return null;
        }
        return line;
    }
}
