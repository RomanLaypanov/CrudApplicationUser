package web.services;

import org.springframework.stereotype.Repository;
import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.model.User;

import java.util.List;

@Repository
public class UserServicesImpl implements UserServices {
    private final UserDao userDao;

    public UserServicesImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> index() {
        return userDao.index();
    }

    @Override
    public User show(int id) {
        return userDao.show(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User updateUser) {
        userDao.update(updateUser);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
