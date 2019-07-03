package com.example.demo.domain.service.jdbc;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserDao;
import com.example.demo.domain.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class RestServiceJdbcImpl implements RestService {

    @Autowired
    @Qualifier("UserDaoJdbcImpl")
    UserDao dao;

    // 1件登録用メソッド
    @Override
    public boolean insert(User user) {
        return false;
    }

    // 1件検索用メソッド
    @Override
    public User selectOne(String userId) {
        return dao.selectOne(userId);
    }

    // 全件検索用メソッド
    @Override
    public List<User> selectMany() {
        return dao.selectMany();
    }

    // 1件更新用メソッド
    @Override
    public boolean update(User user) {
        return false;
    }

    // 1件削除用メソッド
    @Override
    public boolean delete(String userId) {
        return false;
    }
}
