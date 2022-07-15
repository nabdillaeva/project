package gadgetarium.dto.response.inputresponses;

import gadgetarium.enums.InputType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class IntDropDownInputResponse extends SimpleInputResponse {

    private List<Integer> values;

    public IntDropDownInputResponse() {
    }

    public IntDropDownInputResponse(Long id, InputType type, String title, String placeHolder, List<Integer> values) {
        super(id, type, title, placeHolder);
        this.values = values;
    }
}
