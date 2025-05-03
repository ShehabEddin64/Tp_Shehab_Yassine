

import java.util.HashMap;
import java.util.Map;


public class FiltreDefinition {
    private String type;
    private Map<String, String> params;

    public FiltreDefinition() {
        this.params = new HashMap<>();
    }

    public FiltreDefinition(String type, Map<String, String> params) {
        this.type = type;
        this.params = params != null ? params : new HashMap<>();
    }
    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getParams() {
        return params;
    }


    public void setParams(Map<String, String> params) {
        this.params = params != null ? params : new HashMap<>();
    }

    @Override
    public String toString() {
        return "FiltreDefinition{" +
                "type='" + type + '\'' +
                ", params=" + params +
                '}';
    }
}