package com.example.demo.domain.repository.jdbc;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository("UserDaoJdbcImpl")
public class UserDaoJdbcImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbc;

    // Userテーブルの件数を取得
    @Override
    public int count() throws DataAccessException {
        // 全件取得してカウント
        int count = jdbc.queryForObject("SELECT COUNT(*) FROM m_user", Integer.class);
        return count;
    }

    // Userテーブルにデータを1件insert
    @Override
    public int insertOne(User user) throws DataAccessException {
        return 0;
    }

    // Userテーブルのデータを1件取得
    @Override
    public User selectOne(String userId) throws DataAccessException {
        // １件取得
        Map<String, Object> map = jdbc.queryForMap("SELECT * FROM m_user"
                + " WHERE user_id = ?", userId);

        // 結果返却用の変数
        User user = new User();

        // 取得したデータを結果返却用の変数にセットしていく
        user.setUserId((String) map.get("user_id")); //ユーザーID
        user.setPassword((String) map.get("password")); //パスワード
        user.setUserName((String) map.get("user_name")); //ユーザー名
        user.setBirthday((Date) map.get("birthday")); //誕生日
        user.setAge((Integer) map.get("age")); //年齢
        user.setMarriage((Boolean) map.get("marriage")); //結婚ステータス
        user.setRole((String) map.get("role")); //ロール

        return user;
    }

    // Userテーブルの全データを取得
    @Override
    public List<User> selectMany() throws DataAccessException {
        return null;
    }

    // Userテーブルを1件更新
    @Override
    public int updateOne(User user) throws DataAccessException {
        return 0;
    }

    // Userテーブルを1件削除
    @Override
    public int deleteOne(String userId) throws DataAccessException {
        return 0;
    }

    // Userテーブルの全データをCSVに出力する
    @Override
    public void userCsvOut() throws DataAccessException {

    }
}
