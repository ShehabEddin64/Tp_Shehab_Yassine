package Filtre;

import java.util.Map;
public class FiltreBitwiseNot extends Filtre {

    public FiltreBitwiseNot(Map<String, String> params) {}


    @Override
    public byte[] traiter(byte[] donnees) {
        if (donnees == null || donnees.length == 0) {
            return donnees;
        }


        byte[] resultat = new byte[donnees.length];

        // Appliquer le NOT bit-à-bit sur chaque octet
        for (int i = 0; i < donnees.length; i++) {

            resultat[i] = (byte) ~donnees[i];
        }

        return resultat;
    }


}