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
        String text = "TAJNE HASLO 123";

        //przesunięcie, domyślnie 1: A -> B
        int offset = 1;
        
        
        //-------------------- PRZYGOTOWANIE --------------------
        
        /*
         * Tworzymy alfabet
         */
        Alphabet alphabet = Alphabet.ALPHANUMERIC;
        
        /* Sprawdzamy poprawność - czy wszystkie znaki w tekście należą do ustalonego alfabetu
         * 
         * Korzystamy z metody isTextValid() typu wyliczeniowego Alphabet
         */ 
        if (!alphabet.isTextValid(text)) {
            throw new IllegalArgumentException("Tekst zawiera znaki spoza ustalonego alfabetu.");
        }
    
        //-------------------- SZYFROWANIE --------------------
        /* W pętli przechodzimy znak po znaku i do każdego znaku dodajemy przesunięcie.
         * Korzystamy z łańcucha znaków zdefiniowanego w alfabecie.
         * Uzyskany znak dopisujemy do wyjściowego (zaszyfrowanego) łańcucha.
         * Używamy w tym celu obiektu klasy StringBuilder.
         */
        
        String chars = alphabet.getChars();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<text.length(); ++i) {
            
            //odczytujemy kod i-tego znaku
            int ch = text.charAt(i);
            
            //dodajemy przesunięcie
            ch = chars.charAt( (chars.indexOf(ch) + offset) % chars.length() );
            
            //znak dopisujemy do łańcucha wyjściowego;
            //aby do łańcucha dodać znak, a nie jego kod, typ int musimy rzutować na char
            sb.append((char)ch);
        }
        
        //-------------------- WYNIKI --------------------
        System.out.println("Tekst szyfrowany:   " + text);
        System.out.println("Tekst zaszyfrowany: " + sb.toString());
        
    }
    
}
