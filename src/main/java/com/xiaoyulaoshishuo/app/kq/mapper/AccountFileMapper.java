package com.xiaoyulaoshishuo.app.kq.mapper;

import com.xiaoyulaoshishuo.app.kq.model.AccountFile;
import com.xiaoyulaoshishuo.app.kq.model.AccountFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountFileMapper {
    int countByExample(AccountFileExample example);

    int deleteByExample(AccountFileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccountFile record);

    int insertSelective(AccountFile record);

    List<AccountFile> selectByExample(AccountFileExample example);

    AccountFile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccountFile record, @Param("example") AccountFileExample example);

    int updateByExample(@Param("record") AccountFile record, @Param("example") AccountFileExample example);

    int updateByPrimaryKeySelective(AccountFile record);

    int updateByPrimaryKey(AccountFile record);
}