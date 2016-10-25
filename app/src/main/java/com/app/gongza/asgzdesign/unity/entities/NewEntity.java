package com.app.gongza.asgzdesign.unity.entities;

import org.litepal.crud.DataSupport;

/**
 * Created by gongza on 2016/10/25.
 */

public class NewEntity extends DataSupport {
    private int id;

    private String title;

    private String content;

    private int commentCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
