package gadgetarium.dto.request.characteristic.save;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaveTextCharacterRequest extends SaveCharacterRequest{

    private String value;

    public SaveTextCharacterRequest(Long templateId, String value) {
        super(templateId);
        this.value = value;
    }
}
