package XMLProcessing.carDealerEx.repositories;

import XMLProcessing.carDealerEx.entity.supplier.Supplier;
import XMLProcessing.carDealerEx.entity.supplier.SupplierDataExportDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {


}
