package service;

import bean.PmsBaseCatalog1;
import response.Message;

import java.util.List;

/**
 * @Auther: DestinyStone
 * @Date: 2020/10/11 16:07
 * @Description:
 */
public interface PmsBaseCatalog1Service {
    List<PmsBaseCatalog1> selectAll();

    void updateById(String catalog1Id, String name);

    void deleteById(String catalog3Id);

    Message insertByNotNameRepetition(String name);
}
