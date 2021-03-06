package africa.semicolon.recycle_bin.service;

import africa.semicolon.recycle_bin.data.repositories.RecycleBinRepository;
import africa.semicolon.recycle_bin.dto.request.CreateEntryRequest;
import africa.semicolon.recycle_bin.dto.responses.CreateEntryResponse;
import africa.semicolon.recycle_bin.dto.request.DeleteEntryRequest;
import africa.semicolon.recycle_bin.dto.responses.DeleteEntryResponse;
import africa.semicolon.recycle_bin.data.models.Entry;
import africa.semicolon.recycle_bin.data.models.RecycleBin;
import africa.semicolon.recycle_bin.data.repositories.EntryRepository;
import africa.semicolon.recycle_bin.exceptions.DuplicateRequestExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class EntryServiceImpl implements EntryService{

    @Autowired
    private EntryRepository entryRepository;
    @Autowired
    private RecycleBinService recycleBinService;
    @Autowired
    private RecycleBinRepository recycleBinRepository;
<<<<<<< HEAD:src/main/java/africa/semicolon/recycle_bin/service/EntryServiceImpl.java
    private int idCount;
=======
>>>>>>> origin/main:src/main/java/africa/semicolon/recycle_bin/service/EntryImplementation.java


    @Override
    public CreateEntryResponse createEntry(CreateEntryRequest request) {
       if(entryRepository.existsByTitle(request.getTitle())) throw new DuplicateRequestExceptions(request.getTitle()+"Already exist!!!");
       Entry entry = new Entry();
       entry.setTitle(request.getTitle());
       entry.setBody(request.getBody());
       Entry savedUser = entryRepository.save(entry);

       CreateEntryResponse response = new CreateEntryResponse();
       response.setTitle(request.getTitle());
       response.setMessage("Entry with "+response.getTitle()+" title has been successfully created!!");
       response.setTheDate(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy,  hh:mm, a").format(savedUser.getDateCreated()));
       return response;
    }

    @Override
    public DeleteEntryResponse deleteEntry(DeleteEntryRequest request) {
        Optional <Entry> foundEntry= entryRepository.findByTitle(request.getTitle());
        if(foundEntry.isEmpty()) throw new NullPointerException("Entry cannot be found");
        Entry entry = foundEntry.get();
<<<<<<< HEAD:src/main/java/africa/semicolon/recycle_bin/service/EntryServiceImpl.java
        Entry savedEntry = recycleBinService.saveEntry(entry);
        entryRepository.delete(entry);

        RecycleBin recycledEntry = new RecycleBin();
        recycledEntry.setTitle(request.getTitle());
        recycledEntry.setId(String.valueOf(idCount));
        idCount++;
=======
        Entry deletedEntry = entryRepository.deleteEntry(entry);
        Entry savedEntry = recycleBinService.saveEntry(deletedEntry);

        RecycleBin recycledEntry = new RecycleBin();
        recycledEntry.setTitle(request.getTitle());
>>>>>>> origin/main:src/main/java/africa/semicolon/recycle_bin/service/EntryImplementation.java

         DeleteEntryResponse response = new DeleteEntryResponse();
         response.setMessage(savedEntry.getTitle()+"has been successfully deleted");
         return response;



    }

    @Override
    public List<Entry> getAllEntries() {
        return entryRepository.findAll();
    }
}
