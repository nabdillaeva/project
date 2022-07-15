package gadgetarium.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gadgetarium.enums.ProductInStock;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private Long artikul;

    private int count;

    private LocalDate createdAt;

    private int discount;

    @Enumerated(EnumType.STRING)
    private ProductInStock status;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Character> characters;

    @ManyToOne
    @JsonIgnore
    private SubCatalog subCatalog;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<Order> orders;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<FeedBack> feedBacks;

    @ManyToOne
    @JsonIgnore
    private OrderHistory orderHistory;
}
