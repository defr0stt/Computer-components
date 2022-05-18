package ua.lpnu.computer_components.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_details")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    public UserEntity() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}