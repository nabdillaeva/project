package gadgetarium.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
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

    private String brandImage;

    private int guarantee;

    private int discount;

    private Long article;

    private BigDecimal price;

    private int count;

    private Boolean status;


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

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Rating> rating;
}
