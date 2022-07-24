package gadgetarium.dto.request.characteristic.save;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SaveColorCharacterRequest extends SaveCharacterRequest{

    private List<String> colors;

    public SaveColorCharacterRequest(Long templateId, List<String> colors) {
        super(templateId);
        this.colors = colors;
    }
}
