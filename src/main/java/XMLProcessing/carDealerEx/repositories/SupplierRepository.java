package XMLProcessing.carDealerEx.repositories;

import XMLProcessing.carDealerEx.entity.supplier.Supplier;
import XMLProcessing.carDealerEx.entity.supplier.SupplierExportDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    @Query("SELECT new XMLProcessing.carDealerEx.entity.supplier.SupplierExportDTO(" +
            " s.id AS id, s.name AS name, SIZE(s.parts) AS partsCount)" +
            " FROM Supplier s" +
            " WHERE s.importer = false" +
            " ORDER BY partsCount DESC")
    List<SupplierExportDTO> findByImporterFalse();

}
