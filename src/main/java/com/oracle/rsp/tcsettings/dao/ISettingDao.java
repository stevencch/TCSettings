/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oracle.rsp.tcsettings.dao;

import com.oracle.rsp.tcsettings.domain.Setting;
import java.util.List;

/**
 *
 * @author scao
 */
public interface ISettingDao {

    void deleteSetting(String key);

    String getSetting(String key);

    List<Setting> getSettings();

    void updateSetting(String key, String value);
    
}
