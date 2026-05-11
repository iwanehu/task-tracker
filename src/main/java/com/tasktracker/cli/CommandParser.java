package com.tasktracker.cli;

import com.tasktracker.modelo.Status;

public class CommandParser {
    public String getCommand(String line){
        return line.split(" ")[0];
    }

    public String getArgs( String line){
        if(!line.contains(" "))return "";
        return line.substring(line.indexOf(" ") + 1);
    }

    public Status parseStatus(String text){
        return Status.valueOf(
                text.toUpperCase()
                        .replace(" ", "_")
                        .replace("-", "_")
        );

    }
}
