package by.dimasiandro.foxyburrowserver.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Table(name = "comments")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date = new Date();

    @Size(max = 255)
    private String text;


    /** Entity relationships */
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User author;

    @ManyToOne
    @JoinColumn(name="post_id", nullable=false)
    private Post post;
}
