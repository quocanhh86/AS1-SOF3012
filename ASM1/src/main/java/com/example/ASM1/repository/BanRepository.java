package com.example.ASM1.repository;

import com.example.ASM1.model.Ban;
import com.example.ASM1.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class BanRepository {
    Session s;

    public BanRepository() {
        s = HibernateConfig.getFACTORY().openSession();
    }

    public List<Ban> getAll() {
        return s.createQuery("FROM Ban ").list();
    }

    public Ban getOne(int ma) {
        return s.find(Ban.class, ma);
    }

    public void update(Ban b) {
        try {
            s.getTransaction().begin();
            s.merge(b);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(Ban b) {
        try {
            s.getTransaction().begin();
            s.delete(b);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void add(Ban b) {
        try {
            s.getTransaction().begin();
            s.save(b);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(new BanRepository().getOne(1));
    }
}
