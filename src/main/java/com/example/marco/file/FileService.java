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
    public FileService(FileRepository inFileRepository){
        this.fileRepository = inFileRepository;
    }

    public FileEntity addFileEntity(MultipartFile file) throws IOException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        fileEntity.setContentType(file.getContentType());
        fileEntity.setData(file.getBytes());
        fileEntity.setSize(file.getSize());

        return fileRepository.save(fileEntity);
    }

    public Optional<FileEntity> getFileEntityById(Long id){
        return fileRepository.findById(id);
    }

    public List<FileEntity> getAllFileEntities(){
        return fileRepository.findAll();
    }

    public FileEntity upsertFileEntity(Long id, MultipartFile file) throws IOException {
        FileEntity fileEntity = null;
        Optional<FileEntity> fileEntityOption = fileRepository.findById(id);

        if(fileEntityOption.isEmpty()){
            fileEntity = new FileEntity();
        } else {
            fileEntity = fileEntityOption.get();
        }
        
        fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        fileEntity.setContentType(file.getContentType());
        fileEntity.setData(file.getBytes());
        fileEntity.setSize(file.getSize());

        return fileRepository.save(fileEntity);
    }

    public void deleteFileByFileId(Long inFileId){
        this.fileRepository.deleteById(inFileId);
    }
}
