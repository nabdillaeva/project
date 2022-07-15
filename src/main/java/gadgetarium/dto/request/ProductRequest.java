package gadgetarium.dto.request;

import gadgetarium.dto.request.characteristic.save.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class ProductRequest {

    private String productName;

    private List<SaveTextCharacterRequest> textCharacterRequests = new ArrayList<>();
    private List<SaveIntegerCharacterRequest> integerCharacterRequests = new ArrayList<>();
    private List<SaveTextDropDownCharacterRequest> textDropDownCharacterRequests = new ArrayList<>();
    private List<SaveIntDropDownCharacterRequest> intDropDownCharacterRequests = new ArrayList<>();
    private List<SaveDateCharacterRequest> dateCharacterRequests = new ArrayList<>();
    private List<SaveColorCharacterRequest> colorCharacterRequests = new ArrayList<>();
    private List<SaveFileCharacterRequest> fileCharacterRequests = new ArrayList<>();
    private List<SaveImagesCharacterRequest> imagesCharacterRequests = new ArrayList<>();

}
