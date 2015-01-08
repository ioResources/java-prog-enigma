package enigma;

/**
 * Aplikacja ma umożliwiać szyfrowanie tekstu.
 * 
 */
public class Enigma {

    /**
     * Implementacja szyfru Cezara.
     * 
     * Algorytm ma działać na ustalonym alfabecie (np. litery alfabetu łacińskiego A-Z).
     * W przypadku podania łańcucha zawierającego znaki spoza alfabetu ma rzucać wyjątek.
     * 
     * @param args
     */
    public static void main(String[] args) {

        //-------------------- DANE WEJŚCIOWE --------------------
        //tekst do zaszyfrowania
        String text = "ABC XYZ";

        //przesunięcie, domyślnie 1: A -> B
        int offset = 1;
        
        
        //-------------------- PRZYGOTOWANIE --------------------        
        /* Sprawdzamy poprawność - czy wszystkie znaki w tekście należą do ustalonego alfabetu;
         * zakładamy, że alfabet składa się tylko z liter A-Z (bez polskich)
         * 
         * Korzystamy z metody matches() klasy String i wyrażenia regularnego definiującego alfabet
         */ 
//        if (!text.matches("^[ -Z]*$")) {
//            throw new IllegalArgumentException("Tekst zawiera znaki spoza ustalonego alfabetu.");
//        }
    
        //-------------------- SZYFROWANIE --------------------
        
        //tworzymy obiekt klasy Cipher
        Cipher cipher = new Cipher();
        
        //ustawiamy offset
        cipher.setOffset(offset);
        
        //szyfrujemy
        String encText = cipher.encrypt(text);
        
        //deszyfrujemy
        String decText = cipher.decrypt(encText);
        
        //-------------------- WYNIKI --------------------
        System.out.println("Tekst szyfrowany:   " + text);
        System.out.println("Tekst zaszyfrowany: " + encText);
        System.out.println("Tekst odszyfrowany: " + decText);        
    
    }
    
}
