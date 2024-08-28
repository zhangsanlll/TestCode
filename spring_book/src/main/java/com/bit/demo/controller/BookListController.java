package com.bit.demo.controller;

import com.bit.demo.model.*;
import com.bit.demo.service.BookService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Slf4j
//目的是获取图书列表
@RestController
@RequestMapping("/book")
public class BookListController {
    @Autowired
    private BookService bookService;


    @RequestMapping("/getList")
    public List<BookInfo> getList(){
        //获取数据
        List<BookInfo> books = bookService.getBookList();
        return books;
    }


    @RequestMapping("/addBook")
    public String addBook(BookInfo bookInfo){
        log.info("添加图书：{}",bookInfo);
        if(!StringUtils.hasLength(bookInfo.getBookName())||
                !StringUtils.hasLength(bookInfo.getAuthor())||
                bookInfo.getCount() == null||
                bookInfo.getPrice() == null||
                !StringUtils.hasLength(bookInfo.getPublish())||
                bookInfo.getStatus() == null
        ){
            return "输入参数不合法，请检查参数！";
        }
        try{
            bookService.addBook(bookInfo);
            return "";
        }catch (Exception e){
            log.error("添加图书失败",e);
            return e.getMessage();
        }
    }

    @RequestMapping("/getListByPage")
    public Result getListByPage(PageRequest pageRequest, HttpSession session){
        log.info("获取图书列表，pageRequest:{}",pageRequest);
        /*//判断用户是否登录
        if(session.getAttribute(Constants.SESSION_USER_KEY) == null){
            return Result.unlogin();
        }
        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);
        if(userInfo == null || userInfo.getId() < 0 || "".equals(userInfo.getUserName())){
            return Result.unlogin();
        }*/
        //用户登录，返回图书列表
        PageResult<BookInfo> pageResult = bookService.getBookListByPage(pageRequest);
        log.info("获取图书列表222，pageRequest:{}",pageRequest);
        return Result.success(pageResult);

    }

    @RequestMapping("/selectBookById")

    public BookInfo selectBookById(Integer bookId){
        //如果id不合法，则直接新创建一个图书属性并添加相关信息
        if(bookId == null && bookId <= 0){
            return new BookInfo();
        }
        BookInfo bookInfo = bookService.selectBookById(bookId);
        return bookInfo;
    }

    @RequestMapping("/updateBook")
    public String updateBook(BookInfo bookInfo){
        log.info("修改图书：{}",bookInfo);
        try{
            bookService.updateBook(bookInfo);
            return "";
        }catch (Exception e){
            log.error("修改图书失败",e);
            return e.getMessage();
        }
    }

    /**
     * s删除图书，也可以直接用updateBook的逻辑
     * */
    @RequestMapping("/deleteBook")
    public Boolean deleteBook(Integer bookId){
        log.info("删除图书，bookId:{}",bookId);
        Integer result = bookService.deleteBook(bookId);
        if(result > 0){
            return true;
        }
        return false;
    }

    /**
     * 批量删除图书
     * @RequestParam绑定数组
     * */
    @RequestMapping("/deleteAllBook")
    public boolean deleteAllBook(@RequestParam List<Integer> ids){
        log.info("批量删除图书：ids{}",ids);
        try{
            bookService.deleteAllBook(ids);
        }catch (Exception e){
            log.error("批量删除异常，e",e);
            return false;
        }
        return true;
    }
}
