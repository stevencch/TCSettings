/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.rsp.tcsettings.controller;

import com.oracle.rsp.tcsettings.domain.Setting;
import com.oracle.rsp.tcsettings.service.ISettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Administrator
 */
@Controller
public class SettingController {

    @Autowired
    private ISettingService settingService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String GetSettings(Model model) {
        model.addAttribute("settings", settingService.getSettings());
        model.addAttribute("newsetting", new Setting());
        return "list";
    }

    @RequestMapping(value = "/settingAction/update", method = RequestMethod.POST)
    public String addSettings(@ModelAttribute("setting") Setting setting) {
        settingService.updateSetting(setting.getKey(), setting.getValue());
        return "redirect:/admin";
    }

    @RequestMapping(value = "/settingAction/delete", method = RequestMethod.POST)
    public String deleteSettings(@ModelAttribute("setting") Setting setting) {
        settingService.deleteSetting(setting.getKey());
        return "redirect:/admin";
    }

    @RequestMapping(value = "/settingAction/new", method = RequestMethod.POST)
    public String insertSettings(@ModelAttribute("newsetting") Setting setting) {
        settingService.updateSetting(setting.getKey(), setting.getValue());
        return "redirect:/admin";
    }
    
    
    @RequestMapping(value = "/getValue", method = RequestMethod.GET)
    @ResponseBody
    public   String getSetting(@RequestParam("key") String key) {
        String value=settingService.getSetting(key);
        return value;
    }
    
    @RequestMapping(value = "/setting/{key}", method = RequestMethod.GET)
    public @ResponseBody String getSettingValue(@PathVariable String key) {
        String value=settingService.getSetting(key);
        return value;
    }
}
