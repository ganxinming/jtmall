package com.jtmall.contentService.mapper;

import com.jtmall.contentPojo.NewJitem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Badribbit
 * @create 2020/2/18 15:13
 * @Define
 * @Tutorials
 * @Opinion
 */
@Mapper
public interface GoodMapper {
    List<NewJitem> getNewsItem(int num);
}
