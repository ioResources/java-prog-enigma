package enigma;

/**
 * Abstrakcyjna klasa odpowiedzialna za szyfrowanie.
 * 
 */
public abstract class Cipher {
    
    /*
     * Pole klucza (key) i metody dostępowe.
     */
    protected int key;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
       
    /*
     * Pole alphabet
     */
    protected final Alphabet alphabet;
    
    /**
     * Konstruktor przyjmujący obiekt alfabetu.
     * 
     * @param alphabet 
     */
    public Cipher(Alphabet alphabet) {
        this.alphabet = alphabet;
    }
    
    
    /*
     * Abstrakcyjne metody szyfrujące/deszyfrujące
     */
    public abstract String encrypt(String text);
    public abstract String decrypt(String text);
    
    /**
     * Chroniona (protected) metoda przetwarzająca szyfrowany tekst.
     * 
     * Jest odpowiedzialna za przejście po całym tekście znak po znaku.
     * Przetwarzanie pojedynczego znaku jest zlecane za pośrednictwem metody
     * process() obiektowi implementującemu interfejs CharProc.
     * 
     * @param text
     * @param cp
     * @return 
     */
    protected String doJob(String text, CharProc cp) {
        //sprawdzamy, czy tekst jest poprawny
        if (!alphabet.isTextValid(text)) {
            throw new IllegalArgumentException("Tekst zawiera znaki spoza alfabetu.");
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<text.length(); ++i) {
            
            //odczytujemy kod i-tego znaku
            char ch = text.charAt(i);

            //zlecamy przetworzenie znaku obiektowi CharProc
            ch = cp.process(ch, key, alphabet);
                      
            //dołączamy znak do łańcucha wyjściowego
            sb.append((char)ch);
        }
        
        return sb.toString();
    }
    
}
