package africa.semicolon.recycle_bin.service;

import africa.semicolon.recycle_bin.dto.request.CreateEntryRequest;
import africa.semicolon.recycle_bin.dto.responses.CreateEntryResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EntryServiceImplTest {
    @Autowired
    private EntryService entryService;
    private CreateEntryRequest createEntryRequest;
    @BeforeEach
    public void setUp(){
        createEntryRequest = new CreateEntryRequest();
        createEntryRequest.setTitle("test title");
        createEntryRequest.setBody("test body");
    }

    @Test
    public void createEntryTest(){
        //when
        //entry is saved
        CreateEntryResponse entryResponse = entryService.createEntry(createEntryRequest);
        //assert

        assertNotNull(entryResponse);
        assertEquals(1, entryService.getAllEntries().size());
        //the entry exists in the applications repo


    }

    @Test
    public void getAllEntriesTest(){
        assertEquals(0, entryService.getAllEntries().size());
        CreateEntryResponse entryResponse = entryService.createEntry(createEntryRequest);
        assertEquals(1, entryService.getAllEntries().size());
    }

}