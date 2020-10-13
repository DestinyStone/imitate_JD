package com.imitatejd.maven.imitatejd_item_controller.controller;

import bean.PmsBaseAttrInfo;
import bean.PmsBaseCatalog1;
import bean.PmsBaseCatalog2;
import bean.PmsBaseCatalog3;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import response.Message;
import response.type.ResponseCodeType;
import service.PmsBaseAttrInfoService;
import service.PmsBaseCatalog1Service;
import service.PmsBaseCatalog2Service;
import service.PmsBaseCatalog3Service;

import java.util.List;

/**
 * @Auther: DestinyStone
 * @Date: 2020/10/11 12:09
 * @Description:
 */
@RestController
@CrossOrigin
public class ItemController {

    @Reference
    private PmsBaseCatalog1Service pmsBaseCatalog1Service;

    @Reference
    private PmsBaseCatalog2Service pmsBaseCatalog2Service;

    @Reference
    private PmsBaseCatalog3Service pmsBaseCatalog3Service;

    @Reference
    private PmsBaseAttrInfoService pmsBaseAttrInfoService;

    @ApiOperation("获取一级分类")
    @GetMapping("/getPmsBaseCataLog1")
    public Message getPmsBaseCataLog1() {
        List<PmsBaseCatalog1> PmsBaseCatalog1List =  pmsBaseCatalog1Service.selectAll();
        return new Message(ResponseCodeType.SUCCESS, PmsBaseCatalog1List, true);
    }

    @ApiOperation("获取二级分类")
    @GetMapping("/getPmsBaseCataLog2")
    public Message getPmsBaseCataLog2(@RequestParam("catalog1Id") String catalog1Id) {
        List<PmsBaseCatalog2> PmsBaseCatalog2List = pmsBaseCatalog2Service.selectByCatalog1Id(catalog1Id);
        return new Message(ResponseCodeType.SUCCESS, PmsBaseCatalog2List, true);
    }

    @ApiOperation("获取三级分类")
    @GetMapping("/getPmsBaseCataLog3")
    public Message getPmsBaseCataLog3(@RequestParam("catalog2Id") String catalog2Id) {
        List<PmsBaseCatalog3> PmsBaseCatalog3List = pmsBaseCatalog3Service.selectByCatalog2Id(catalog2Id);
        return new Message(ResponseCodeType.SUCCESS, PmsBaseCatalog3List, true);
    }

    @ApiOperation("获取平台属性级分类")
    @GetMapping("/getPmsBaseAttrInfo")
    public Message getPmsBaseAttrInfo(@RequestParam("catalog3Id") String catalog3Id) {
        List<PmsBaseAttrInfo> pmsBaseAttrInfoList =  pmsBaseAttrInfoService.getPmsBaseAttrInfoByCatalog3Id(catalog3Id);
        return new Message(ResponseCodeType.SUCCESS, pmsBaseAttrInfoList, true);
    }

    @ApiOperation("更新一级分类")
    @GetMapping("/updatePmsBaseCataLog1")
    public Message updatePmsBaseCataLog1(@RequestParam("catalog1Id") String catalog1Id, String name) {
        if (StringUtils.isBlank(name) || StringUtils.isBlank(catalog1Id)) throw new NullPointerException("updatePmsBaseCataLog1 参数 id | name 为空");
        pmsBaseCatalog1Service.updateById(catalog1Id, name);
        return new Message(ResponseCodeType.SUCCESS, null, true);
    }

    @ApiOperation("更新二级分类")
    @GetMapping("/updatePmsBaseCataLog2")
    public Message updatePmsBaseCataLog2(@RequestParam("catalog2Id") String catalog2Id, @RequestParam("name") String name) {
        if (StringUtils.isBlank(name) || StringUtils.isBlank(catalog2Id)) throw new NullPointerException("updatePmsBaseCataLog2 参数  id | name 为空");
        pmsBaseCatalog2Service.updateById(catalog2Id, name);
        return new Message(ResponseCodeType.SUCCESS, null, true);
    }

    @ApiOperation("更新三级分类")
    @GetMapping("/updatePmsBaseCataLog3")
    public Message updatePmsBaseCataLog3(@RequestParam("catalog3Id") String catalog3Id, @RequestParam("name") String name) {
        if (StringUtils.isBlank(name) || StringUtils.isBlank(catalog3Id)) throw new NullPointerException("updatePmsBaseCataLog3 参数 id |  name 为空");
        pmsBaseCatalog3Service.updateById(catalog3Id, name);
        return new Message(ResponseCodeType.SUCCESS, null, true);
    }

    @ApiOperation("删除一级分类")
    @GetMapping("/deletePmsBaseCataLog1")
    public Message deletePmsBaseCataLog1(@RequestParam("catalog1Id") String catalog1Id){
        if (StringUtils.isBlank(catalog1Id)) throw new NullPointerException();
        pmsBaseCatalog1Service.deleteById(catalog1Id);
        return new Message(ResponseCodeType.SUCCESS, null, true);
    }

    @ApiOperation("删除二级分类")
    @GetMapping("/deletePmsBaseCataLog2")
    public Message deletePmsBaseCataLog2(@RequestParam("catalog2Id") String catalog2Id){
        if (StringUtils.isBlank(catalog2Id)) throw new NullPointerException();
        pmsBaseCatalog2Service.deleteById(catalog2Id);
        return new Message(ResponseCodeType.SUCCESS, null, true);
    }

    @ApiOperation("删除三级分类")
    @GetMapping("/deletePmsBaseCataLog3")
    public Message deletePmsBaseCataLog3(@RequestParam("catalog3Id") String catalog3Id){
        if (StringUtils.isBlank(catalog3Id)) throw new NullPointerException();
        pmsBaseCatalog3Service.deleteById(catalog3Id);
        return new Message(ResponseCodeType.SUCCESS, null, true);
    }

    @ApiOperation("添加一级分类")
    @GetMapping("/addPmsBaseCataLog1")
    public Message addPmsBaseCataLog1(@RequestParam("name") String name) {
        if (StringUtils.isBlank(name)) throw new NullPointerException();
        Message message = pmsBaseCatalog1Service.insertByNotNameRepetition(name);
        return message;
    }

    @ApiOperation("添加二级分类")
    @GetMapping("/addPmsBaseCataLog2")
    public Message addPmsBaseCataLog2(@RequestParam("name") String name, @RequestParam("catalog1Id") String catalog1Id) {
        if (StringUtils.isBlank(name) || StringUtils.isBlank(catalog1Id)) throw new NullPointerException();
        Message message = pmsBaseCatalog2Service.insertByNotNameRepetition(name, catalog1Id);
        return message;
    }

    @ApiOperation("添加三级分类")
    @GetMapping("/addPmsBaseCataLog3")
    public Message addPmsBaseCataLog3(@RequestParam("name") String name, @RequestParam("catalog2Id") String catalog2Id) {
        if (StringUtils.isBlank(name) || StringUtils.isBlank(catalog2Id)) throw new NullPointerException();
        Message message = pmsBaseCatalog3Service.insertByNotNameRepetition(name, catalog2Id);
        return message;
    }

}
