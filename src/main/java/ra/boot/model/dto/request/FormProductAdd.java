package ra.boot.model.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
public class FormProductAdd {
    private String name,description;
    private String price;
    private Integer stock;
    private MultipartFile image;
    private Integer categoryId;

}
