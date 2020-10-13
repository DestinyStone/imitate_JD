package bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OmsOrderItem implements Serializable {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column
  private Long id;

  @Column
  private Long orderId;

  @Column
  private String orderSn;

  @Column
  private Long productId;

  @Column
  private String productPic;

  @Column
  private String productName;

  @Column
  private String productBrand;

  @Column
  private String productSn;

  @Column
  private Double productPrice;

  @Column
  private Long productQuantity;

  @Column
  private Long productSkuId;

  @Column
  private String productSkuCode;

  @Column
  private Long productCategoryId;

  @Column
  private String sp1;

  @Column
  private String sp2;

  @Column
  private String sp3;
  private String promotionName;

  @Column
  private Double promotionAmount;

  @Column
  private Double couponAmount;

  @Column
  private Double integrationAmount;

  @Column
  private Double realAmount;

  @Column
  private Long giftIntegration;

  @Column
  private Long giftGrowth;

  @Column
  private String productAttr;

}
