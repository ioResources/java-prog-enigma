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

        //-------------------- SZYFROWANIE --------------------
        
        //tworzymy alfabet
//        Alphabet alpha = new Alphabet(" ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        Alphabet alpha = new Alphabet(Alphabet.ALPHA_UP_WITH_SPACE);
        
        //tworzymy obiekt klasy Cipher
        Cipher cipher = new Cipher(alpha);
        
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
