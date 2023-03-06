package org.ld;

import org.ld.controller.DocController;

public class Client {

    private final DocController dc;

    public Client() {
        dc = new DocController();
    }

    public void run() {
        dc.main();
    }
}
