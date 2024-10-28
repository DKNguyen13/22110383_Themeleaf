package vn.hcmute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        // Bạn có thể thêm dữ liệu vào model nếu cần
        return "web/web"; // Tên tệp home.html trong thư mục templates
    }
}
