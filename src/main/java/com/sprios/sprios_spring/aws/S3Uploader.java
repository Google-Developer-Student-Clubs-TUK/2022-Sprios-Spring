package com.sprios.sprios_spring.aws;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class S3Uploader {

  private final AmazonS3Client amazonS3Client;

  @Value("${cloud.aws.s3.bucket}")
  private String bucket;

  public String uploadImage(MultipartFile multipartFile, String dirName)  {
    File uploadFile = convert(multipartFile);
    return upload(uploadFile, dirName);
  }

  private String upload(File file, String dirName) {
    String fileName = dirName + "/" + file.getName();
    String uploadImageUrl = putS3(file, fileName);

    removeNewFile(file);

    return uploadImageUrl;
  }

  private void removeNewFile(File file) {
    if(file.delete()) {
      log.info("file deleted");
    }
    else {
      log.info("file delete fail");
    }
  }

  private String putS3(File file, String fileName) {
    amazonS3Client.putObject(
        new PutObjectRequest(bucket, fileName, file)
            .withCannedAcl(CannedAccessControlList.PublicRead)
    );
    return amazonS3Client.getUrl(bucket, fileName).toString();
  }

  private File convert(MultipartFile multipartFile)  {

    try {
      final File convertFile = new File(multipartFile.getOriginalFilename());
      if(convertFile.createNewFile()) {
        try(FileOutputStream fos = new FileOutputStream(convertFile)) {
          fos.write(multipartFile.getBytes());
        }
        return convertFile;
      }
      throw new FileConvertFailException();
    } catch (IOException e) {
      throw new FileConvertFailException();
    }
  }
}
