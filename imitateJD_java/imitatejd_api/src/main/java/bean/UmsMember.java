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
public class UmsMember implements Serializable {

  @Column
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private Long memberLevelId;

  @Column
  private String username;

  @Column
  private String password;

  @Column
  private String nickname;

  @Column
  private String phone;

  @Column
  private Long status;

  @Column
  private java.sql.Timestamp createTime;

  @Column
  private String icon;

  @Column
  private Long gender;

  @Column
  private java.sql.Date birthday;

  @Column
  private String city;

  @Column
  private String job;

  @Column
  private String personalizedSignature;

  @Column
  private Long sourceType;

  @Column
  private Long integration;

  @Column
  private Long growth;

  @Column
  private Long luckeyCount;

  @Column
  private Long historyIntegration;
}
