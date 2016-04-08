package jnews.model;
import javax.persistence.*;
@Entity
@Table(name="news")
public class News {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column(name = "title",length = 300)
    private String title;

    @Column(name = "link",length = 300)
    private String link;

    public News() {
    }
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return title +" "+ link;
    }
}
