package by.dimasiandro.foxyburrowserver.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "posts")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255)
    private String imagePath;

    private Date date = new Date();

    @Size(max = 255)
    private String text;


    /** Entity relationships */

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User author;

    @ManyToMany
    @JoinTable(
            name = "likes",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> likes;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;
}
