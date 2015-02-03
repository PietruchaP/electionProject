package escapeObjectMapper;


import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;

public class CustomCharacterEscape extends CharacterEscapes{
	
	//private static final Logger log = Logger.getLogger(CustomCharacterEscape.class);

    private final int[] _asciiEscapes;

    public CustomCharacterEscape() {
      _asciiEscapes = standardAsciiEscapesForJSON();
      _asciiEscapes['-'] = CharacterEscapes.ESCAPE_STANDARD;
    }

    @Override
    public int[] getEscapeCodesForAscii() {
      return _asciiEscapes;
    }

    @Override
    public SerializableString getEscapeSequence(int i) {
      return null;
   }
}
