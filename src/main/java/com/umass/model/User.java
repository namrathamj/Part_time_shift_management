package com.umass.model;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import java.util.Set;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Builder;
import lombok.Data;

@Document(collection = "Users")
@EntityScan
@Builder
@Data
public class User {

    @Id
    @Schema(description = "User ID", accessMode = AccessMode.READ_ONLY)
    private String id;

    @Indexed(direction = IndexDirection.ASCENDING)
    @Schema(description = "Username", example = "john_doe", required = true)
    private String username;

    @Field("password")
    @Schema(description = "User password", example = "secretpassword", accessMode = AccessMode.WRITE_ONLY)
    private String password;

    @Schema(description = "Set of roles assigned to the user", example = "[\"ROLE_USER\", \"ROLE_ADMIN\"]")
    @ArraySchema(schema = @Schema(description = "Role", example = "ROLE_USER"))
    private Set<String> roles;
}
