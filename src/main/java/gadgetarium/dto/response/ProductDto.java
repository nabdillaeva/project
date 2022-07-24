package gadgetarium.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ProductDto {

    private Long productId;
    private String image;
    private String productName;
    private Long article;
    private LocalDate createAt;
    private BigDecimal price;
    private int discount;
    private BigDecimal currentPrice;
    private int count;



}
