package africa.semicolon.recycle_bin.data.repositories;

import africa.semicolon.recycle_bin.data.models.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EntryRepository extends MongoRepository<Entry,String> {



    boolean existsByTitle(String title);

    Optional<Entry> findByTitle(String title);

}
