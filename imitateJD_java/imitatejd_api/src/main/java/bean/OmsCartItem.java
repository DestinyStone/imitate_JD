package bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OmsCartItem implements Serializable {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column
  private Long id;

  @Column
  private Long productId;

  @Column
  private Long productSkuId;

  @Column
  private Long memberId;

  @Column
  private Long quantity;

  @Column
  private Double price;

  @Column
  private String sp1;

  @Column
  private String sp2;

  @Column
  private String sp3;

  @Column
  private String productPic;

  @Column
  private String productName;

  @Column
  private String productSubTitle;

  @Column
  private String productSkuCode;

  @Column
  private String memberNickname;

  @Column
  private Date createDate;

  @Column
  private Date modifyDate;

  @Column
  private Long deleteStatus;

  @Column
  private Long productCategoryId;

  @Column
  private String productBrand;

  @Column
  private String productSn;

  @Column
  private String productAttr;

  @Transient
  private String isChecked;
}
