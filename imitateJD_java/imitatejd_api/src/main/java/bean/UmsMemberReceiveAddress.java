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
public class UmsMemberReceiveAddress implements Serializable {

  @Column
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private Long memberId;

  @Column
  private String name;

  @Column
  private String phoneNumber;

  @Column
  private Long defaultStatus;

  @Column
  private String postCode;

  @Column
  private String province;

  @Column
  private String city;

  @Column
  private String region;

  @Column
  private String detailAddress;
}
