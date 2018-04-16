package cn.edu.cuit.controller;

import cn.edu.cuit.model.CuitPicture;
import cn.edu.cuit.service.CuitPictureService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * 文件的上传和下载处理
 *
 * @author sunshixiong
 * @date 2018/3/17 22:47
 */
@RestController
@RequestMapping(value = "/cuitfile")
public class CuitFileController {

    @Autowired
    private CuitPictureService cuitPictureService;

    /**
     * 文件上传
     * @param file
     * @param id
     * @param request
     * @throws IOException
     */
    @PostMapping(value = "/upload")
    @ResponseBody
    public void uploadFile(MultipartFile[] file, String id, HttpServletRequest request) throws IOException {

        for (int i = 0; i < file.length; i++) {
            if (file[i] != null) {
                String fileName = file[i].getOriginalFilename();
                if (fileName != null) {
                    //上传文件后缀名
                    String suffix = file[i].getOriginalFilename().substring(file[i].getOriginalFilename().lastIndexOf("."));
                    String loadFileName = UUID.randomUUID() + suffix;
                    File loadfile = new File("E:/usr/local/cuit" + File.separator + id + File.separator + loadFileName);
                    File uploadfile = new File("E:/usr/local/cuit" + File.separator + id );
                    if(!uploadfile.exists() && !uploadfile.isDirectory()) {
                        uploadfile.mkdirs();
                    }
                    file[i].transferTo(loadfile);
                    CuitPicture cuitPicture = new CuitPicture();
                    cuitPicture.setCuitCommodityId(id);
                    cuitPicture.setPictureType(suffix);
                    cuitPicture.setPictureName(loadFileName);
                    cuitPictureService.add(cuitPicture);
                }
            }
        }
    }
    @GetMapping(value = "/download")
    public void download(String fileName,Integer id, HttpServletResponse response) throws UnsupportedEncodingException {
        String path = "E:/usr/local/cuit";

        File file = new File(path + File.separator + id + File.separator + fileName);

        response.reset();
        response.setHeader("Content-Disposition",
                "attachment; filename=\"" + new String(fileName.getBytes("gbk"), "iso-8859-1") + "\"");
        response.addHeader("Content-Length", "" + file.length());
        response.setContentType("application/octet-stream;charset=UTF-8");
        try {
            InputStream inputStream = new FileInputStream(
                    new File("/usr/local/cuit" + File.separator + id + File.separator + fileName));

            OutputStream outputStream = response.getOutputStream();
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
