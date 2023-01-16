package com.southwind.service;

import com.southwind.entity.Reader;

public interface ReaderService {

    Reader getReader(String password, String username);

}
