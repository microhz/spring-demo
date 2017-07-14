package com.xiaoyulaoshishuo.app.kq.mapper;

import com.xiaoyulaoshishuo.app.kq.model.UserAccount;
import com.xiaoyulaoshishuo.app.kq.model.UserAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAccountMapper {
    int countByExample(UserAccountExample example);

    int deleteByExample(UserAccountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserAccount record);

    int insertSelective(UserAccount record);

    List<UserAccount> selectByExample(UserAccountExample example);

    UserAccount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserAccount record, @Param("example") UserAccountExample example);

    int updateByExample(@Param("record") UserAccount record, @Param("example") UserAccountExample example);

    int updateByPrimaryKeySelective(UserAccount record);

    int updateByPrimaryKey(UserAccount record);
}