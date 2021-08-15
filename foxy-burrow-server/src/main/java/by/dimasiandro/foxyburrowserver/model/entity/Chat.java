package by.dimasiandro.foxyburrowserver.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;


@Entity
@Table(name = "chats")
@Data
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Entity relationships */
    @OneToMany(mappedBy = "chat")
    private Collection<Message> messages;

    @ManyToMany(mappedBy = "chats")
    private Set<User> users;
}
