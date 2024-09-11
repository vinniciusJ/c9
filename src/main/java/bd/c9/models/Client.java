package bd.c9.models;

import bd.c9.models.address.Address;
import bd.c9.models.phone.Phone;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "client")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String documentNumber;

    private ClientType clientType;

    private String addressNumber;

    private String addressComplement;

    @ManyToOne
    private Address address;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Email> emails;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Phone> phones;
}
