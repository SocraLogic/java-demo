package uk.co.socralogic.java.demo.consumer;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Value;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Value
@JsonDeserialize(builder = MessageEvent.MessageEventBuilder.class)
public class MessageEvent {


    private Map<String, Object> extraFields;

    @JsonAnyGetter
    public Map<String, Object> getExtraFields(){
        return Collections.unmodifiableMap(extraFields);
    }

    @JsonPOJOBuilder
    public static class MessageEventBuilder {

        private Map<String, Object> extraFields = new HashMap<>();

        @JsonAnySetter
        public MessageEventBuilder extraField(String name, Object value) {
            Map<String, Object> newFields = new HashMap<>(extraFields);
            newFields.put(name, value);
            extraFields = newFields;
            return this;
        }
    }
}
