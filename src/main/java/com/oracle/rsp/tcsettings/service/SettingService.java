/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oracle.rsp.tcsettings.service;

import com.oracle.rsp.tcsettings.dao.SettingDao;
import com.oracle.rsp.tcsettings.domain.Setting;
import java.util.List;

/**
 *
 * @author scao
 */
public class SettingService {
    private SettingDao settingDao=new  SettingDao();
    
    public List<Setting> getSettings(){
        return settingDao.getSettings();
    }
    
    public void updateSetting(String key, String value) {
        settingDao.updateSetting(key, value);
    }
}
