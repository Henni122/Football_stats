package oslomet.fotballside.DTO;


import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;



public class PlayerDeserializer extends ValueDeserializer<PlayerDTO> {

    @Override
    public PlayerDTO deserialize(JsonParser parser, DeserializationContext context) throws JacksonException {

        JsonNode jsonNode = parser.readValueAsTree();

        JsonNode playerNode = jsonNode.get("player");

        int id = playerNode.get("id").asInt();
        String firstName = playerNode.get("firstname").asText();
        String lastName = playerNode.get("lastname").asText();
        String age = playerNode.get("age").asText();


        return new PlayerDTO(id, firstName, lastName, age);
    }
}
