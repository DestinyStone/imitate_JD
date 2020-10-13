package service;

import bean.PmsBaseCatalog2;
import response.Message;

import java.util.List;

/**
 * @Auther: DestinyStone
 * @Date: 2020/10/11 16:07
 * @Description:
 */
public interface PmsBaseCatalog2Service {
    List<PmsBaseCatalog2> selectByCatalog1Id(String catalog1Id);

    void updateById(String catalog2Id, String name);

    void deleteById(String catalog2Id);


    Message insertByNotNameRepetition(String name, String catalog1Id);
}
