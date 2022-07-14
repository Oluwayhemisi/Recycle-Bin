package africa.semicolon.recycle_bin.service;

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
import java.util.Optional;

@Service
public class EntryImplementation implements EntryService{

    @Autowired
    private EntryRepository entryRepository;
    @Autowired
    private RecycleBinService recycleBinService;


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
        entryRepository.delete(entry);

        RecycleBin recycledEntry = new RecycleBin();
        recycledEntry.setTitle(request.getTitle());

         Entry savedEntry = recycleBinService.saveEntry(entry);
         RecycleBin savedRecycledEntry = recycleBinService.saveRecycle(recycledEntry);
         entry.getEntries().add(savedRecycledEntry);
         recycleBinService.deleteEntry(savedEntry);


         DeleteEntryResponse response = new DeleteEntryResponse();
         response.setTitle(savedRecycledEntry.getTitle());
         response.setMessage(savedRecycledEntry.getTitle()+"has been successfully deleted");
         return response;



    }
}
