package XMLProcessing.carDealerEx.service;

import XMLProcessing.carDealerEx.entity.supplier.SupplierDataExportDTO;
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


}
