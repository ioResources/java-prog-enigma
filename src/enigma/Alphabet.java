
package enigma;

/**
 * Klasa definiuje alfabet używany w szyfrowaniu.
 */
public class Alphabet {
    
    //stałe definiujące alfabet
    public static final String ALPHA_UP_WITH_SPACE = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String ALPHA_LO_UP_WITH_SPACE = " AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
    public static final String NUMERIC = "0123456789";
    public static final String NUMERIC_HEX = NUMERIC + "ABCDEF";
    
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
