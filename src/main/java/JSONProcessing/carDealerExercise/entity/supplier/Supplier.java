package JSONProcessing.carDealerExercise.entity.supplier;

import JSONProcessing.carDealerExercise.entity.part.Part;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "is_importer", nullable = false)
    private boolean importer;

    @OneToMany(targetEntity = Part.class, mappedBy = "supplier")
    private List<Part> parts;

    public Supplier() {
        this.parts = new ArrayList<>();
    }

    public Supplier(String name, boolean importer) {
        this();
        this.name = name;
        this.importer = importer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return importer;
    }

    public void setImporter(boolean importer) {
        this.importer = importer;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }


}
