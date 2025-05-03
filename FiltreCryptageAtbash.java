package Filtre;
import java.util.Map;

public class FiltreCryptageAtbash extends Filtre {
    public FiltreCryptageAtbash(Map<String, String> params) {

    }

    @Override
    public String traiter(String texte) {
        if (texte == null || texte.isEmpty()) {
            return texte;
        }

        StringBuilder resultat = new StringBuilder();

        for (char c : texte.toCharArray()) {
            if (Character.isUpperCase(c)) {
                // Appliquer Atbash pour les majuscules (A-Z)
                char chiffreC = (char) ('Z' - (c - 'A'));
                resultat.append(chiffreC);
            } else if (Character.isLowerCase(c)) {
                // Appliquer Atbash pour les minuscules (a-z)
                char chiffreC = (char) ('z' - (c - 'a'));
                resultat.append(chiffreC);
            } else {
                // Garder les autres caractères inchangés
                resultat.append(c);
            }
        }

        return resultat.toString();
    }


}