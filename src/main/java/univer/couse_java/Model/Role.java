package univer.couse_java.Model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @ManyToMany
    @JoinTable(
        name = "roles_room",
        joinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
          name = "room_id", referencedColumnName = "id"))
    private Collection<Room> privileges;
}
