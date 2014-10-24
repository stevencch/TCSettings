/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.rsp.tcsettings.web.tag;

import com.oracle.rsp.tcsettings.domain.Setting;
import com.oracle.rsp.tcsettings.service.SettingService;
import com.sun.net.httpserver.HttpContext;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author scao
 */
public class SettingTag extends SimpleTagSupport {

    SettingService settingService = new SettingService();

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");
            List<Setting> settings = settingService.getSettings();
            JspFragment f = getJspBody();
            StringWriter sw = new StringWriter();
            f.invoke(sw);
            String body = sw.getBuffer().toString();
            JspWriter jw= f.getJspContext().getOut();
            for (Setting s : settings) {
                String newBody=body.replace("[key]", s.getKey()).replace("[value]", s.getValue());
                jw.write(newBody);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in SettingTag tag", ex);
        }
    }

}
