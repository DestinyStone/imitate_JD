package service;

import bean.PmsBaseAttrInfo;

import java.util.List;

/**
 * @Auther: DestinyStone
 * @Date: 2020/10/12 10:15
 * @Description:
 */
public interface PmsBaseAttrInfoService {
    List<PmsBaseAttrInfo> getPmsBaseAttrInfoByCatalog3Id(String catalog3Id);
}
