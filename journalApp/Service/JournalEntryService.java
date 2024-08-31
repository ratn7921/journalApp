package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    // Save or update a journal entry
    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }
 public List<JournalEntry>getAll(){
        return journalEntryRepository.findAll();
 }
 public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
 }
public void  deleteById(ObjectId id){
        journalEntryRepository.deleteById(id);
}
//
//    // Find all journal entries
//    public List<JournalEntry> findAll() {
//        return journalEntryRepository.findAll();
//    }
//
//    // Find a journal entry by ID
//    public JournalEntry findById(Long myId) {
//        Optional<JournalEntry> entry = journalEntryRepository.findById(myId);
//        return entry.orElse(null);
//    }
//
//    // Delete a journal entry by ID
//    public void deleteById(Long myId) {
//        journalEntryRepository.deleteById(String.valueOf(myId));
//    }
}
