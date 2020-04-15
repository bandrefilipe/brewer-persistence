package bandrefilipe.brewer.persistence.core.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@EqualsAndHashCode
@ToString
public class BeverageRegistrationResponse {

    @ApiModelProperty(example = "1")
    private Long id;

    @ApiModelProperty(example = "AA000")
    private String sku;

    @ApiModelProperty(example = "Weihenstephaner Wheat Beer")
    private String name;

    private BeverageTypeRegistrationResponse type;

    @Builder
    @Getter
    @EqualsAndHashCode
    @ToString
    public static class BeverageTypeRegistrationResponse {

        @ApiModelProperty(example = "1")
        private Long id;

        @ApiModelProperty(example = "Amber Lager")
        private String name;
    }
}
