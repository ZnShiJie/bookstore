package com.southwind.controller;

import com.southwind.entity.Book;
import com.southwind.entity.Bookcase;
import com.southwind.repository.BookcaseRepository;
import com.southwind.service.BookService;
import com.southwind.service.BookcaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookcaseService bookcaseService;

    /**
     * 展示所有图书
     *
     * @param request
     * @return
     */
    @RequestMapping("/allBook")
    public ModelAndView queryAllBook(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("allBook");
        mav.addObject("list", bookService.queryAllBooks());
        return mav;
    }


    /**
     * 管理员通过id来删除书
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id, Model model) {
        bookService.deleteBookById(id);
        model.addAttribute("msg", "删除成功");
        return "forward:/book/allBook";
    }

    /**
     * 跳转到书籍添加页面
     *
     * @return
     */
    @RequestMapping("/toAddBook")
    public String toAddBook() {
        return "addBook";
    }

    /**
     * 添加书籍
     *
     * @param request
     * @return
     */
    @RequestMapping("/addBook")
    public String addBook(HttpServletRequest request) {

        Book book = createBook(request);
        bookService.addBook(book);
        request.setAttribute("msg", "添加成功");
        return "forward:/book/allBook";


    }

    @RequestMapping("/toUpdateBook/{bookID}")
    public ModelAndView toUpdateBook(@PathVariable("bookID") int bookId) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("updateBook");
        mav.addObject("QBook", bookService.queryBookById(bookId));
        return mav;
    }

    @RequestMapping("/updateBook")
    public String updateBook(HttpServletRequest request) {

        Book book = createBook(request);
        book.setBookID(Integer.parseInt(request.getParameter("bookID")));
        int i = bookService.updateBook(book);

        request.setAttribute("msg", "更新成功");
        return "forward:/book/allBook";

    }

    @RequestMapping("/queryBook")
    public ModelAndView queryBook(String queryBookName) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("allBook");
        mav.addObject("list", bookService.queryBookByName(queryBookName));
        return mav;
    }


    public Book createBook(HttpServletRequest request) {
        Book book = new Book();

        book.setBookName(request.getParameter("bookName"));
        book.setBookCounts(Integer.parseInt(request.getParameter("bookCounts")));
        book.setDetail(request.getParameter("detail"));
        book.setPrice(Double.parseDouble(request.getParameter("price")));
        book.setPublisher(request.getParameter("publisher"));
        book.setAuthor(request.getParameter("author"));

        //通过bid查询书的类别
        String bid = request.getParameter("bid");
        Bookcase bookcase = bookcaseService.queryById(Integer.parseInt(bid));

        book.setBookcase(bookcase);
        return book;
    }
}
