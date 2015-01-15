
package enigma;

/**
 * Klasa definiuje alfabet używany w szyfrowaniu.
 */
public class Alphabet {
    
    /**
     * Enumeracja z definicjami alfabetu
     */
    public enum CharSet {
        ALPHA_UP_WITH_SPACE(" ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
        ALPHA_LO_UP_WITH_SPACE(" AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz"),
        NUMERIC("0123456789"),
        NUMERIC_HEX("0123456789ABCDEF");
    
        private final String chars;
    
        CharSet(String chars) {
            this.chars = chars;
        }
        
        public String getChars() {
            return chars;
        }
    }
      
    private final String charset;
    private final int length;
    
    /**
     * Konstruktor przyjmujący definicję alfabetu jako łańcuch
     * 
     * @param charset 
     */
    public Alphabet(String charset) {
        this.charset = charset;
        this.length = charset.length();
    }
    
    /**
     * Konstruktor przyjmujący wartość typu wyliczeniowego CharSet
     * 
     * @param charsetEnum 
     */
    public Alphabet(CharSet charsetEnum) {
        this(charsetEnum.getChars());
    }
    
    /**
     * Metoda sprawdzająca poprawność tekstu względem alfabetu
     * 
     * @param text
     * @return 
     */
    public boolean isTextValid(String text) {
        return text.matches("^[" + charset + "]*$");
    }
    
    /**
     * Metoda zwraca znak znajdujący się pod danym indeksem alfabetu
     * 
     * @param index
     * @return 
     */
    public char charAt(int index) {
        return charset.charAt(index);
    }
    
    /**
     * Metoda zwraca indeks danego znaku alfabetu
     * 
     * @param ch
     * @return 
     */
    public int indexOf(char ch) {
        return charset.indexOf(ch);
    }
    
    /**
     * metoda zwraca długość alfabetu
     * 
     * @return 
     */
    public int length() {
        return length;
    }
  
}
