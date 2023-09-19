package crud.dogShelter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "adoptions")
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adoption_id")
    private Long id;

    @Column(name = "adoption_quantity", nullable = false)
    private int quantity;

    @Column(name = "adoption_status", nullable = false)
    private String status;

    @Column(name = "adoption_date", nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}