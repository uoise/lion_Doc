package com.ld;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    @Test
    @DisplayName("Test for input Util")
    public void t1() {
        Scanner inp = TestUtil.genScanner("종료");
        String res = inp.nextLine().trim();
        assertEquals("종료", res);
    }

    @Test
    @DisplayName("Test for output Util")
    public void t2() {
        ByteArrayOutputStream out = TestUtil.setOutToByteArray();
        System.out.println("완료");
        String s = out.toString().trim();
        assertEquals("완료", s);
    }
}
