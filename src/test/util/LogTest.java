package util;

import org.junit.Test;

import java.io.*;

/**
 * Created by li on 1/11/18.
 */
public class LogTest {

    @Test
    public void log() throws Exception {
        Thread t = new Thread(){
            @Override
            public void run() {
                pong();
            }
        };
        t.run();
        System.out.println("ping");
        System.out.println("--------------");
    }

    private static void pong() {
        System.out.println("pong");
    }

    public void Log() throws IOException {
        new BufferedWriter(new FileWriter("1.txt"));

    }
}