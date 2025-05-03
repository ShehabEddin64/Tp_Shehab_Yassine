package Filtre;

import java.nio.charset.StandardCharsets;
import java.util.Map;


public class FiltreEncryptionKey extends Filtre {

    private final String key;


    public FiltreEncryptionKey(Map<String, String> params) {

        this.key = params.getOrDefault("key", "defaultKey");
    }

    @Override
    public byte[] traiter(byte[] donnees) {
        if (donnees == null || donnees.length == 0 || key == null || key.isEmpty()) {
            return donnees;
        }

        // Convertir la clé en tableau d'octets
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);

        // Créer un tableau pour le résultat
        byte[] resultat = new byte[donnees.length];

        // Appliquer le XOR octet par octet
        for (int i = 0; i < donnees.length; i++) {
            // Prendre le bon octet de la clé (en bouclant si nécessaire)
            byte keyByte = keyBytes[i % keyBytes.length];
            // XOR entre l'octet des données et l'octet de la clé
            resultat[i] = (byte) (donnees[i] ^ keyByte);
        }

        return resultat;
    }


}