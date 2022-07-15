package gadgetarium.dto.response.inputresponses;

import gadgetarium.enums.InputType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ImageInputResponse extends SimpleInputResponse {

    private long imageCount;

    public ImageInputResponse() {
    }

    public ImageInputResponse(Long id, InputType type, String title, String placeHolder, long imageCount) {
        super(id, type, title, placeHolder);
        this.imageCount = imageCount;
    }
}
