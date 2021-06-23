package com.jy.orm.mybatis.constants;


/**
 * 常数变量
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-05-22 16:50
 */
public interface Constant {



    /**
     * UTF-8编码
     */
    String CHARSET_UTF8 = "UTF-8";

    /***********在properties文件中配置信息***********************/
    String MAPPER_LOCATION = "mapper.location";
    String DB_DRIVER_CONF = "db.driver";
    String DB_URL_CONF = "db.url";
    String DB_USERNAME_CONF = "db.username";
    String DB_PASSWORD = "db.password";

    /*********************mapper xml*****************************/
    /**
     * mapper文件后缀
     */
    String MAPPER_FILE_SUFFIX = ".xml";
    String XML_ROOT_LABEL = "mapper";

    String XML_ELEMENT_ID = "id";

    String XML_SELECT_NAMESPACE = "namespace";

    String XML_SELECT_RESULT_TYPE = "resultType";




















}
