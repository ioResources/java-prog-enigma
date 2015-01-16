package enigma;

/**
 * Klasa rozszerzająca klasę Cipher zawiera implementację szyfrowania
 * metodą Cezara.
 */
public class CipherCaesar extends Cipher {

    public CipherCaesar(Alphabet alphabet) {
        super(alphabet);
    }
    
    /**
     * Metoda szyfruje przekazany tekst.
     * 
     * @param text tekst do zaszyfrowania
     * @return zaszyfrowany tekst
     */
    @Override
    public String encrypt(String text) {
        /*
         Metoda zwraca to, co dostanie od metody doJob(), której - poza
         tekstem do zaszyfrowania - przekazujemy obiekt implementujący
         interfejs CharProc, który odpowiada za szyfrowanie pojedynczego znaku.
        
         Korzystamy tu z klasy anonimowej, czyli nie definiujemy jawnie klasy
         (i jej nie nazywamy), tylko tworzymy "w locie" w oparciu o interfejs.
        */
        return doJob(text, new CharProc() { 

            @Override
            public char process(char ch, int key, Alphabet alphabet) {
                //pobieramy indeks znaku w alfabecie
                int idx = alphabet.indexOf(ch);


                //przesuwamy się w alfabecie o offset
                idx = (idx + key) % alphabet.length();

                //jeżeli w wyniku przesunięcia wejdziemy na indeksy ujemne,
                //musimy przejść na koniec alfabetu
                if (idx < 0) {
                    idx = idx + alphabet.length();
                }

                //odczytujemy znak z przesuniętego indeksu
                ch = alphabet.charAt(idx);
                
                return ch;
            }
        });
    }

    /**
     * Metoda odszyfrowująca przekazany tekst.
     * 
     * Działa tak samo jak metoda encrypt().
     * Opis zastosowanego tu mechanizmu został opisany w metodzie encrypt().
     * 
     * @param text zaszyfrowany tekst
     * @return odszyfrowany tekst
     */
    @Override
    public String decrypt(String text) {
        
        return doJob(text, new CharProc() {
           
            @Override
            public char process(char ch, int key, Alphabet alphabet) {
                //pobieramy indeks znaku w alfabecie
                int idx = alphabet.indexOf(ch);


                //przesuwamy się w alfabecie o offset
                idx = (idx - key) % alphabet.length();

                //jeżeli w wyniku przesunięcia wejdziemy na indeksy ujemne,
                //musimy przejść na koniec alfabetu
                if (idx < 0) {
                    idx = idx + alphabet.length();
                }

                //odczytujemy znak z przesuniętego indeksu
                ch = alphabet.charAt(idx);
            
                return ch;
            }
        });
    }

}
