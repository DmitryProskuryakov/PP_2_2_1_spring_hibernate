package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public List<User> getUser(String model, int series) {
      Query query = sessionFactory.getCurrentSession().getSession().createQuery("from User");
      List<User> users = query.getResultList();
      List<User> searchableUsers = new ArrayList<>();
      for (User user : users) {
         if (user.getCar().getModel().equals(model) && user.getCar().getSeries() == series) {
            searchableUsers.add(user);
         }
      }
      return searchableUsers;
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
}
