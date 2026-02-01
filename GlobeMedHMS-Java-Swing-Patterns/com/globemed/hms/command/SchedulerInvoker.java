package com.globemed.hms.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class SchedulerInvoker {
    private Deque<String> log = new ArrayDeque<>();
    public String invoke(Command cmd){
        String res = cmd.execute();
        log.add(res);
        return res;
    }
    public String getHistory(){
        return String.join("\n", log);
    }
}
