package cn.algerfan.springboot09validate.contorller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author AlgerFan
 * @date Created in 2019/3/31 08
 * @Description
 */
@RestController
public class testController {

    @RequestMapping("/to")
    public ModelAndView to() {
        return new ModelAndView("test");
    }

    @RequestMapping("/upload")
    public ModelAndView upload(@RequestParam("file") MultipartFile[] myFileNames,
                               Model model){
        for (MultipartFile myFileName : myFileNames) {
            String fileName = myFileName.getOriginalFilename();
            assert fileName != null;
            String realName = fileName;
            String fileNameExtension = fileName.substring(0,fileName.indexOf("."));
            realName = "<p><li><a href=\""+realName+"\">"+fileNameExtension+"</a></li></p>";
            System.out.println(realName);
        }
        model.addAttribute("msg","上传成功");
        return new ModelAndView("test");
    }
}
