package crud.dogShelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dog_ID")
    private Long ID;

    @Column(name = "dog_name")
    private String name;

    @Column(name = "dog_age", nullable = false)
    private int age;

    @Column(name = "dog_gender", nullable = false)
    private String gender;

    @Column(name = "dog_breed")
    private String breed;

    @Column(name = "dog_color", nullable = false)
    private String color;

    @OneToMany(mappedBy = "dog")
    @JsonIgnore
    private List<Adoption> adoptions;
}
