package com.config.service.ipml;

import com.config.model.ConfigEmail;
import com.config.repository.impl.ConfigRepository;
import com.config.service.IConfigEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigEmailService implements IConfigEmailService {

    @Autowired
    ConfigRepository configRepository;

    @Override
    public List<ConfigEmail> getList() {
        return configRepository.getList();
    }

    @Override
    public void Save(ConfigEmail configEmail) {
       configRepository.Save(configEmail);
    }

    @Override
    public ConfigEmail findById(int id) {
        return configRepository.findById(id);
    }
}
