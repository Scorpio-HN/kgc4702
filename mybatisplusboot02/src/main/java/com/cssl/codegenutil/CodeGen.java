package com.cssl.codegenutil;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGen {

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        // 选择 freemarker 引擎，默认 Velocity
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 全局配置
        GlobalConfig  gc = new GlobalConfig();
        gc.setAuthor("老章");
        //D:\\Resources\\IdealPro\\Y2-LG21\\kong\\src\\main\\java
        gc.setOutputDir("D:\\Resources\\IdealPro\\kgc4702\\caolaoban\\src\\main\\java");
        gc.setFileOverride(false);// 是否覆盖同名文件，默认是false
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        //设置到模板
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("ROOT");
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatis_plus?useUnicode=true&serverTimezone=UTC&characterEncoding=utf8");
        //设置数据源  读取数据表
        mpg.setDataSource(dsc);



        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.cssl");
        // pc.setModuleName("test");
        mpg.setPackageInfo(pc);


        // 数据源配置 表设置
        StrategyConfig strategy = new StrategyConfig();
        //strategy.setTablePrefix(new String[] { "buy_" });// // 此处可以修改为您的表前缀׺
        strategy.setNaming(NamingStrategy.no_change);// 表名生成策略 默认是全部表
        //strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setInclude(new String[] { "tb_student","user","product"}); // 表名生成策略 指定表

        mpg.setStrategy(strategy);



        // 执行生成
        mpg.execute();
    }
}
