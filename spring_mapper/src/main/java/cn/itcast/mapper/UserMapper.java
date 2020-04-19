package cn.itcast.mapper;

import cn.itcast.domain.User;

import java.util.List;

public interface UserMapper {


    List<User>  findById(int i);

    List<User>  findByIds(List<Integer> ids);

    List<User> findOne(User user);
}
