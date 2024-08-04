package com.bit.demo.service;

import com.bit.demo.mapper.BookDao;
import com.bit.demo.mapper.BookInfoMapper;
import com.bit.demo.model.BookInfo;
import com.bit.demo.model.BookStatus;
import com.bit.demo.model.PageRequest;
import com.bit.demo.model.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
@Service
public class BookService {
    @Autowired
    private BookDao bookdao;
    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Deprecated
    //表示该接口废弃了
    public List<BookInfo> getBookList() {
        List<BookInfo> books = bookdao.mockData();
        for (BookInfo book : books) {
            if (book.getStatus() == 1) {
                book.setStatusCN("可借阅");
            } else {
                book.setStatusCN("不可借阅");
            }
        }
        return books;
    }

    //添加图书
    public void addBook(BookInfo bookInfo) {
        bookInfoMapper.insertBook(bookInfo);
    }

    //返回翻页信息
    public PageResult<BookInfo> getBookListByPage(PageRequest pageRequest) {
        Integer count = bookInfoMapper.count();
        List<BookInfo> books = bookInfoMapper.selectBookListByPage(pageRequest);
        for (BookInfo book : books) {
            book.setStatusCN(BookStatus.getNameByCode(book.getStatus()).getName());
        }
        return new PageResult<>(count, books,pageRequest);
    }

    public BookInfo selectBookById(Integer bookId) {
        return bookInfoMapper.selectBookById(bookId);
    }

    public void updateBook(BookInfo bookInfo){
        bookInfoMapper.updateBook(bookInfo);
    }

    public Integer deleteBook(Integer bookId) {
        BookInfo bookInfo = new BookInfo();
        bookInfo.setId(bookId);
        bookInfo.setStatus(0);
        return bookInfoMapper.updateBook(bookInfo);
    }

    public void deleteAllBook(List<Integer> ids) {
        bookInfoMapper.deleteAllBook(ids);
    }
}
