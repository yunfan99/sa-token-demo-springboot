package com.example.satokendemospringboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.satokendemospringboot.entity.Menu;
import com.example.satokendemospringboot.service.MenuService;
import com.example.satokendemospringboot.mapper.MenuMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author hob
* @description 针对表【tb_menu】的数据库操作Service实现
* @createDate 2023-05-10 12:29:26
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService {

}




