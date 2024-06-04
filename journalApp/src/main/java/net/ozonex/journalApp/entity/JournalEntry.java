package net.ozonex.journalApp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.crypto.Data;

@Document(collection = "journal_entries")
public class JournalEntry {
    @Id
    private String id;
    private String title;

    public Data getDate() {
        return date;
    }

    public void setDate(Data date) {
        this.date = date;
    }

    private Data date ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    private String content;
}
