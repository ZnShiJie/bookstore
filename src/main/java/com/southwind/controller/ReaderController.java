package com.southwind.controller;

//import com.alibaba.fastjson.JSON;
import com.southwind.entity.Book;
import com.southwind.entity.Borrow;
import com.southwind.entity.Reader;
import com.southwind.repository.BorrowRepository;
import com.southwind.service.BookService;
import com.southwind.service.BorrowService;
import com.southwind.utils.AutoCreateNumber;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowService borrowService;


    @RequestMapping("/borrowBook/{bookID}")
    public String borrowBook(@PathVariable("bookID")int id, HttpServletRequest request) {

        Book book = bookService.queryBookById(id);
        Reader reader = (Reader) request.getSession().getAttribute("reader");

        Borrow record = borrowService.queryRecord(book.getBookName(), reader.getId());

        if (record != null) {
            request.setAttribute("error_msg", "您已经借过此书");
            return "forward:/reader/allBookReader";
        }

        Integer readerId = reader.getId();
        Borrow borrow = new Borrow();
        borrow.setOrderNumber(AutoCreateNumber.createOrderNumber());
        borrow.setReaderId(readerId);
        borrow.setBookName(book.getBookName());
        borrow.setBookID(book.getBookID());

        Date date = new Date();
        long currentTime = date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String borrowTime = sdf.format(currentTime);

        Calendar calendar = Calendar.getInstance();
        int dates = calendar.get(Calendar.DAY_OF_YEAR) + 14;
        calendar.set(Calendar.DAY_OF_YEAR, dates);
        Date rTime = calendar.getTime();
//        currentTime = currentTime + 14 * 24 * 60 * 60;
        String returnTime = sdf.format(rTime.getTime());
        borrow.setBorrowDate(borrowTime);
        borrow.setReturnDate(returnTime);

        borrowService.addBorrow(borrow);

        // 当成功借书后，库存应该减一
        int counts = book.getBookCounts();
        counts = counts - 1;
        bookService.updateBookCounts(counts, book.getBookID());

        return "redirect:/reader/allBookReader";
    }

    @RequestMapping("/borrowBookListReader")
    public ModelAndView borrowList(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        Reader reader = (Reader)request.getSession().getAttribute("reader");
        Integer readerId = reader.getId();
        mav.setViewName("borrowList");
        List<Borrow> borrows = borrowService.queryRecordsByReaderId(readerId);
//        System.out.println("\n\n\n\n\n\n" + borrows + "\n\n\n\n\n");
        mav.addObject("list", borrows);
        return mav;
    }


    @RequestMapping("/allBookReader")
    public ModelAndView queryAllBookReader(HttpServletRequest request) {
        //System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n"+request.getSession().getAttribute("user"));
        ModelAndView mav = new ModelAndView();
        mav.setViewName("allBookReader");
        mav.addObject("list", bookService.queryAllBooks());
        return mav;
    }

    @RequestMapping("/queryBook")
    public ModelAndView queryBook(String queryBookName) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("allBookReader");
        mav.addObject("list", bookService.queryBookByName(queryBookName));
        return mav;
    }

    @RequestMapping("/returnBook/{orderNum}")
    public String returnBook(@PathVariable("orderNum") String orderNum, Model model) {

        Borrow borrow = borrowService.queryRecordByOrderNum(orderNum);
        Integer bookID = borrow.getBookID();

        Book book = bookService.queryBookById(bookID);
        Integer bookCounts = book.getBookCounts();
        bookCounts++;
        borrowService.deleteByOrderNum(orderNum);
        bookService.updateBookCounts(bookCounts, bookID);
        model.addAttribute("error_msg", "还书成功");


        return "forward:/reader/borrowBookListReader";
    }

//    @RequestMapping("/showDetail/{bookId}")
//    @ResponseBody
//    public String showDetail(@PathVariable int bookId) {
//        Book book = bookService.queryBookById(bookId);
//        return JSON.toJSONString(book);
//    }
}
