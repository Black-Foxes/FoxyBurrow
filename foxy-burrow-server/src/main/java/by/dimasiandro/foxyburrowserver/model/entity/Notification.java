package by.dimasiandro.foxyburrowserver.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Table(name = "notifications")
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255)
    private String text;

    private Date date = new Date();

    /** Entity relationships */

    @ManyToOne
    @JoinColumn(name = "user_id", nullable=false)
    private User user;
}
