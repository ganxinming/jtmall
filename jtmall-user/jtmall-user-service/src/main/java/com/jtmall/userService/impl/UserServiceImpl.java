package com.jtmall.userService.impl;

import com.alibaba.fastjson.JSON;
import com.jtmall.service.RedisService;
import com.jtmall.userInterface.UserService;
import com.jtmall.userPojo.UmsMember;
import com.jtmall.userPojo.UmsMemberExample;
import com.jtmall.userPojo.UmsMemberReceiveAddress;
import com.jtmall.userService.mapper.UmsMemberMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service(version = "${demo.service.user}")
public class UserServiceImpl implements UserService {

    @Autowired
    UmsMemberMapper userMapper;

//    @Autowired
//    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Reference(version = "${demo.service.manager}")
    private RedisService redisUtil;

    @Override
    public List<UmsMember> getAllUser() {

        List<UmsMember> umsMembers = userMapper.selectAllUser();//userMapper.selectAllUser();

        return umsMembers;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
        return null;
    }

    @Override
    public UmsMember login(UmsMember umsMember) {

        String umsMemberStr = redisUtil.get("user:" + umsMember.getPassword()+umsMember.getUsername() + ":info").toString();

        if (StringUtils.isNotBlank(umsMemberStr)) {
                    // 密码正确
            UmsMember umsMemberFromCache = JSON.parseObject(umsMemberStr, UmsMember.class);
            return umsMemberFromCache;
        }
            UmsMember umsMemberFromDb =loginFromDb(umsMember);
            if(umsMemberFromDb!=null){
                redisUtil.set("user:" + umsMember.getPassword()+umsMember.getUsername() + ":info", JSON.toJSONString(umsMemberFromDb),24L, TimeUnit.HOURS);
            }
            return umsMemberFromDb;

    }

    @Override
    public void addUserToken(String token, Integer memberId) {
        redisUtil.set("user:"+memberId+":token",token,2L,TimeUnit.HOURS);
    }

    @Override
    public UmsMember addOauthUser(UmsMember umsMember) {
        userMapper.insertSelective(umsMember);

        return umsMember;
    }

    @Override
    public UmsMember checkOauthUser(UmsMember umsCheck) {
//        UmsMember umsMember = userMapper.selectOne(umsCheck);

        UmsMemberExample example=new UmsMemberExample();
        example.createCriteria().andSourceUidEqualTo(umsCheck.getSourceUid());
        List<UmsMember> list=userMapper.selectByExample(example);
        if (list == null || list.size() ==0){
            return  null;
        }
        return list.get(0);
    }

    @Override
    public UmsMember getOauthUser(UmsMember umsMemberCheck) {
        UmsMemberExample example=new UmsMemberExample();
        example.createCriteria().andSourceUidEqualTo(umsMemberCheck.getSourceUid());
        List<UmsMember> list=userMapper.selectByExample(example);
        if (list == null || list.size() ==0){
            return  null;
        }
        return list.get(0);
    }

    @Override
    public UmsMemberReceiveAddress getReceiveAddressById(String receiveAddressId) {
//        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
//        umsMemberReceiveAddress.setId(receiveAddressId);
//        UmsMemberReceiveAddress umsMemberReceiveAddress1 = umsMemberReceiveAddressMapper.selectOne(umsMemberReceiveAddress);
//        return umsMemberReceiveAddress1;
        return null;
    }

    private UmsMember loginFromDb(UmsMember umsMember) {

        UmsMember umsMembers = userMapper.selectByPrimaryKey(1);

        return umsMembers;

    }
}
