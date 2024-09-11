package bd.c9.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "email")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
