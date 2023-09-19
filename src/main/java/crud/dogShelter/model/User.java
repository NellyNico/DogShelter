//package crud.dogShelter.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.io.Serial;
//import java.io.Serializable;
//import java.util.Date;
//import java.util.Set;
//
//@Entity
//@NoArgsConstructor
//@Getter
//@Setter
//public class User implements Serializable {
//
//    @Serial
//    private static final long serialVersionUID = 65981149772133526L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "USER_ID")
//    private Long ID;
//
//    @Column(name = "PROVIDER_USER_ID")
//    private String providerUserID;
//
//    String email;
//
//    @Column(name = "enabled", columnDefinition = "BIT", length = 1)
//    private boolean enabled;
//
//    @Column(name = "display_name")
//    private String displayName;
//
//    @Column(name = "created_date", nullable = false, updatable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    protected Date createdDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    protected Date modifiedDate;
//
//    private String password;
//
//    private String provider;
//
//    @JsonIgnore
//    @ManyToMany
//    @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
//    private Set<Role> roles;
//}