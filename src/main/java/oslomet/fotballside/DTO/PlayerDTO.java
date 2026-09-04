package oslomet.fotballside.DTO;

import tools.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = PlayerDeserializer.class)
public record PlayerDTO(
        int id,
        String firstname,
        String lastname,
        String age
)
 {}
