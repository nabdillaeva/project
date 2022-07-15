package gadgetarium.models;

import gadgetarium.enums.InputType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "character_template")
@Getter @Setter
public class CharacterTemplate {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private InputType type;

    private String title;

    private String placeHolder;

    private int imageCount;

    @ElementCollection
    private List<String> textDropDown;

    @ElementCollection
    private List<Integer> intDropDown;

    @ElementCollection
    private List<String> colors;

}
