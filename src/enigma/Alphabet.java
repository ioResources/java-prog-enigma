package enigma;

/**
 * Typ wyliczeniowy definiujący dostępne alfabety.
 */
public enum Alphabet {
    ALPHA("ABCDEFGHIJKLMNOPQRSTUVWXYZ "),
    ALPHANUMERIC("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ "),
    NUMERIC("0123456789");
    
    
    /**
     * Konstruktor
     */
    private Alphabet(String chars) {
        this.chars = chars;
    }
    
    /**
     * Metoda zwraca zestaw znaków w alfabecie (jako łańcuch)
     */
    public String getChars() {
        return chars;
    }
    
    /**
     * Metoda sprawdza, czy przekazany tekst jest zgodny z alfabetem (czy nie
     * zawiera znaków spoza alfabetu)
     */
    public boolean isTextValid(String text) {
        return text.matches("^["+chars+"]*$");
    }
    
    //--- prywatne pola
    private String chars;
}
