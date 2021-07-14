package com.evz.school.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 文件夹遍历
 * 实现文件下载
 * 固定配置文件夹
 */

@Controller
@RequestMapping("/v1")
public class FolderController {

    @Value("${shareFolder}")
    private String shareFolder;

    @RequestMapping("/folder")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("folder");
        File file = new File(shareFolder);
        if (file.exists() && file.isDirectory()) {
            mav.addObject("fileList", file.list());
        }
        return mav;
    }

    @RequestMapping("/download")
    public void download(String file, HttpServletResponse response) throws IOException {
        File dFile = new File(shareFolder, file);
        if (dFile.exists() && dFile.isFile()) {
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;filename=" + file);
            byte[] buffer = new byte[102400];
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(dFile));
                 BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream())) {
                int len;
                while ((len = bis.read(buffer)) > 0) {
                    bos.write(buffer, 0, len);
                    bos.flush();
                }
            }
        }
    }
}
