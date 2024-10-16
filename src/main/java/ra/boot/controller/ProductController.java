package ra.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.boot.exception.NotFoundException;
import ra.boot.model.dto.request.FormCatalogAdd;
import ra.boot.model.dto.request.FormProductAdd;
import ra.boot.service.catalog.ICatalogService;
import ra.boot.service.product.IProductService;

import java.io.IOException;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICatalogService catalogService;
    @GetMapping
    public String list(Model model) {
        model.addAttribute("products",productService.getProductForAdmin());
        return "product/index";
    }
    @GetMapping("/add")
    public  String add(Model model){
        model.addAttribute("product",new FormProductAdd());
        model.addAttribute("catalogs",catalogService.getCatalogForAdmin());
        return "product/add";
    }
    @PostMapping("/add")
    public String doAdd(@ModelAttribute("product") FormProductAdd request) throws NotFoundException, IOException {
        productService.createProduct(request);
        return "redirect:/product";
    }

}
