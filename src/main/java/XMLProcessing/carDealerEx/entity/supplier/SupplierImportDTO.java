package XMLProcessing.carDealerEx.entity.supplier;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierImportDTO {

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "is-importer")
    private boolean isImporter;

    public SupplierImportDTO(){}

    public SupplierImportDTO(String name, boolean isImporter){
        this.name = name;
        this.isImporter = isImporter;
    }

    public String getName() {
        return name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
