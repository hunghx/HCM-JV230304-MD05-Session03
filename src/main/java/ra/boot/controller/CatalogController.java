package ra.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.boot.exception.NotFoundException;
import ra.boot.model.dto.request.FormCatalogAdd;
import ra.boot.model.dto.response.CatalogForAdmin;
import ra.boot.service.catalog.ICatalogService;

import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    private ICatalogService catalogService;
    @GetMapping
    public String list(@RequestParam(required = false) String message,Model model) { // danh sach
        List<CatalogForAdmin> list = catalogService.getCatalogForAdmin();
        model.addAttribute("catalogs",list);
        model.addAttribute("message",message);
        return "catalog/index";
    }
    @GetMapping("/toggle-active/{id}")
    public String toggleCatalog(@PathVariable Integer id) throws NotFoundException {
        catalogService.toggleCatalogActive(id);
        return "redirect:/catalog";
    }
    @GetMapping("/add")
    public  String showFormAdd(Model model){
        model.addAttribute("category",new FormCatalogAdd());
        return "catalog/add";
    }

    @PostMapping("/add")
    public String doAdd(@ModelAttribute("category") FormCatalogAdd request, RedirectAttributes redirectAttributes){
       try {
           catalogService.createCatalog(request);
       }catch (Exception e){
           return "catalog/add";
       }
       redirectAttributes.addAttribute("message","Thêm mới thành công");
       return "redirect:/catalog";
    }

}
