package isfaaghyth.app.dilomakassar.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by isfaaghyth on 28/1/17.
 */

public class PlanetModel {

    @SerializedName("planet")
    List<Planet> planets;

    public List<Planet> getPlanets() {
        return planets;
    }

    public class Planet {
        @SerializedName("planet_name")
        private String planetName;

        @SerializedName("description")
        private String description;

        public String getPlanetName() {
            return planetName;
        }

        public String getDescription() {
            return description;
        }
    }

}
