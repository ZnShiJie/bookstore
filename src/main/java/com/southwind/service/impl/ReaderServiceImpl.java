package com.southwind.service.impl;

import com.southwind.entity.Reader;
import com.southwind.repository.ReaderRepository;
import com.southwind.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public Reader getReader(String password, String username) {
        return readerRepository.getReader(password, username);
    }
}
