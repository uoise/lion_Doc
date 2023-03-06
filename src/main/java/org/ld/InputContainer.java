package org.ld;

import java.util.Scanner;

public class InputContainer {
    private final Scanner sc;

    public InputContainer() {
        sc = new Scanner(System.in);
    }

    public String nextLine() {
        return sc.nextLine().trim();
    }
}
