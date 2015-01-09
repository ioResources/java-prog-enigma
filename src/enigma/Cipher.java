package enigma;

/**
 * Klasa odpowiedzialna za szyfrowanie.
 * 
 */
public class Cipher {
    
    /*
     * Pole offset i metody dostępowe.
     */
    private int offset;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
       
    /*
     * Pole alphabet
     */
    private Alphabet alphabet;
    
    //
    public Cipher(Alphabet alphabet) {
        this.alphabet = alphabet;
    }
    
    
    /**
     * Metoda szyfruje przekazany tekst.
     * 
     * @param text tekst do zaszyfrowania
     * @return zaszyfrowany tekst
     */
    public String encrypt(String text) {
        //sprawdzamy, czy tekst jest poprawny
        if (!alphabet.isTextValid(text)) {
            throw new IllegalArgumentException("Tekst zawiera znaki spoza alfabetu.");
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<text.length(); ++i) {
            
            //odczytujemy kod i-tego znaku
            char ch = text.charAt(i);
            
            //pobieramy indeks znaku w alfabecie
            int idx = alphabet.indexOf(ch);
            
            //przesuwamy się w alfabecie o offset
            idx = (idx + offset) % alphabet.length();
            
            //odczytujemy znak z przesuniętego indeksu
            ch = alphabet.charAt(idx);
            
            //dołączamy znak do łańcucha wyjściowego
            sb.append((char)ch);
        }
        
        return sb.toString();
    }

    /**
     * Metoda odszyfrowująca przekazany tekst.
     * Działa tak samo jak metoda encrypt().
     * Jedyna różnica polega na tym, że odejmuje offset.
     * 
     * @param text zaszyfrowany tekst
     * @return odszyfrowany tekst
     */
    public String decrypt(String text) {
        //sprawdzamy, czy tekst jest poprawny
        if (!alphabet.isTextValid(text)) {
            throw new IllegalArgumentException("Tekst zawiera znaki spoza alfabetu.");
        }        
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<text.length(); ++i) {
            
            //odczytujemy kod i-tego znaku
            char ch = text.charAt(i);
            
            int idx = alphabet.indexOf(ch);
            
            //jedyna różnica między encrypt() a decrypt() to znak przed offset
            idx = (idx - offset) % alphabet.length();
            
            //jeżeli w wyniku przesunięcia wejdziemy na indeksy ujemne,
            //musimy przejść na koniec alfabetu
            if (idx < 0) {
                idx = idx + alphabet.length();
            }
            
            ch = alphabet.charAt(idx);
            
            sb.append((char)ch);
        }
        
        return sb.toString();
    }

    
}
