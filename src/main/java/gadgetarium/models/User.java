package gadgetarium.models;

import gadgetarium.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String image;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany
    private List<Product> basket;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToMany
    private List<Product> favorites;

    @OneToMany
    private List<Product> viewed;

    @OneToMany(mappedBy = "userFeedback")
    private List<FeedBack> feedBacks;

    @OneToOne(mappedBy = "user")
    private OrderHistory orderHistory;

    @OneToOne
    private Rating rating;
}
