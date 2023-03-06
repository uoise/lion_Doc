package org.ld.model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Doc {
    private final long id;
    private final String content;
    private final String author;

    public Doc(long id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(this));
            }
        } catch (Exception e) {
            System.out.println("docs field err");
        }
        return map;
    }

    @Override
    public String toString() {
        return id + " / " + content + " / " + author;
    }
}

