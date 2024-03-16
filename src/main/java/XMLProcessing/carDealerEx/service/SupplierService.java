package XMLProcessing.carDealerEx.service;

import XMLProcessing.carDealerEx.entity.supplier.SuppliersExportWrapperDTO;

public interface SupplierService {

    SuppliersExportWrapperDTO selectAllNotImportParts();
}
