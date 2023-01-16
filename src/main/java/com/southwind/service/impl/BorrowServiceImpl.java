package com.southwind.service.impl;

import com.southwind.entity.Borrow;
import com.southwind.repository.BorrowRepository;
import com.southwind.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    @Override
    public int addBorrow(Borrow borrow) {
        return borrowRepository.addBorrow(borrow);
    }

    @Override
    public Borrow queryRecord(String bookName, int readerId) {
        return borrowRepository.queryRecord(bookName, readerId);
    }

    @Override
    public List<Borrow> queryRecordsByReaderId(int readerId) {
        return borrowRepository.queryRecordsByReaderId(readerId);
    }

    @Override
    public Borrow queryRecordByOrderNum(String orderNum) {
        return borrowRepository.queryRecordByOrderNum(orderNum);
    }

    @Override
    public int deleteByOrderNum(String orderNum) {
        return borrowRepository.deleteByOrderNum(orderNum);
    }
}
