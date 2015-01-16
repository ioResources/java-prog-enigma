package enigma;

/**
 * CharProc służy do zdefiniowania interfejsu obiektów przetwarzających
 * pojedyncze znaki.
 * 
 * Obiekty implementujące ten interfejs są tworzone w konkretnych klasach
 * szyfrujących (np. CipherCaesar).
 */
public interface CharProc {
    public char process(char ch, int key, Alphabet alphabet);
}
