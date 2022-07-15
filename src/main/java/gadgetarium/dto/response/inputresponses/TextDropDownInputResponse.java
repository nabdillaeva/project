package gadgetarium.dto.response.inputresponses;

import gadgetarium.enums.InputType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class TextDropDownInputResponse extends SimpleInputResponse {

    private List<String> values;

    public TextDropDownInputResponse() {
    }

    public TextDropDownInputResponse(Long id, InputType type, String title, String placeHolder, List<String> values) {
        super(id, type, title, placeHolder);
        this.values = values;
    }
}
