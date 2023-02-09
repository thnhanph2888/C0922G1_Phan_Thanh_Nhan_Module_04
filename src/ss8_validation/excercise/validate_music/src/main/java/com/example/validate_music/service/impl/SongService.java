package com.example.validate_music.service.impl;

import com.example.validate_music.model.Song;
import com.example.validate_music.repository.ISongRepository;
import com.example.validate_music.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository songRepository;
    @Override
    public boolean addOrUpdate(Song song) {
        try {
            songRepository.save(song);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
