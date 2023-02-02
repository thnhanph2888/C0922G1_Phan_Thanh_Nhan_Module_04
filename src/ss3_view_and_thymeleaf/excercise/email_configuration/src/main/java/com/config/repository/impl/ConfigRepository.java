package com.config.repository.impl;

import com.config.model.ConfigEmail;
import com.config.repository.IConfigRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ConfigRepository implements IConfigRepository {

    private static ConfigEmail configEmail = new ConfigEmail();
    private static List<ConfigEmail> configEmailList = new ArrayList<>();
    static {
        configEmailList.add(new ConfigEmail(1,"Japanese", 10, false, "data gia"));
        configEmailList.add(new ConfigEmail(2, "Vietnamese", 10, false, " gia"));
        configEmailList.add( new ConfigEmail(3, "English", 10, false, "data "));
    }

    @Override
    public List<ConfigEmail> getList() {
        return configEmailList;
    }
    @Override
    public void Save(ConfigEmail object) {
      for (int i = 0; i < configEmailList.size();i++) {
          if (configEmailList.get(i).getId() == object.getId()) {
              configEmailList.set(i, object);
          }
      }
    }
    @Override
    public ConfigEmail findById(int id) {
        for (ConfigEmail configEmail : configEmailList) {
            if (configEmail.getId() == id) {
                return configEmail;
            }
        }
        return new ConfigEmail();
    }
}
