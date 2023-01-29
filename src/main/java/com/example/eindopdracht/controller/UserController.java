package com.example.eindopdracht.controller;

import com.example.eindopdracht.dto.UserDto;
import com.example.eindopdracht.model.SystemFile;
import com.example.eindopdracht.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> getMyInfo() throws Exception {
        return ResponseEntity.ok(userService.getMyInfo());
    }

    @GetMapping("/cv/download")
    public ResponseEntity downloadCv(@RequestParam("fileId") String fileId) throws Exception {
        SystemFile systemFile = userService.downloadCv(fileId);
        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + systemFile.getFilename() + "\"";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(systemFile.getData());
    }

    @PostMapping("/cv/upload")
    public ResponseEntity<UserDto> uploadCv(@RequestParam("file") MultipartFile file) throws Exception {
        try {
            return ResponseEntity.ok(userService.uploadCv(file));
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

}
