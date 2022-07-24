package gadgetarium.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PhoneDto {

    private String name;
    private List<String> images;
    private Long article;
    private String brandImage;
    private Boolean status;
    private int countOfProducts;
    private int discount;
    private BigDecimal price;
    private double screen;
    private List<String> color;
    private LocalDate date;
    private String OS;
    private int memory;
    private String simCard;
    private int guarantee;
    private String CPU;
    private double weight;

}
