package bandrefilipe.brewer.persistence.core.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public final class BeverageRegistrationRequest {

    @NotBlank
    @ApiModelProperty(example = "AA000")
    private String sku;

    @NotBlank
    @ApiModelProperty(example = "Weihenstephaner Wheat Beer")
    private String name;

    @ApiModelProperty(example = "A veritable classic – and the star of our beer ensemble")
    private String description;

    @NotNull
    @DecimalMin("0.01")
    @DecimalMax("999999.99")
    @ApiModelProperty(example = "32.99", allowableValues = "range[0.01, infinity]")
    private BigDecimal unitPrice;

    @PositiveOrZero
    @DecimalMax("100.00")
    @ApiModelProperty(example = "5.40", allowableValues = "range[0.00, 100.00]")
    private BigDecimal alcoholContent;

    @PositiveOrZero
    @DecimalMax("100.00")
    @ApiModelProperty(example = "18.00", allowableValues = "range[0.00, 100.00]")
    private BigDecimal commission;

    @PositiveOrZero
    @ApiModelProperty(example = "300", allowableValues = "range[0, infinity]")
    private Integer stock;

    @NotBlank
    @Pattern(regexp = "[I,N]")
    @ApiModelProperty(example = "I", allowableValues = "I, N")
    private String originCode;

    @NotBlank
    @Pattern(regexp = "[B,F,S,T,W]")
    @ApiModelProperty(example = "B", allowableValues = "B, F, S, T, W")
    private String flavorCode;

    @NotNull
    @Positive
    @ApiModelProperty(example = "1", allowableValues = "range[1, infinity]")
    private Long beverageTypeId;
}
