package com.example.todo.Database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository noteRepository;
    private LiveData<List<Note>> AllNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
        AllNotes = noteRepository.getGetAllNotes();
    }

    public void Insert(Note note){
        noteRepository.Insert(note);
    }
    public void Update(Note note){
        noteRepository.Update(note);
    }

    public void Delete(Note note){
        noteRepository.Delete(note);
    }

    public void DeleteAll(){
        noteRepository.deleteAll();
    }

    public LiveData<List<Note>> getAllNotes() {
        return AllNotes;
    }
}
