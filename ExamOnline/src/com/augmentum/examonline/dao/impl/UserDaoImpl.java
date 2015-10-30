package com.augmentum.examonline.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.augmentum.examonline.dao.UserDao;
import com.augmentum.examonline.model.User;
import com.augmentum.examonline.until.DbUtil;
public class UserDaoImpl implements UserDao{
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    User user = null;
    public User getUserByName(String userName) {
        if (userName == null || userName.equals("")) {
            return null;
        }
        try {
            con = DbUtil.getConnection();
            stmt = con.prepareStatement("SELECT * FROM user WHERE user_name = ? ");
            stmt.setString(1, userName);
            rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User();
                int idDB = rs.getInt("id");
                String userDB = rs.getString("user_name");
                String passworDB = rs.getString("user_password");
                user.setId(idDB);
                user.setName(userDB);
                user.setPassword(passworDB);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            DbUtil.close(rs, stmt, con);
        }
        return user;
    }
}
