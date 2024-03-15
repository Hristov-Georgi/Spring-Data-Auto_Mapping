package JSONProcessing.carDealerExercise.repositories;

import JSONProcessing.carDealerExercise.entity.supplier.Supplier;
import JSONProcessing.carDealerExercise.entity.supplier.SupplierDataExportDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    @Query("SELECT new carDealerExercise.entity.supplier.SupplierDataExportDTO(s.id, s.name, SIZE(s.parts))" +
            " FROM Supplier s" +
            " WHERE s.importer = false")
    List<SupplierDataExportDTO> findByImporterFalse();
}
