package com.jy.orm.mybatis.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.jy.orm.mybatis.constants.Constant;
import com.jy.orm.mybatis.enums.SqlType;
import com.jy.orm.mybatis.exceptions.JyException;
import com.jy.orm.mybatis.mapping.MappedStatement;
import com.jy.orm.mybatis.session.Configuration;

/**
 * XML解析器
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-05-23 21:43
 */
public class XmlUtil {

    /**
     * 解析mapper.xml信息
     *
     * @param file
     *            文件
     * @param configuration
     *            JDBC连接信息
     */
    public static void readMapperXml(File file, Configuration configuration) {

        try {
            // 创建一个读取器
            SAXReader saxReader = new SAXReader();
            saxReader.setEncoding(Constant.CHARSET_UTF8);

            // 读取文件内容
            Document document = saxReader.read(file);

            // 获取xml中的根元素
            Element rootElement = document.getRootElement();

            // 不是beans根元素的，文件不对
            if (!Constant.XML_ROOT_LABEL.equals(rootElement.getName())) {
                throw new JyException("xxxMapper.xml 文件根元素不是mapper");
            }
            String namespace = rootElement.attributeValue(Constant.XML_SELECT_NAMESPACE);

            List<MappedStatement> statements = new ArrayList<>();

            for (Iterator iterator = rootElement.elementIterator(); iterator.hasNext();) {
                Element element = (Element) iterator.next();
                String elementName = element.getName();

                MappedStatement mappedStatement = new MappedStatement();

                if (SqlType.SELECT.getCode().equals(elementName)) {
                    String resultType = element.attributeValue(Constant.XML_SELECT_RESULT_TYPE);

                    mappedStatement.setResultType(resultType);
                    mappedStatement.setSqlCommandType(SqlType.SELECT);
                } else if (SqlType.UPDATE.getCode().equals(elementName)) {
                    mappedStatement.setSqlCommandType(SqlType.UPDATE);
                } else if (SqlType.INSERT.getCode().equals(elementName)) {
                    mappedStatement.setSqlCommandType(SqlType.INSERT);
                } else if (SqlType.DELETE.getCode().equals(elementName)) {
                    mappedStatement.setSqlCommandType(SqlType.DELETE);
                } else {
                    mappedStatement.setSqlCommandType(SqlType.UNKNOWN);
                    throw new JyException(String.format("不支持XML标签【%s】的解析。", elementName));
                }
                // 设置SQL的唯一ID
                String sqlId = namespace + "." + element.attributeValue(Constant.XML_ELEMENT_ID);

                mappedStatement.setSqlId(sqlId);
                mappedStatement.setNamespace(namespace);
                mappedStatement.setSql(element.getStringValue().trim());
                statements.add(mappedStatement);

                System.out.println(mappedStatement);
                configuration.addMappedStatement(sqlId, mappedStatement);

                // mapperRegistry中生产一个mapper对应的代理工厂
                configuration.addMapper(Class.forName(namespace));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
