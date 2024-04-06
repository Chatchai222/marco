package com.example.marco.file;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.marco.floorfile.FloorFileRepository;


@Service
public class FileService {
    
    private final FileRepository fileRepository;
    private final FloorFileRepository floorFileRepository;
    private final String[] ALLOWED_CONTENT_TYPES = {"image/png", "image/jpeg"};

    @Autowired
    public FileService(FileRepository inFileRepository, FloorFileRepository inFloorFileRepository){
        this.fileRepository = inFileRepository;
        this.floorFileRepository = inFloorFileRepository;
    }

    public FileEntity addFileEntity(MultipartFile file) throws Exception {
        if(!isAllowedContentTypeImage(file.getContentType())){
            throw new Exception("addFileEntity(MultipartFile) error: cannot store file with content type: " + file.getContentType());
        }

        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        fileEntity.setContentType(file.getContentType());
        fileEntity.setData(file.getBytes());
        fileEntity.setSize(file.getSize());



        return fileRepository.save(fileEntity);
    }

    public FileEntity addFileEntity(File file) throws Exception{
        String fileContentType = URLConnection.guessContentTypeFromName(file.getName());
        if(!isAllowedContentTypeImage(fileContentType)){
            throw new Exception("addFileEntity(File) error: cannot store file with content type: " + fileContentType);
        }

        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(StringUtils.cleanPath(file.getName()));
        fileEntity.setContentType(fileContentType);
        fileEntity.setData(FileCopyUtils.copyToByteArray(file));
        fileEntity.setSize(file.length());

        return fileRepository.save(fileEntity);
    }

    public Optional<FileEntity> getFileEntityById(Long id){
        return fileRepository.findById(id);
    }

    public List<FileEntity> getAllFileEntities(){
        return fileRepository.findAll();
    }

    public FileEntity replaceFileEntity(Long id, MultipartFile file) throws IOException, Exception {
        FileEntity fileEntity = null;
        Optional<FileEntity> fileEntityOption = fileRepository.findById(id);
        if(fileEntityOption.isEmpty()){
            throw new Exception("replaceFileEntity multipartfile error: fileEntity with fileId: " + id + " does not exist");
        }

        if(!isAllowedContentTypeImage(file.getContentType())){
            throw new Exception("replaceFileEntity multipartfile error: cannot store file with content type: " + file.getContentType());
        }

        fileEntity = fileEntityOption.get();
        fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        fileEntity.setContentType(file.getContentType());
        fileEntity.setData(file.getBytes());
        fileEntity.setSize(file.getSize());

        return fileRepository.save(fileEntity);
    }

    public FileEntity replaceFileEntity(Long id, File file) throws IOException, Exception{
        FileEntity fileEntity = null;
        Optional<FileEntity> fileEntityOption = fileRepository.findById(id);
        String fileContentType = URLConnection.guessContentTypeFromName(file.getName());

        if(fileEntityOption.isEmpty()){
            throw new Exception("replaceFileEntity file error: fileEntity with fileId: " + id + " does not exist");
        }
        if(!isAllowedContentTypeImage(fileContentType)){
            throw new Exception("replaceFileEntity file error: cannot store file wiht content type: " + fileContentType);
        } 

        fileEntity = fileEntityOption.get();
        fileEntity.setName(StringUtils.cleanPath(file.getName()));
        fileEntity.setContentType(fileContentType);
        fileEntity.setData(FileCopyUtils.copyToByteArray(file));
        fileEntity.setSize(file.length());

        return fileRepository.save(fileEntity);
    }

    public void deleteFileByFileId(Long inFileId){
        this.floorFileRepository.deleteByFileId(inFileId);

        this.fileRepository.deleteById(inFileId);
    }

    private Boolean isAllowedContentTypeImage(String inContentType){
        Boolean result = false;
        for(int i = 0; i < ALLOWED_CONTENT_TYPES.length; i++){
            if(inContentType.equals(ALLOWED_CONTENT_TYPES[i])){
                result = true;
                break;
            }
        }
        return result;
    }

}
