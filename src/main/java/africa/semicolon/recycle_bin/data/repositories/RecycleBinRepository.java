package africa.semicolon.recycle_bin.data.repositories;

import africa.semicolon.recycle_bin.data.models.RecycleBin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecycleBinRepository extends MongoRepository<RecycleBin, String> {
}
