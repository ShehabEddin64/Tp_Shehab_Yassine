

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import Filtre.*;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class Configuration {
    private List<FiltreDefinition> filtres;


    public Configuration() {
        this.filtres = new ArrayList<>();
    }

    public void chargerFichier(String Fichier) throws IOException {
        try (FileReader reader = new FileReader(Fichier)) {

            Gson gson = new Gson();


            Type configType = new TypeToken<Map<String, List<FiltreDefinition>>>() {}.getType();


            Map<String, List<FiltreDefinition>> configMap = gson.fromJson(reader, configType);

            if (configMap != null && configMap.containsKey("filters")) {
                this.filtres = configMap.get("filters");
            } else {
                this.filtres = new ArrayList<>();
                System.err.println("Aucun filtre trouvé dans le fichier de configuration.");
            }
        }
    }

    public List<FiltreDefinition> getFiltreDefinitions() {
        return filtres;
    }


    public List<Filtre> creerFiltres() {
        List<Filtre> filtresInstancies = new ArrayList<>();

        for (FiltreDefinition def : filtres) {
            Filtre filtre = instancierFiltre(def);
            if (filtre != null) {
                filtresInstancies.add(filtre);
                System.out.println("Filtre ajouté: " + def.getType());
            }
        }

        return filtresInstancies;
    }


    private Filtre instancierFiltre(FiltreDefinition def) {
        if (def == null || def.getType() == null) {
            return null;
        }

        Map<String, String> params = def.getParams();

        // Créer le filtre en fonction de son type
        switch (def.getType()) {
            case "FiltreMajusculeMinuscule":
                return new FiltreMajusculeMinuscule(params);
            case "FiltreCryptageAtbash":
                return new FiltreCryptageAtbash(params);
            case "FiltreEncryptionKey":
                return new FiltreEncryptionKey(params);
            case "FiltreBitwiseNot":
                return new FiltreBitwiseNot(params);
            default:
                System.err.printf("Erreur lors de l'instanciation du filtre %s : filtre inconnu.%n", def.getType());
                return null;
        }
    }
}
