package dev.igraciarena.domain.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Data
@EqualsAndHashCode
@Builder(builderClassName = "Builder")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientCreateRequest {
    @JsonProperty(value = "first_name")
    private String firstName;
    @JsonProperty(value = "last_name")
    private String lastName;
    @JsonProperty(value = "created_date")
    private Instant createdDate;
    @JsonProperty(value = "modified_date")
    private Instant modifiedDate;
    @JsonProperty(value = "is_active")
    private boolean isActive;
    @JsonProperty(value = "is_deleted")
    private boolean isDeleted;
}
