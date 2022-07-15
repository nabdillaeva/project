package gadgetarium.dto.request.characteristic.save;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SaveImagesCharacterRequest extends SaveCharacterRequest{
    private List<String> images;

    public SaveImagesCharacterRequest(Long templateId, List<String> images) {
        super(templateId);
        this.images = images;
    }
}
