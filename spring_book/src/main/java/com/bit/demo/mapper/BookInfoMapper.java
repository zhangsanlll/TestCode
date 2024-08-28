package com.bit.demo.mapper;

import com.bit.demo.model.BookInfo;
import com.bit.demo.model.PageRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Mapper
public interface BookInfoMapper {
    @Insert("insert into book_info(book_name,author,count,price,publish,status)" +
            "values (#{bookName},#{author},#{count},#{price},#{publish},#{status})")
    Integer insertBook(BookInfo bookInfo);

    @Select("select count(1) from book_info where status != 0")
    Integer count();

    @Select("select * from book_info where status != 0 order by id desc limit #{offset},#{pageSize}")
    List<BookInfo> selectBookListByPage(PageRequest pageRequest);

    @Select("select id,book_name,author,count,price,publish,`status`,create_time,update_time " +
            "from book_info where id = #{bookId} and status != 0")
    BookInfo selectBookById(Integer bookId);


    //使用xml的方式实现更新逻辑，注解和xml的方式可以共存
    Integer updateBook(BookInfo bookInfo);

    void deleteAllBook(List<Integer> ids);
}
