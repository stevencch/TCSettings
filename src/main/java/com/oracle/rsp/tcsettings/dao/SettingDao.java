/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.rsp.tcsettings.dao;

import com.oracle.rsp.tcsettings.domain.Setting;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author scao
 */
public class SettingDao {

    private SessionFactory sessionFactory = null;
    private ServiceRegistry serviceRegistry = null;

    private SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure();

        Properties properties = configuration.getProperties();

        serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }

    public SettingDao() {
        configureSessionFactory();

    }
    
    public String getSetting(String key){
        String result="";
        Session session = sessionFactory.openSession();
        List<Setting> settings = (List<Setting>) session.createQuery("from Setting").list();
        Setting setting = settings.stream().filter(x -> x.getKey().equals(key)).findFirst().orElse(null);
        if (setting != null) {
            result=setting.getValue();
        }
        session.close();
        return result;
    }
    
    public void deleteSetting(String key){
        Session session = sessionFactory.openSession();
        List<Setting> settings = (List<Setting>) session.createQuery("from Setting").list();
        Setting setting = settings.stream().filter(x -> x.getKey().equals(key)).findFirst().orElse(null);
        if (setting != null) {
            session.delete(setting);
        }
        session.flush();
        session.close();
    }
    

    public void updateSetting(String key, String value) {

        Session session = sessionFactory.openSession();
        List<Setting> settings = (List<Setting>) session.createQuery("from Setting").list();
        Setting setting = settings.stream().filter(x -> x.getKey().equals(key)).findFirst().orElse(null);
        if (setting != null) {
            setting.setValue(value);
            session.update(setting);
        } else {
            Setting newSetting = new Setting();
            newSetting.setKey(key);
            newSetting.setValue(value);
            session.save(newSetting);
        }
        session.flush();
        session.close();
    }

    public List<Setting> getSettings() {
        Session session = sessionFactory.openSession();
        List<Setting> settings = (List<Setting>) session.createQuery("from Setting").list();
        session.close();
        return settings;
    }
}
