package africa.semicolon.recycle_bin.service;

import africa.semicolon.recycle_bin.data.models.Entry;
import africa.semicolon.recycle_bin.data.repositories.EntryRepository;
import africa.semicolon.recycle_bin.data.repositories.RecycleBinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecycleBinServiceImpl implements RecycleBinService{

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private RecycleBinRepository recycleBinRepository;

    @Override
    public void deleteEntry(Entry entry) {
         entryRepository.delete(entry);
    }

    @Override
    public Entry saveEntry(Entry entry) {
        return entryRepository.save(entry);
    }
}
