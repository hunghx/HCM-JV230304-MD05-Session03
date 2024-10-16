package ra.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ra.boot.exception.NotFoundException;
import ra.boot.model.entity.Catalog;
import ra.boot.repository.ICatalogRepository;

@Controller
public class HomeController {
    @GetMapping
    public String home()  {
        return "home";
    }
}
