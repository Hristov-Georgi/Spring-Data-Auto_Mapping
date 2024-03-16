package XMLProcessing.carDealerEx.service;


import XMLProcessing.carDealerEx.entity.supplier.SupplierExportDTO;
import XMLProcessing.carDealerEx.entity.supplier.SuppliersExportWrapperDTO;
import XMLProcessing.carDealerEx.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public SuppliersExportWrapperDTO selectAllNotImportParts() {

        List<SupplierExportDTO> supplierList = this.supplierRepository.findByImporterFalse();


        return new SuppliersExportWrapperDTO(supplierList);
    }
}
