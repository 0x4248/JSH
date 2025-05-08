package com.github._0x4248;

import com.github._0x4248.JSH.Commands;
import com.github._0x4248.JSH.ProcessRunner;
import com.github._0x4248.JSH.Prompt;
import com.github._0x4248.JSH.Startup;
import org.jline.reader.*;
import org.jline.reader.impl.DefaultParser;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        Startup.init();

        Terminal terminal = TerminalBuilder.builder()
                .system(true)
                .build();

        LineReader reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .parser(new DefaultParser())
                .build();


        String line;
        while (true) {
            line = reader.readLine(Prompt.getPrompt());
            if (line == null || line.trim().equalsIgnoreCase("exit")) {
                break;
            }
            Commands.execute("help", new String[]{});


            List<String> tokens = Arrays.asList(line.trim().split("\\s+"));
            if (tokens.isEmpty()) continue;

            ProcessRunner.RunCommand(line.trim());
        }

        terminal.close();
    }
}
