package gadgetarium.dto.response.inputresponses;

import gadgetarium.enums.InputType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleInputResponse implements InputResponse {

    private Long id;

    private InputType type;

    private String title;

    private String placeHolder;
}
