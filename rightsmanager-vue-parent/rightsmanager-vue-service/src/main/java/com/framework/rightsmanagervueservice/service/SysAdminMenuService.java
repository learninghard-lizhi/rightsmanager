package com.framework.rightsmanagervueservice.service;

import com.framework.rightsmanagervueservice.base.BaseServiceImpl;
import com.framework.rightsmanagervueservice.dao.SysAdminGroupMapper;
import com.framework.rightsmanagervueservice.dao.SysAdminMenuMapper;
import com.framework.rightsmanagervueservice.model.SysAdminGroup;
import com.framework.rightsmanagervueservice.model.SysAdminMenu;
import com.framework.rightsmanagervueservice.util.BeanToMapUtil;
import com.framework.rightsmanagervueservice.util.Category;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lizhi on 2017/11/6.
 */
@Service
public class SysAdminMenuService extends BaseServiceImpl<SysAdminMenu> {

    @Autowired
    private SysAdminMenuMapper sysAdminMenuDao;
    @Autowired
    private SysAdminGroupMapper sysAdminGroupDao;

    @Override
    public Mapper<SysAdminMenu> getMapper() {
        return sysAdminMenuDao;
    }

    /**
     * 获取用户对应的菜单
     * @param userId
     * @return
     */
    public List<SysAdminMenu> getTreeMenuByUserId(Integer userId){
        //查看用户对应未禁用的菜单
        List<SysAdminMenu> menusList = getMenusByUserId(userId, (byte)1);
        //处理树菜单
        List<SysAdminMenu> menusTreeList = this.buildByRecursiveTree(menusList);
        return menusTreeList;
    }

    /**
     * 根据用户id查询所属的菜单信息
     * @param userId 用户id
     * @param status 状态 0：禁用，1：启用，null：全部
     * @return
     */
    private List<SysAdminMenu> getMenusByUserId(Integer userId, Byte status) {
        List<SysAdminMenu> menusList;
        //判断是否为管理员
        if(userId.equals(1)) {
            SysAdminMenu menu = new SysAdminMenu();
            menu.setStatus(status);
            menusList = this.select(menu);
        } else {
            //查询分组
            List<SysAdminGroup> groupsList = sysAdminGroupDao.selectByUserId(userId, status);
            StringBuffer ruleIds = new StringBuffer();
            for(SysAdminGroup group : groupsList) {
                if(ruleIds.length() == 0) {
                    ruleIds.append(group.getRules());
                } else {
                    ruleIds.append(",").append(group.getRules());
                }
            }
            //查询菜单
            menusList =  sysAdminMenuDao.selectInRuleIds(ruleIds.toString(), 1);
        }

        return menusList;
    }

    /**
     * 使用递归方法建树
     * @param rootSysAdminMenus 原始的数据
     * @return
     */
    private List<SysAdminMenu> buildByRecursiveTree(List<SysAdminMenu> rootSysAdminMenus){
        List<SysAdminMenu> trees = new ArrayList<SysAdminMenu>();
        for(SysAdminMenu menu : rootSysAdminMenus) {
            if ("0".equals(menu.getPid().toString())) {
                trees.add(getChild(menu,rootSysAdminMenus, 1));
            }
        }
        return trees;
    }

    /**
     * 递归查找子菜单
     *
     * @param treeMenu
     *            当前菜单id
     * @param treeNodes
     *            要查找的列表
     * @param level
     * 			  级别
     * @return
     */
    private SysAdminMenu getChild(SysAdminMenu treeMenu, List<SysAdminMenu> treeNodes, int level) {
        treeMenu.setSelected(false);
        treeMenu.setLevel(level);
        for (SysAdminMenu it : treeNodes) {
            if (treeMenu.getId().equals(it.getPid())) {
                if (treeMenu.getChild() == null) {
                    treeMenu.setChild(new ArrayList<>());
                }
                treeMenu.getChild().add(getChild(it, treeNodes, level + 1));
            }
        }
        return treeMenu;
    }


    /**
     * 查询对应用户Id的菜单
     * @param userId
     * @return
     */
    public List<Map<String, Object>> getDataList(Integer userId, Byte status) {
        List<SysAdminMenu> rootSysAdminMenus = this.getMenusByUserId(userId, status);
        Map<String, String> fields = Maps.newHashMap();
        fields.put("cid", "id");
        fields.put("fid", "pid");
        fields.put("name", "title");
        fields.put("fullname", "title");
        List<Map<String, Object>> rawList = Lists.newArrayList();
        rootSysAdminMenus.forEach((m)->{
            rawList.add(BeanToMapUtil.convertBean(m));
        });
        Category cate = new Category(fields, rawList);
        return cate.getList(Integer.valueOf("0"));
    }
}
