package com.example.marco.file;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

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
        return fileService.getAllFileEntities()
                          .stream()
                          .map(this::mapToFileResponse)
                          .collect(Collectors.toList());
                          
    }

    @GetMapping("/{id}")
    public ResponseEntity<FileResponse> getFileResponseByFileId(@PathVariable("id") Long inFileId){
        Optional<FileEntity> entityOpt = this.fileService.getFileEntityById(inFileId);
        if(entityOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        FileEntity fileEntity = entityOpt.get();
        FileResponse responseToSend = this.mapToFileResponse(fileEntity);
        return new ResponseEntity<FileResponse>(responseToSend, HttpStatus.OK);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<InputStreamResource> downloadFile(@PathVariable Long id){
        Optional<FileEntity> fileEntityOptional = fileService.getFileEntityById(id);

        if(!fileEntityOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }

        FileEntity fileEntity = fileEntityOptional.get();
        return ResponseEntity.ok()
                             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
                             .contentType(MediaType.valueOf(fileEntity.getContentType()))
                             .body(new InputStreamResource( new ByteArrayInputStream(fileEntity.getData())));

    }
    
    @GetMapping("/view/{id}")
    public ResponseEntity<InputStreamResource> viewFile(@PathVariable Long id) {
        Optional<FileEntity> fileEntityOptional = fileService.getFileEntityById(id);

        if(!fileEntityOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }

        FileEntity fileEntity = fileEntityOptional.get();
        return ResponseEntity.ok()          // THE F***ING header parameter (inline vs attachment) dictate whether file is display or download
                             .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + fileEntity.getName() + "\"")
                             .contentType(MediaType.valueOf(fileEntity.getContentType()))
                             .body(new InputStreamResource(new ByteArrayInputStream(fileEntity.getData())));
    }

    @PostMapping
    public FileResponse upload(@RequestParam("file") MultipartFile inFile) throws Exception{
        try {
            FileEntity fileEntity = fileService.addFileEntity(inFile);
            FileResponse fileResponse = this.mapToFileResponse(fileEntity);
            return fileResponse;
        } catch (Exception e) {
            throw new Exception("Error failed to upload file: ");
        }
    }
    
    @PutMapping("/{id}")
    public FileResponse replaceUpload(@RequestParam("file") MultipartFile file, @PathVariable("id") Long id) throws Exception{
        try {
            FileEntity fileEntity = fileService.upsertFileEntity(id, file);
            FileResponse fileResponse = this.mapToFileResponse(fileEntity);
            return fileResponse;
        } catch (Exception e) {
            throw new Exception("Error failed to replace file");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteFile(@PathVariable("id") Long id){
        this.fileService.deleteFileByFileId(id);
    }

    private FileResponse mapToFileResponse(FileEntity fileEntity){
        String downloadURL = MvcUriComponentsBuilder.fromMethodName(FilesController.class,
                                                                    "downloadFile",
                                                                    fileEntity.getId())
                                                                    .build()
                                                                    .toUriString();
        String viewUrl = MvcUriComponentsBuilder.fromMethodName(FilesController.class,
                                                                "viewFile",
                                                                fileEntity.getId())
                                                                .build()
                                                                .toUriString();
        FileResponse fileResponse = new FileResponse();
        fileResponse.setId(fileEntity.getId());
        fileResponse.setName(fileEntity.getName());
        fileResponse.setContentType(fileEntity.getContentType());
        fileResponse.setSize(fileEntity.getSize());
        fileResponse.setDownloadUrl(downloadURL);
        fileResponse.setViewUrl(viewUrl);

        return fileResponse;
    }

}
