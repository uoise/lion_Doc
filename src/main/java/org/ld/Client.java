package org.ld;

import org.ld.controller.DocController;

import java.util.Scanner;

public class Client {

    private final DocController dc;

    public Client(Scanner sc) {
        dc = new DocController(sc);
    }

    public void run() {
        dc.main();
    }
}
