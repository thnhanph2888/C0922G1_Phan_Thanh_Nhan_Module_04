package com.config.repository;

import com.config.model.ConfigEmail;

import java.util.List;

public interface IConfigRepository {
    List<ConfigEmail> getList();
    void save(ConfigEmail configEmail);
    ConfigEmail findById(int id);
}
