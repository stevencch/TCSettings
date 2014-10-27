/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oracle.rsp.tcsettings.service;

import com.oracle.rsp.tcsettings.dao.ISettingDao;
import com.oracle.rsp.tcsettings.dao.SettingDao;
import com.oracle.rsp.tcsettings.domain.Setting;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author scao
 */
@Service
public class SettingService implements ISettingService {
    @Autowired
    private ISettingDao settingDao;
    
    
    @Override
    public String getSetting(String key){
        return settingDao.getSetting(key);
    }
    
    @Override
    public List<Setting> getSettings(){
        return settingDao.getSettings();
    }
    
    @Override
    public void updateSetting(String key, String value) {
        settingDao.updateSetting(key, value);
    }
    
    @Override
    public void deleteSetting(String key){
        settingDao.deleteSetting(key);
    }
}
