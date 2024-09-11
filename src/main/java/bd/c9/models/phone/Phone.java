package bd.c9.models.phone;

import bd.c9.models.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "phone")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @ManyToOne
    private DDD ddd;

    @ManyToOne
    private DDI ddi;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Override
    public String toString() {
        return String.format("+%d (%s) %s", ddi.getNumber(), ddd.getNumber(), number);
    }
}
