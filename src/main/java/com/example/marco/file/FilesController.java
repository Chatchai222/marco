package com.example.marco.file;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("api/v1/files")
public class FilesController {
    
    private final FileService fileService;

    @Autowired
    public FilesController(FileService fileService){
        this.fileService = fileService;
    }

    @GetMapping
    public List<FileResponse> list() {
        return fileService.getAllFiles()
                          .stream()
                          .map(this::mapToFileResponse)
                          .collect(Collectors.toList());
                          
    }

    @GetMapping("download/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id){
        Optional<FileEntity> fileEntityOptional = fileService.getFile(id);

        if(!fileEntityOptional.isPresent()){
            return ResponseEntity.notFound()
                                 .build();
        }

        FileEntity fileEntity = fileEntityOptional.get();
        return ResponseEntity.ok()
                             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
                             .contentType(MediaType.valueOf(fileEntity.getContentType()))
                             .body(fileEntity.getData());

    }                 

    @PostMapping
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        try {
            fileService.save(file);
            return ResponseEntity.status(HttpStatus.OK)
                                 .body(String.format("File uploaded sucessfully: %s", file.getOriginalFilename()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(String.format("Could not upload the file: %s", file.getOriginalFilename()));
        }
    }

    private FileResponse mapToFileResponse(FileEntity fileEntity){
        String downloadURL = MvcUriComponentsBuilder.fromMethodName(FilesController.class,
                                                                    "getFile",
                                                                    fileEntity.getId())
                                                                    .build()
                                                                    .toUriString();

        FileResponse fileResponse = new FileResponse();
        fileResponse.setId(fileEntity.getId());
        fileResponse.setName(fileEntity.getName());
        fileResponse.setContentType(fileEntity.getContentType());
        fileResponse.setSize(fileEntity.getSize());
        fileResponse.setUrl(downloadURL);

        return fileResponse;
    }
    
    @PutMapping("{id}")
    public ResponseEntity<String> replaceUpload(@RequestParam("file") MultipartFile file, @PathVariable Long id){
        try {
            fileService.replace(id, file);
            return ResponseEntity.status(HttpStatus.OK)
                                 .body(String.format("File replaced sucessfully: %s", file.getOriginalFilename()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(String.format("Could not replace the file: %s", file.getOriginalFilename()));
        }
    }

    

}
