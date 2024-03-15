package JSONProcessing.carDealerExercise.service;

import JSONProcessing.carDealerExercise.entity.supplier.SupplierDataExportDTO;

import java.util.List;

public interface SupplierService {

    List<SupplierDataExportDTO> selectAllLocalSuppliers();
}
