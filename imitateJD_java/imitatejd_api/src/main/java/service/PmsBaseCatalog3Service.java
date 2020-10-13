package service;

import bean.PmsBaseCatalog3;
import response.Message;

import java.util.List;

/**
 * @Auther: DestinyStone
 * @Date: 2020/10/11 16:07
 * @Description:
 */
public interface PmsBaseCatalog3Service {
    List<PmsBaseCatalog3> selectByCatalog2Id(String catalog2Id);

    void updateById(String catalog3Id, String name);

    void deleteById(String catalog3Id);

    Message insertByNotNameRepetition(String name, String catalog2Id);
}
