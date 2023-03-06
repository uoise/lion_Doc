package org.ld.controller;

import org.ld.Cmds;
import org.ld.InputContainer;
import org.ld.model.Doc;
import org.ld.sevice.DocService;

import java.util.Scanner;

public class DocController {

    private final InputContainer ic;
    private final DocService docService;

    private String[] cmds;


    public DocController(Scanner sc) {
        ic = new InputContainer(sc);
        docService = new DocService();
    }

    public String getOpr() {
        return cmds[0];
    }

    public long getArgID() {
        return Long.parseLong(cmds[2]);
    }

    public long create() {
        System.out.print("명언 : ");
        String content = ic.nextLine();
        System.out.print("작가 : ");
        String author = ic.nextLine();
        return docService.create(content, author);
    }

    public void delete(long id) {
        if (docService.delete(id))
            System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
        else
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
    }

    public void update(long id) {
        Doc fnd = docService.find(id);
        String content, author;
        if (fnd == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.println("명언 기존) : " + fnd.getContent());
        System.out.print("명언 신규)");
        content = ic.nextLine();

        System.out.println("작가 기존) : " + fnd.getAuthor());
        System.out.print("작가 신규) ");
        author = ic.nextLine();

        Doc pst = new Doc(fnd.getId(), content, author);
        docService.update(pst);
    }

    public void main() {
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            cmds = ic.getCmds();
            switch (getOpr()) {
                case "종료" -> {
                    System.out.println("== 명언 앱 종료 ==");
                    return;
                }
                case "등록" -> System.out.printf("%d번 명언이 등록되었습니다.\n", create());
                case "목록" -> System.out.printf("번호 / 작가 / 명언\n----------------------\n%s\n", docService.getAll());
                case "수정" -> update(getArgID());
                case "삭제" -> delete(getArgID());
                default -> System.out.println("올바르지 않은 명령입니다.\n");
            }
        }
    }
}
