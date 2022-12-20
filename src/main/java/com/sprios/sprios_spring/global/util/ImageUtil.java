package com.sprios.sprios_spring.global.util;

import com.sprios.sprios_spring.domain.member.exception.NotSupportedImageTypeException;
import com.sprios.sprios_spring.global.vo.Image;
import com.sprios.sprios_spring.global.vo.ImageType;
import org.springframework.web.multipart.MultipartFile;


import java.text.Normalizer;
import java.util.UUID;

public class ImageUtil {
  private static final int FILE_NAME = 0;
  private static final int FIEL_TYPE = 1;
  public static Image convertMultipartFiletoImage(MultipartFile file, String Url) {
    final String originalName = Normalizer.normalize(file.getOriginalFilename(), Normalizer.Form.NFC);
    String[] fileInfo = originalName.split("\\.");

    if(!isSupportedType(fileInfo[FIEL_TYPE])) {
      throw new NotSupportedImageTypeException();
    }

    return Image.builder()
        .imgName(fileInfo[FILE_NAME])
        .imgType(ImageType.valueOf(fileInfo[FIEL_TYPE].toUpperCase()))
        .imgUUID(UUID.randomUUID().toString())
        .imgUrl(Url).build();
  }

  private static boolean isSupportedType(String type) {
    ImageType[] imageTypes = ImageType.values();

    for(ImageType imageType : imageTypes) {
      if(imageType.toString().equals(type.toUpperCase())) {
        return true;
      }
    }
    return false;
  }

  public static Image getDefaultImg() {
    return Image.builder()
        .imgName("base_profile")
        .imgType(ImageType.PNG)
        .imgUrl("https://identitylessimgserver.s3.ap-northeast-2.amazonaws.com/member/base_profile.png")
        .imgUUID("base-UUID")
        .build();
  }
}
