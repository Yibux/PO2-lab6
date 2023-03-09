public class WektoryRoznejDlugosciException extends Exception{
    public WektoryRoznejDlugosciException(int size1, int size2) {
        super("Długości wektorów są różne. Wektor 1: " + size1 + ", Wektor 2: " + size2 + ".");
    }
}
