package myapp.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Blog {
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String author;
    private String content;
   private Timestamp date;
    public Blog() {
    }

    public Blog(String author, String content) {
        this.author = author;
        this.content = content;
    }

    public Blog(long id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
