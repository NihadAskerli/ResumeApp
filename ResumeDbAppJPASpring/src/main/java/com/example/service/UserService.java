package com.example.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.repo.UserRepo;
import com.example.repo.UserDaoInter;
import com.example.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
@RequiredArgsConstructor
public class UserService  {
    public final UserRepo userRepo;
    @PersistenceContext
    EntityManager em;


    public List<User> getAll(String name, String surname, Integer nationalityId) {
//
//        String jpql = "select u from User u where 1=1 ";
//        Query q = em.createQuery(jpql, User.class);
//
//
//        if (name != null && !name.trim().isEmpty()) {
//            jpql += " and u.name=:name ";
//        }
//        if (surname != null && !surname.trim().isEmpty()) {
//            jpql += " and u.surname=:surname";
//        }
//        if (nationalityId != null) {
//            jpql += " and u.nationality.id=:nid";
//        }
//
//        Query query = em.createQuery(jpql, User.class);
//        if (name != null && !name.trim().isEmpty()) {
//            query.setParameter("name", name);
//
//        }
//        if (surname != null && !surname.trim().isEmpty()) {
//            query.setParameter("surname", surname);
//        }
//        if (nationalityId != null) {
//            query.setParameter("nid", nationalityId);
//        }
//
//        return query.getResultList();
        return userRepo.findByNameAndSurnameAndNationality(name, surname, nationalityId);
    }


    public User findByEmailAndPassword(String email, String password) {
        User user = userRepo.findByEmailAndPassword(email, password);
        if (user == null) {
            return null;
        }
        return user;

    }

    public User findByEmail(String email) {
        User user = userRepo.findByEmail(email);
        if (user == null) {
            return null;
        }
        return user;
    }


    public User getById(int userId) {
        return userRepo.findById(userId).get();
    }


    private BCrypt.Hasher crypt = BCrypt.withDefaults();

    public User addUser(User u) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        return userRepo.save(u);
    }

    public User removeUser(int id) {
        userRepo.delete(getById(id));
        return getById(id);
    }

}
