package by.dimasiandro.foxyburrowserver.model.entity;

import by.dimasiandro.foxyburrowserver.model.entity.embeddable.ProfileInfo;
import by.dimasiandro.foxyburrowserver.model.entity.enums.Role;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40)
    @Size(min = 5, max = 40)
    private String login;

    @Column(length = 120)
    @Size(min = 4, max = 120)
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="firstName", column = @Column(name="first_name", length = 40)),
            @AttributeOverride(name="lastName", column = @Column(name="last_name", length = 40)),
            @AttributeOverride(name="avatarPath", column = @Column(name="avatar_path")),
            @AttributeOverride(name="status", column = @Column(name="status")),
            @AttributeOverride(name="birthday", column = @Column(name="birthday")),
            @AttributeOverride(name="city", column = @Column(name="city", length = 40)),
            @AttributeOverride(name="country", column = @Column(name="country", length = 40)),
            @AttributeOverride(name="placeOLfWork", column = @Column(name="place_of_work", length = 40)),
            @AttributeOverride(name="placeOfStudy", column = @Column(name="place_of_study", length = 40)),
    })
    private ProfileInfo profileInfo;

    /** Entity relationships */

    @ManyToMany(mappedBy = "likes")
    private Set<Post> likedPosts;


    @OneToMany(mappedBy = "author")
    private Set<Post> posts;

    @OneToMany(mappedBy = "author")
    private Set<Comment> comments;

    @OneToMany(mappedBy = "user")
    private Set<Notification> notifications;

    @OneToMany(mappedBy = "author")
    private Set<Message> messages;

    @ManyToMany
    @JoinTable(
            name = "user_chats",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "chat_id"))
    private Set<Chat> chats;

}
