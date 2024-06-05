package net.ozonex.journalApp.controller;

import net.ozonex.journalApp.entity.JournalEntry;
import net.ozonex.journalApp.service.JournalEntryServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerv2 {

    @Autowired
    private JournalEntryServices journalEntryServices;

    @GetMapping
    public List<JournalEntry> getAlL(){
        return journalEntryServices.getAll();
    }
    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalEntryServices.saveEntry(myEntry);
        return myEntry;
    }
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId){
        return journalEntryServices.findById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId myId){
        journalEntryServices.deleteById(myId);
        return true;

    }

    @PutMapping("id/{id}")
    public JournalEntry UpdaterJournalEntryById(@PathVariable ObjectId id,@RequestBody JournalEntry newEntry ){
        JournalEntry old = journalEntryServices.findById(id).orElse(null);
        if(old != null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("")? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent()!= null && !newEntry.getContent().equals("")? newEntry.getContent() : old.getContent());
        }
        journalEntryServices.saveEntry(old);
        return old;
    }
}
