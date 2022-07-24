package gadgetarium.models;

import gadgetarium.enums.InputType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "characters")
@Getter
@Setter
@NoArgsConstructor
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private InputType type;

    private String textValue;

    private int intValue;

    @ElementCollection
    private List<String> textValues;

    @ElementCollection
    private List<Integer> intValues;

    private LocalDate date;

    private String file;

    @ElementCollection
    private List<String> colors;

    @ElementCollection
    private List<String> images;
}
