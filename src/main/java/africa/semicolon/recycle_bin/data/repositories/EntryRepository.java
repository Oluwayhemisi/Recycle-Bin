package africa.semicolon.recycle_bin.data.repositories;

import africa.semicolon.recycle_bin.data.models.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntryRepository extends MongoRepository<Entry,String> {

    boolean existsByTitle(String title);

    Optional<Entry> findByTitle(String title);

<<<<<<< HEAD
    void delete(Entry entry);
=======
    Entry deleteEntry(Entry entry);
>>>>>>> origin/main

}
