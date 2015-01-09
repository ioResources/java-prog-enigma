package enigma;

/**
 * Klasa definiuje alfabet używany w szyfrowaniu.
 */
public class Alphabet {
    
    private String charset;
    private int length;
    
    public Alphabet(String charset) {
        this.charset = charset;
        this.length = charset.length();
    }
    
    public Alphabet(CharSet charset) {
        this(charset.getChars());
    }
    
    public boolean isTextValid(String text) {
        return text.matches("^[" + charset + "]*$");
    }
    
    public char charAt(int index) {
        return charset.charAt(index);
    }
    
    public int indexOf(char ch) {
        return charset.indexOf(ch);
    }
    
    public int length() {
        return length;
    }
    
    /**
     * Enumeracja
     */
    public enum CharSet {
        ALPHA_UP_WITH_SPACE(" ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
        DIGITS("0123456789");
    
        private String chars;
    
        CharSet(String chars) {
            this.chars = chars;
        }
        
        public String getChars() {
            return chars;
        }
    
    }
}
