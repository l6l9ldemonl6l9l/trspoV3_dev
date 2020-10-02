package distributedsystems.story.services.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@EnableAutoConfiguration
@Table(name = "terrain")
@Entity
public class Terrain {

    @Id
    private UUID id;
    private String name;
    private int sizeBeauty;

    public Terrain() {
    }

    public Terrain(String name, int sizeBeauty) {
        this.name = name;
        this.sizeBeauty = sizeBeauty;
        this.id = UUID.randomUUID();
        System.out.println("ке2\n");
    }

    public void showInformationAboutTerrain() {
        System.out.print("Месность :" + name + ". Красота:");

        if (sizeBeauty < 20) {
            System.out.println(" ниже среднего.");
        }

        if (sizeBeauty >= 20 & sizeBeauty <= 60) {
            System.out.println(" красиво.");
        }

        if (sizeBeauty > 60) {
            System.out.println(" очень красиво.");
        }
    }
    public int getSizeBeauty(){
        return sizeBeauty;
    }

}
