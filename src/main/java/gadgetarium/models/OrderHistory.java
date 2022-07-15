package gadgetarium.models;

import gadgetarium.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orderHistories")
@Getter
@Setter
@NoArgsConstructor
public class OrderHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate localDate;
    private Long number;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private BigDecimal price;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "orderHistory")
    private List<Product> products;

}
