package com.example.myapplication.activity.main;

import com.example.myapplication.model.Note;

import java.util.List;

public interface MainView {

    void showLoading();
    void hideLoading();
    void onGetResult(List<Note> notes);
    void onErrorLoading(String message);
}
