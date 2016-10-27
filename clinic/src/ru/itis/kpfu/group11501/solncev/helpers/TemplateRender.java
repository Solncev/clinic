package ru.itis.kpfu.group11501.solncev.helpers;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Марат on 17.10.2016.
 */
public class TemplateRender {
    public static void render(HttpServletRequest request, HttpServletResponse response,
                              Template template, Map<String, Object> root) throws IOException {
        try {
            template.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

}
