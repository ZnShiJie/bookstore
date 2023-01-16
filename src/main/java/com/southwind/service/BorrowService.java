package com.southwind.service;

import com.southwind.entity.Borrow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BorrowService {

    int addBorrow(Borrow borrow);

    Borrow queryRecord(String bookName, int readerId);

    List<Borrow> queryRecordsByReaderId(int readerId);

    Borrow queryRecordByOrderNum(String orderNum);

    int deleteByOrderNum(String orderNum);
}
