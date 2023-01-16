package com.southwind.service.impl;

import com.southwind.entity.Bookcase;
import com.southwind.repository.BookcaseRepository;
import com.southwind.service.BookcaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookcaseServiceImpl implements BookcaseService {

    @Autowired
    private BookcaseRepository bookcaseRepository;

    @Override
    public Bookcase queryById(int id) {
        return bookcaseRepository.queryById(id);
    }
}
