package shawtest.github.domain;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;

public class Deserializer
        extends StdDeserializer<User> {

    public Deserializer() {
        this(null);
    }

    public Deserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public User deserialize(
            JsonParser jsonparser, DeserializationContext context)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = jsonparser.getText() + "}";
        System.out.println("json: " + json);
        var user = mapper.readValue(json, User.class);
        System.out.println("user: " + user);
        return user;
    }
}
