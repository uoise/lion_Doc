package org.ld.controller;

import org.ld.Cmds;
import org.ld.InputContainer;
import org.ld.sevice.DocService;

public class DocController {

    private final InputContainer ic;
    private final DocService docService;

    private String cmd;

    public DocController() {
        docService = new DocService();
        ic = new InputContainer();
    }

    public void main() {
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령)");
            cmd = ic.nextLine();
            switch (cmd) {
                case "종료":
                    return;
                default:
                    System.out.println("올바르지 않은 명령입니다.\n");
            }
        }
    }
}
