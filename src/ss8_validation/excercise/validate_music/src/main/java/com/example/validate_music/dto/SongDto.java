package com.example.validate_music.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {
    private int id;
    @NotBlank(message = "tên bài hát không được để trống")
    @Size(max = 800, message = "không dược quá 800 kí tự")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "tên bài hát không được chứa kí tự đặc biệt!")
    private String name;
    @NotBlank(message = "tên nghệ sĩ không được để trống")
    @Size(max = 300, message = "không được quá 300 kí tự")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "tên nghệ sĩ không được chứa kí tự đặc biệt!")
    private String artist;
    @NotBlank(message = "tên thể loại không được để trống")
    @Size(max = 1000, message = "không được quá 1000 kí tự")
    @Pattern(regexp = "^[A-Za-z0-9, ]+$", message = "tên thể loại không được chứa kí tự đặc biệt ngoại từ dấu \",\"!")
    private String genre;

    public SongDto() {
    }

    public SongDto(int id, String name, String artist, String genre) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}


