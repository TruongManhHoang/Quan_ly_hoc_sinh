package com.example.ProjectQuanLyHocSinh.controller;

import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinh;
import com.example.ProjectQuanLyHocSinh.service.hocsinh.HocSinhService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/hocSinh")
public class HocSinhController {
    private HocSinhService hocSinhService;

    @Autowired
    public HocSinhController(HocSinhService hocSinhService) {
        this.hocSinhService = hocSinhService;
    }
    @GetMapping()
    public String showHomePage(Model model){
        return "hocsinh/hocSinh";
    }

    @GetMapping("/create")
    public String create(Model model){
        HocSinh hocSinh = new HocSinh();
        model.addAttribute("hocsinh",hocSinh);
        return "/hocsinh/insert";
    }
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("hocsinh") HocSinh hocSinh,
                       @RequestParam("fileImage") MultipartFile multipartFile,
                       RedirectAttributes ra) throws IOException {
        if (multipartFile.isEmpty()) {
            // Nếu không có file được chọn, bạn có thể xử lý theo cách khác ở đây.
            // Ví dụ: thông báo lỗi cho người dùng.
            return "redirect:/hocSinh/list"; // hoặc trả về một trang lỗi
        }

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        hocSinh.setAvatar(fileName);
        hocSinhService.save(hocSinh);

        String uploadDir = "./hocSinh_avatar/" + hocSinh.getId();
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                // Xảy ra lỗi khi tạo thư mục upload.
                // Bạn có thể xử lý theo cách khác ở đây, ví dụ: thông báo lỗi cho người dùng.
                return "redirect:/hocSinh/list"; // hoặc trả về một trang lỗi
            }
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            System.out.println("Absolute path of uploaded file: " + filePath.toFile().getAbsolutePath());
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            // Xảy ra lỗi khi sao chép file.
            // Bạn có thể xử lý theo cách khác ở đây, ví dụ: thông báo lỗi cho người dùng.
            return "redirect:/hocSinh/list"; // hoặc trả về một trang lỗi
        }
        return "redirect:/hocSinh/list";
    }
    @GetMapping("/list")
    public String listAll(Model model){
        List<HocSinh> hocSinhs = hocSinhService.findAll();
        model.addAttribute("hocsinh", hocSinhs);
        return "/hocsinh/show";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Integer id, Model model){
        HocSinh hocSinh = hocSinhService.findById(id);
        model.addAttribute("hocsinh",hocSinh);
        return "/hocsinh/update";
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("hocsinh") HocSinh hocSinh,
                         @RequestParam("fileImage") MultipartFile multipartFile,
                         RedirectAttributes ra,
                         @RequestParam("id") Integer id) throws IOException {
        // Tìm học sinh cần cập nhật
        HocSinh existingHocSinh = hocSinhService.findById(id);
        if (existingHocSinh == null) {
            // Xử lý khi không tìm thấy học sinh
            return "redirect:/hocSinh/list"; // hoặc trả về một trang lỗi
        }

        // Cập nhật thông tin từ dữ liệu gửi từ form
        existingHocSinh.setTen(hocSinh.getTen());
        existingHocSinh.setHoVaDem(hocSinh.getHoVaDem());
        existingHocSinh.setEmail(hocSinh.getEmail());
        // Cập nhật thông tin khác nếu cần

        // Kiểm tra nếu có tập tin ảnh mới được tải lên
        if (!multipartFile.isEmpty()) {
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            existingHocSinh.setAvatar(fileName);

            // Lưu tập tin ảnh mới
            String uploadDir = "./hocSinh_avatar/" + existingHocSinh.getId();
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                try {
                    Files.createDirectories(uploadPath);
                } catch (IOException e) {
                    // Xử lý khi gặp lỗi tạo thư mục
                    return "redirect:/hocSinh/list"; // hoặc trả về một trang lỗi
                }
            }

            try (InputStream inputStream = multipartFile.getInputStream()) {
                Path filePath = uploadPath.resolve(fileName);
                System.out.println("Absolute path of uploaded file: " + filePath.toFile().getAbsolutePath());
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                // Xử lý khi gặp lỗi sao chép tập tin
                return "redirect:/hocSinh/list"; // hoặc trả về một trang lỗi
            }
        }

        // Lưu thông tin học sinh đã cập nhật
        hocSinhService.save(existingHocSinh);

        return "redirect:/hocSinh/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable( value = "id") Integer id){
        hocSinhService.delete(id);
        return "redirect:/hocSinh/list";
    }
}
