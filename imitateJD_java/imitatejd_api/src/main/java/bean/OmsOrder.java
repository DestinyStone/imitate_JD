package bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OmsOrder implements Serializable {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column
  private Long id;

  @Column
  private Long memberId;

  @Column
  private Long couponId;

  @Column
  private String orderSn;

  @Column
  private Date createTime;

  @Column
  private String memberUsername;

  @Column
  private Double totalAmount;

  @Column
  private Double payAmount;

  @Column
  private Double freightAmount;

  @Column
  private Double promotionAmount;

  @Column
  private Double integrationAmount;

  @Column
  private Double couponAmount;

  @Column
  private Double discountAmount;

  @Column
  private Long payType;

  @Column
  private Long sourceType;

  @Column
  private Long status;

  @Column
  private Long orderType;

  @Column
  private String deliveryCompany;

  @Column
  private String deliverySn;

  @Column
  private Long autoConfirmDay;

  @Column
  private Long integration;

  @Column
  private Long growth;

  @Column
  private String promotionInfo;

  @Column
  private Long billType;

  @Column
  private String billHeader;

  @Column
  private String billContent;

  @Column
  private String billReceiverPhone;

  @Column
  private String billReceiverEmail;

  @Column
  private String receiverName;

  @Column
  private String receiverPhone;

  @Column
  private String receiverPostCode;

  @Column
  private String receiverProvince;

  @Column
  private String receiverCity;

  @Column
  private String receiverRegion;

  @Column
  private String receiverDetailAddress;

  @Column
  private String note;

  @Column
  private Long confirmStatus;

  @Column
  private Long deleteStatus;

  @Column
  private Long useIntegration;
  private Date paymentTime;

  @Column
  private Date deliveryTime;

  @Column
  private Date receiveTime;

  @Column
  private Date commentTime;

  @Column
  private Date modifyTime;

  @Transient
  private List<OmsOrderItem> omsOrderItems;
}
