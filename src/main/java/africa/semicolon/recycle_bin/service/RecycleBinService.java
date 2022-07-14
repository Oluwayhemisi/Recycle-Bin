package africa.semicolon.recycle_bin.service;

import africa.semicolon.recycle_bin.data.models.Entry;
import africa.semicolon.recycle_bin.data.models.RecycleBin;

public interface RecycleBinService {


    void deleteEntry(Entry Entry);

    Entry saveEntry(Entry entry);

    RecycleBin saveRecycle(RecycleBin recycledEntry);
}

