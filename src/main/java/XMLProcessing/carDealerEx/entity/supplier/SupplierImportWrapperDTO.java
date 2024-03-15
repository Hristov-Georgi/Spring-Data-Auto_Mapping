package XMLProcessing.carDealerEx.entity.supplier;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierImportWrapperDTO implements Serializable {

    @XmlElement(name = "supplier")
    private List<SupplierImportDTO> suppliers;

    public SupplierImportWrapperDTO(){}

    public SupplierImportWrapperDTO(List<SupplierImportDTO> suppliers){
        this.suppliers = suppliers;
    }

    public void setSuppliers(List<SupplierImportDTO> suppliers) {
        this.suppliers = suppliers;
    }

    public List<SupplierImportDTO> getSuppliers() {
        return suppliers;
    }
}
