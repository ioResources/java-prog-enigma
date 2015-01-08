package enigma;

/**
 * Klasa odpowiedzialna za szyfrowanie.
 * 
 */
public class Cipher {

    /*
     * "Tablica" znaków alfabetu
     */
    private String alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
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
       
    /**
     * Metoda szyfruje przekazany tekst.
     * 
     * @param text tekst do zaszyfrowania
     * @return zaszyfrowany tekst
     */
    public String encrypt(String text) {
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<text.length(); ++i) {
            
            //odczytujemy kod i-tego znaku
            int ch = text.charAt(i);
            
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
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<text.length(); ++i) {
            
            //odczytujemy kod i-tego znaku
            int ch = text.charAt(i);
            
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
