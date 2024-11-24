package vn.edu.iuh.fit.coffeehouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("images")
public class ImageController {
    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("{fileName:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String fileName){
        System.out.println(fileName);
        Resource resource = resourceLoader.getResource("classpath:images/"+fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+resource.getFilename()+"\"").body(resource);
    }
}
