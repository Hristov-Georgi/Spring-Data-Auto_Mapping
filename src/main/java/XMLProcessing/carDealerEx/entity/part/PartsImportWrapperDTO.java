package XMLProcessing.carDealerEx.entity.part;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartsImportWrapperDTO {

    @XmlElement(name = "part")
    private List<PartsImportDTO> parts;

    public PartsImportWrapperDTO(){}

    public List<PartsImportDTO> getParts() {
        return parts;
    }
}
