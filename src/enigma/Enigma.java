package enigma;

/**
 * Aplikacja ma umożliwiać szyfrowanie tekstu.
 * 
 */
public class Enigma {

    /**
     * Implementacja szyfru Cezara.
     * 
     * @param args
     */
    public static void main(String[] args) {

        //-------------------- DANE WEJŚCIOWE --------------------
        //tekst do zaszyfrowania
        String text = "ABC123";

        //przesunięcie, domyślnie 1: A -> B
        int offset = 1;

        //-------------------- SZYFROWANIE --------------------
        
        //tworzymy alfabet
        Alphabet alpha = new Alphabet(Alphabet.CharSet.NUMERIC_HEX);
        
        //tworzymy obiekt klasy Cipher
        Cipher cipher = new CipherCaesar(alpha);
        
        //ustawiamy offset
        cipher.setKey(offset);
        
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
