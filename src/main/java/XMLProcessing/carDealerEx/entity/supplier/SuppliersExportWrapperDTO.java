package XMLProcessing.carDealerEx.entity.supplier;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SuppliersExportWrapperDTO implements Serializable {

    @XmlElement(name = "supplier")
    private List<SupplierExportDTO> suppliers;

    public SuppliersExportWrapperDTO(){}

    public SuppliersExportWrapperDTO(List<SupplierExportDTO> suppliers) {
        this.suppliers = suppliers;
    }

}
