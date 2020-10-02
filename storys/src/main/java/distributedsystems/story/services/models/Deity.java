package distributedsystems.story.services.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@EnableAutoConfiguration
@Table(name = "deity")
@Entity
public class Deity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private Date age;

    public Deity() {
    }

    public Deity(String name, Date age) {
        this.name = name;
        this.age = age;
        this.id = UUID.randomUUID();
    }

    public void showInformationAboutAuthor() {
        System.out.println("Автор:" + name + ". Дата рождения:" + age + ".\n");
    }

}
