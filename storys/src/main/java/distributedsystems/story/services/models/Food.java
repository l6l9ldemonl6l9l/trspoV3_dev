package distributedsystems.story.services.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@EnableAutoConfiguration
@Table(name = "food")
@Entity
public class Food {

    @Id
    @GeneratedValue
    private UUID id;
    private int taste;
    private String kindFood;
    @GeneratedValue
    private Date birthday;


    public Food(int taste, String kindFood) {
        this.taste = taste;
        this.kindFood = kindFood;
        this.birthday = new Date();
        this.id = UUID.randomUUID();
    }

    public Food() {

    }

    public void showInformationAboutFood() {
        System.out.println("Еда : " + kindFood + ". Дата создания: " + birthday + ". Вкус: " + taste + ".\n");
    }

    public UUID getId() {
        return id;
    }

    public int getTaste() {
        return taste;
    }

}
