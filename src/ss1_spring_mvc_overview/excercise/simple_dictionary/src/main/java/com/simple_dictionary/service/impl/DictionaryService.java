package com.simple_dictionary.service.impl;

import com.simple_dictionary.repository.IDictionaryRepository;
import com.simple_dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    IDictionaryRepository dictionaryRepository;
    @Override
    public String findVocabulary(String vocabulary) {
       return dictionaryRepository.findVocabulary(vocabulary);
    }
}
