package org.ld;

import java.util.Scanner;

public class InputContainer {
    private final Scanner sc;

    public InputContainer(Scanner sc) {
        this.sc = sc;
    }

    public String nextLine() {
        return sc.nextLine().trim();
    }
}
