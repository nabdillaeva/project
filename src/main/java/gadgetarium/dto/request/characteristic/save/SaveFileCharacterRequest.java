package gadgetarium.dto.request.characteristic.save;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaveFileCharacterRequest extends SaveCharacterRequest{
    private String file;

    public SaveFileCharacterRequest(Long templateId, String file) {
        super(templateId);
        this.file = file;
    }
}
