package com.ld;

import org.ld.Client;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class TestRunner {
    public static String run(String s) {
        s.stripIndent().trim();
        s += "\n종료";

        Scanner sc = TestUtil.genScanner(s);
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new Client(sc).run();

        String res = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        return res;
    }
}
