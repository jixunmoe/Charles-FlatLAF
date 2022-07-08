package uk.jixun.charles.theme;

import java.lang.instrument.Instrumentation;

public class PreMain {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("[CharlesFlatLAF]: Loaded via premain.");
        inst.addTransformer(new CharlesTransformer(), true);
    }
}
