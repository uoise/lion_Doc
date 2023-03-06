package org.ld.sevice;

import org.ld.model.Doc;

import java.util.ArrayList;
import java.util.List;

public class DocService {

    private final List<Doc> docList;
    private long idGen;

    private String content;
    private String author;

    public DocService() {
        docList = new ArrayList<>();
        idGen = 1;
    }

    public long create(String content, String author) {
        docList.add(new Doc(idGen, content, author));
        return idGen++;
    }

    public String getAll() {
        StringBuilder sb = new StringBuilder();
        for (Doc d : docList) sb.append(d.toString()).append("\n");

        return sb.toString();
    }

    public Doc find(long id) {
        for (Doc doc : docList) if (doc.getId() == id) return doc;
        return null;
    }

    public boolean delete(long id) {
        for (int i = 0; i < docList.size(); i++) {
            if (docList.get(i).getId() == id) {
                docList.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean update(Doc doc) {
        for (int i = 0; i < docList.size(); i++) {
            if (docList.get(i).getId() == doc.getId()) {
                docList.set(i, doc);
                return true;
            }
        }
        return false;
    }
}
