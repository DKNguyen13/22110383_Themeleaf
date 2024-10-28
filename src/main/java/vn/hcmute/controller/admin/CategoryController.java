package vn.hcmute.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Import Model
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.hcmute.entity.Category;
import vn.hcmute.services.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping // Chỉ định phương thức HTTP GET cho endpoint này
    public String all(Model model) { // Thay Module bằng Model
        List<Category> list = categoryService.findAll(); // Lấy danh sách danh mục từ dịch vụ
        model.addAttribute("listcate", list); // Thêm danh sách vào model với tên "listcate"
        return "admin/category_list"; // Trả về tên view
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST) // Thay đổi thành POST
    public String delete(@PathVariable("id") Long id) {
        categoryService.findById(id).ifPresent(categoryService::delete);
        return "redirect:/admin/categories";
    }

    // Phương thức hiển thị trang thêm danh mục
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category()); // Tạo một đối tượng Category mới
        return "admin/category_add"; // Trả về view cho trang thêm danh mục
    }

    @PostMapping("/add") // Phương thức để thêm danh mục
    public String add(@RequestParam String name, @RequestParam MultipartFile images) {
        Category newCategory = new Category(); // Tạo đối tượng danh mục mới
        newCategory.setName(name);

        // Xử lý file hình ảnh
        if (!images.isEmpty()) {
            // Lưu trữ file hình ảnh ở đây
            String fileName = images.getOriginalFilename();
            // Lưu file vào một thư mục (cần xử lý logic lưu trữ tại đây)
            // Ví dụ: images.transferTo(new File("path/to/save", fileName));
            newCategory.setImages(fileName); // Hoặc đường dẫn đến hình ảnh
        }

        newCategory.setStatus(1); // Hoặc trạng thái bạn mong muốn
        categoryService.save(newCategory); // Lưu danh mục mới vào dịch vụ
        return "redirect:/admin/categories"; // Chuyển hướng về danh sách danh mục
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID:" + id));
        model.addAttribute("category", category);
        return "admin/category_update"; // Đường dẫn đến template cập nhật
    }

    @PostMapping("/update/{id}")
    public String updateCategory(@PathVariable("id") Long id, @RequestParam String name, @RequestParam int status) {
        Category category = categoryService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID:" + id));

        category.setName(name);
        category.setStatus(status);
        categoryService.save(category); // Cập nhật danh mục

        return "redirect:/admin/categories"; // Chuyển hướng về danh sách danh mục
    }





}
