package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.Service.JournalEntryService;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    // Get all journal entries
    @GetMapping
    public List<JournalEntry> getAll() {
        return  journalEntryService.getAll();
    }

    // Create a new journal entry
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {
        myEntry.setDate(LocalDateTime.now());
       journalEntryService.saveEntry(myEntry);
        return true;
    }

    // Get a journal entry by ID
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId) {
     return journalEntryService.findById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId myId) {
       journalEntryService.deleteById(myId);
        return true;
    }


@PutMapping("/id/{id}")
public JournalEntry updateJournalEntryById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry) {
    JournalEntry old = journalEntryService.findById(id).orElse(null);
    if (old != null) {
        // Update title if it's not null and not empty
        if (newEntry.getTitle() != null && !newEntry.getTitle().isEmpty()) {
            old.setTitle(newEntry.getTitle());
        }
        // Update content if it's not null and not empty
        if (newEntry.getContent() != null && !newEntry.getContent().isEmpty()) {
            old.setContent(newEntry.getContent());
        }
        // Save the updated entry
        journalEntryService.saveEntry(old);
    }

    // Delete a journal entry by ID
    return old;
}
}
