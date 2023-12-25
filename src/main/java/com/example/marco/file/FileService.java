package com.example.marco.file;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
    
    private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository){
        this.fileRepository = fileRepository;
    }

    public void save(MultipartFile file) throws IOException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        fileEntity.setContentType(file.getContentType());
        fileEntity.setData(file.getBytes());
        fileEntity.setSize(file.getSize());

        fileRepository.save(fileEntity);
    }

    public Optional<FileEntity> getFile(Long id){
        return fileRepository.findById(id);
    }

    public List<FileEntity> getAllFiles(){
        return fileRepository.findAll();
    }

    public void replace(Long id, MultipartFile file) throws IOException {
        Optional<FileEntity> fileEntityOption = fileRepository.findById(id);
        if(!fileEntityOption.isPresent()){
            throw new IOException();
        }
        FileEntity fileEntity = fileEntityOption.get();
        fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        fileEntity.setContentType(file.getContentType());
        fileEntity.setData(file.getBytes());
        fileEntity.setSize(file.getSize());

        fileRepository.save(fileEntity);
    }

    public void deleteFile(Long id) throws Exception {
        if (fileRepository.existsById(id)){
            fileRepository.deleteById(id);
        } else {
            throw new Exception("Cannot delete file with id: " + id + " since file does not exist");
        }
    }
}