package b2camp.timc.parameterservice.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MSavingProductResponse {

    private Long id;
    private String productName;
    private String description;


}
