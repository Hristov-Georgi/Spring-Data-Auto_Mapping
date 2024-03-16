package XMLProcessing.carDealerEx.entity.supplier;

import jakarta.xml.bind.annotation.*;

import java.io.Serializable;


@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierExportDTO implements Serializable {

    @XmlAttribute(name = "id")
    private int id;

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "parts-count")
    private int partsCount;

    public SupplierExportDTO(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }


}
