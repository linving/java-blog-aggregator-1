package jba.service.impl;

import jba.dao.BlogDao;
import jba.dao.ItemDao;
import jba.dao.UserDao;
import jba.model.Blog;
import jba.model.Item;
import jba.model.User;
import jba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private BlogDao blogDao;
    @Autowired
    private ItemDao itemDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findOne(int id) {
        return userDao.findOne(id);
    }

    @Transactional
    public User findOneWithBlogs(Integer id) {
        User user = findOne(id);
        List<Blog> blogs = blogDao.findByUser(user);
        for (Blog blog : blogs) {
            List<Item> items = itemDao.findByBlog(blog
                    /*, new PageRequest(0, 10, Sort.Direction.DESC, "publishedDate")*/);
            blog.setItems(items);
        }
        user.setBlogs(blogs);
        return user;
    }

    public void save(User user) {
        userDao.save(user);
    }
}
