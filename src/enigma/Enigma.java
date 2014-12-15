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
        String text = "tajna wiadomosc abc xyz";

        //przesunięcie, domyślnie 1: A -> B
        int offset = 1;
        
        
        //-------------------- PRZYGOTOWANIE --------------------        
        /* Zamieniamy na wielkie litery - wynika to z założonego alfabetu */
        text = text.toUpperCase();
        
        /* Sprawdzamy poprawność - czy wszystkie znaki w tekście należą do ustalonego alfabetu;
         * zakładamy, że alfabet składa się tylko z liter A-Z (bez polskich)
         * 
         * Korzystamy z metody matches() klasy String i wyrażenia regularnego definiującego alfabet
         */ 
        if (!text.matches("^[A-Z ]*$")) {
            throw new IllegalArgumentException("Tekst zawiera znaki spoza ustalonego alfabetu.");
        }
    
        //-------------------- SZYFROWANIE --------------------
        /* W pętli przechodzimy znak po znaku i do każdego kodu znaku dodajemy przesunięcie.
         * Uzyskany znak dopisujemy do wyjściowego (zaszyfrowanego) łańcucha.
         * Używamy w tym celu obiektu klasy StringBuilder.
         */
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<text.length(); ++i) {
            
            //odczytujemy kod i-tego znaku
            int ch = text.charAt(i);
            
            //dodajemy przesunięcie
            ch = ch + offset;
            
            //znak dopisujemy do łańcucha wyjściowego;
            //aby do łańcucha dodać znak, a nie jego kod, typ int musimy rzutować na char
            sb.append((char)ch);
        }
        
        //-------------------- WYNIKI --------------------
        System.out.println("Tekst szyfrowany: " + text);
        System.out.println("Tekst zaszyfrowany: " + sb.toString());
        
    
    }
    
}
