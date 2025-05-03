package Filtre;
import java.util.Map;
public class FiltreMajusculeMinuscule extends Filtre {

    public FiltreMajusculeMinuscule(Map<String, String> parametres) {

    }


    @Override
    public String traiter(String texte) {
        if (texte == null || texte.isEmpty()) {
            return texte;
        }

        StringBuilder resultat = new StringBuilder();

        for (char c : texte.toCharArray()) {
            if (Character.isUpperCase(c)) {
                // Convertir majuscule en minuscule
                resultat.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                // Convertir minuscule en majuscule
                resultat.append(Character.toUpperCase(c));
            } else if (Character.isDigit(c)) {
                // Inverser les chiffres [0=>9, 1=>8, ...]
                resultat.append(inverserChiffre(c));
            } else {
                // Garder les autres caractères inchangés
                resultat.append(c);
            }
        }

        return resultat.toString();
    }


    private char inverserChiffre(char chiffre) {
        if (!Character.isDigit(chiffre)) {
            return chiffre;
        }

        int valeur = Character.getNumericValue(chiffre);
        int inverse = 9 - valeur;

        return Character.forDigit(inverse, 10);
    }


}
