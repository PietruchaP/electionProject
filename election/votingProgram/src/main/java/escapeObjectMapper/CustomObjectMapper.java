package escapeObjectMapper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomObjectMapper extends ObjectMapper {

	 public CustomObjectMapper() {
	       this.getJsonFactory().setCharacterEscapes(new CustomCharacterEscape());
	     }

}
