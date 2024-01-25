package dev.igraciarena.domain.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;


/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@JsonPropertyOrder({"id", "line_number", "city", "state", "country",
        "postal_code"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@EqualsAndHashCode(callSuper = false)
@Builder(builderClassName = "Builder")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressModel extends RepresentationModel<AddressModel> {
    private Long id;
    @JsonProperty(value = "line_number")
    private String lineNumber;
    private String city;
    private String state;
    private String country;
    @JsonProperty(value = "postal_code")
    private String postalCode;
}
