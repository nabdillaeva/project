package gadgetarium.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "feedBacks")
@Getter
@Setter
@NoArgsConstructor
public class FeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDate localDate;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User userFeedback;

}
