package africa.semicolon.recycle_bin.service;

import africa.semicolon.recycle_bin.data.models.Entry;
import africa.semicolon.recycle_bin.dto.request.CreateEntryRequest;
import africa.semicolon.recycle_bin.dto.responses.CreateEntryResponse;
import africa.semicolon.recycle_bin.dto.request.DeleteEntryRequest;
import africa.semicolon.recycle_bin.dto.responses.DeleteEntryResponse;

import java.util.List;

public interface EntryService {
    CreateEntryResponse createEntry(CreateEntryRequest request );
    DeleteEntryResponse deleteEntry(DeleteEntryRequest request );

    List<Entry> getAllEntries();
}
