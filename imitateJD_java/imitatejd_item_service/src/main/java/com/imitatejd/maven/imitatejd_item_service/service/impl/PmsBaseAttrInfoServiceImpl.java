package com.imitatejd.maven.imitatejd_item_service.service.impl;

import bean.PmsBaseAttrInfo;
import bean.PmsBaseAttrValue;
import com.imitatejd.maven.imitatejd_item_service.mapper.PmsBaseAttrInfoMapper;
import com.imitatejd.maven.imitatejd_item_service.mapper.PmsBaseAttrValueMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import service.PmsBaseAttrInfoService;

import java.util.List;

/**
 * @Auther: DestinyStone
 * @Date: 2020/10/12 10:17
 * @Description:
 */
@Service
public class PmsBaseAttrInfoServiceImpl implements PmsBaseAttrInfoService {

    @Autowired
    private PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    private PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public List<PmsBaseAttrInfo> getPmsBaseAttrInfoByCatalog3Id(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfoQuery = PmsBaseAttrInfo.builder().catalog3Id(catalog3Id).build();
        List<PmsBaseAttrInfo> pmsBaseAttrInfoList = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfoQuery);

        for (PmsBaseAttrInfo pmsBaseAttrInfo : pmsBaseAttrInfoList) {
            PmsBaseAttrValue pmsBaseAttrValueQuery = PmsBaseAttrValue.builder().attrId(pmsBaseAttrInfo.getId()).build();
            List<PmsBaseAttrValue> pmsBaseAttrValueList = pmsBaseAttrValueMapper.select(pmsBaseAttrValueQuery);
            pmsBaseAttrInfo.setPmsBaseAttrValueList(pmsBaseAttrValueList);
        }

        return pmsBaseAttrInfoList;
    }
}
