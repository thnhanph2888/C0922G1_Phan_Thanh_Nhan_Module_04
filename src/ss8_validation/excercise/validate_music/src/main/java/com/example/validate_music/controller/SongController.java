package com.example.validate_music.controller;

import com.example.validate_music.dto.SongDto;
import com.example.validate_music.model.Song;
import com.example.validate_music.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/showAdd")
    public String showAdd(Model model){
        model.addAttribute("songDto", new SongDto());
        return"add";
    }

    @PostMapping("/save")
    public String addOrUpdate(@Validated SongDto songDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("songDto", songDto);
            return "add";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.addOrUpdate(song);
        return "redirect:/";
    }
}
