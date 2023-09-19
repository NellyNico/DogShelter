package crud.dogShelter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long ID;

    @Column(name = "customer_name", nullable = false)
    private String name;

    @Column(name = "customer_CNP", nullable = false)
    private String CNP;

    @Column(name = "customer_address", nullable = false)
    private String address;

    @Column(name = "customer_phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "customer_email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Adoption> adoptions;
}

