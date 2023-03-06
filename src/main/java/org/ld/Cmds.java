package org.ld;

public enum Cmds {
    create("등록"),
    read("목록"),
    update("목록"),
    delete("삭제");
    private final String value;

    Cmds(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
