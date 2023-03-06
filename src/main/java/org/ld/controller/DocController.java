package org.ld.controller;

import org.ld.Cmds;
import org.ld.InputContainer;
import org.ld.sevice.DocService;

import java.util.Scanner;

public class DocController {

    private final InputContainer ic;
    private final DocService docService;

    private String cmd;


    public DocController(Scanner sc) {
        ic = new InputContainer(sc);
        docService = new DocService();
    }

    public int create() {
        System.out.print("명언 : ");
        String content = ic.nextLine();
        System.out.print("작가 : ");
        String author = ic.nextLine();
        return docService.create(content, author);
    }

    public void main() {
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            cmd = ic.nextLine();
            switch (cmd) {
                case "종료" -> {
                    System.out.println("== 명언 앱 종료 ==");
                    return;
                }
                case "등록" -> System.out.printf("%d번 명언이 등록되었습니다.\n", create());
                case "목록" -> System.out.printf("번호 / 작가 / 명언\n----------------------\n%s\n", docService.getAll());
                case "수정" -> {
                    System.out.println();
                }
                case "삭제" -> {
                    System.out.println();
                }
                default -> System.out.println("올바르지 않은 명령입니다.\n");
            }
        }
    }
}
