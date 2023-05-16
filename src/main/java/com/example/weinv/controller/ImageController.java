package com.example.weinv.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("images")
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {

  @PostMapping(value="upload",produces="application/json")
  @ResponseBody
  public ResponseEntity<?> uploadImages(@RequestBody MultipartFile[] files) {
	  Map<String, Object> response = new HashMap<>();
	    try {
	    	List<String> filenames = new ArrayList<>();
	      for (MultipartFile file : files) {
	        Path filePath = Paths.get("src/main/resources/static", file.getOriginalFilename());
	        file.transferTo(filePath);
	        filenames.add(file.getOriginalFilename());
	      }
	      response.put("image_url","http://localhost:8080/content/"+filenames.get(0) );
	      return ResponseEntity.ok(response);
	    } catch (IOException e) {
	      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload failed");
	    }
  }

}
