package com.config.service;

import com.config.model.ConfigEmail;

import java.util.List;

public interface IConfigEmailService {
        List<ConfigEmail> getList();
        void save(ConfigEmail configEmail);
        ConfigEmail findById(int id);
}
