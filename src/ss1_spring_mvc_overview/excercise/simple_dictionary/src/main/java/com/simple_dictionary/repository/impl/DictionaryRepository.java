package com.simple_dictionary.repository.impl;

import com.simple_dictionary.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    static Map<String, String> dictionary = new HashMap<>();
    static {
     dictionary.put("hello", "xin chao");
     dictionary.put("cut", "cắt");
     dictionary.put("copy", "sao chép");
    }
    @Override
    public String findVocabulary(String vocabulary) {
        String str = "Khong tim thay";
        if (dictionary.get(vocabulary) != null) {
            str = dictionary.get(vocabulary);
        }
        return str;
    }
}
