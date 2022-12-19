package com.sprios.sprios_spring.global.vo;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Enumerated;
import java.util.Objects;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image {
  private String imgUrl;
  @Enumerated
  private ImageType imgType;
  private String imgName;
  private String imgUUID;

  @Override
  public int hashCode() {
    return Objects.hashCode(getImgUUID());
  }

  @Override
  public boolean equals(Object obj) {
    if(this == obj) {
      return true;
    }
    if(obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Image image = (Image)obj;
    return Objects.equals(getImgUUID(), image.getImgUUID());
  }
}
