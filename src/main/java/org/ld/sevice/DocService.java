package org.ld.sevice;

import org.ld.model.Doc;

import java.util.ArrayList;
import java.util.List;

public class DocService {

    private final List<Doc> docList;
    private int idGen;

    private String content;
    private String author;

    public DocService() {
        docList = new ArrayList<>();
        idGen = 1;
    }

    public int create(String content, String author) {
        docList.add(new Doc(idGen, content, author));
        return idGen++;
    }

    public String getAll() {
        StringBuilder sb = new StringBuilder();
        for (Doc d : docList) sb.append(d.toString()).append("\n");
        return sb.toString();
    }
}
