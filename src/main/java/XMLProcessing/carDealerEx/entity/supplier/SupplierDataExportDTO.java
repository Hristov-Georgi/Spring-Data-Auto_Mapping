package XMLProcessing.carDealerEx.entity.supplier;

public class SupplierDataExportDTO {

    private int id;

    private String name;

    int partsCount;


    public SupplierDataExportDTO(int id, String name, int partsCount){
        this.id = id;
        this.name = name;
        this.partsCount = partsCount;
    }

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
