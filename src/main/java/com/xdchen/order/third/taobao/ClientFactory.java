package com.xdchen.order.third.taobao;

import com.taobao.api.Constants;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.xdchen.order.config.JingdongConfig;
import com.xdchen.order.config.TaobaoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientFactory {
    private TaobaoConfig taobaoConfig;
    private JingdongConfig jingdongConfig;
    private DefaultTaobaoClient tbXmlClient;
    private DefaultTaobaoClient tbJsonClient;
    private DefaultTaobaoClient tbXmlClients;
    private DefaultTaobaoClient tbJsonClients;

    @Autowired
    public ClientFactory(TaobaoConfig taobaoConfig, JingdongConfig jingdongConfig) {
        this.taobaoConfig = taobaoConfig;
        this.jingdongConfig = jingdongConfig;
        tbXmlClient = new DefaultTaobaoClient(taobaoConfig.getTopBoxApiUrl(),
                taobaoConfig.getTopBoxAppKey(), taobaoConfig.getTopBoxAppSecret(),
                Constants.FORMAT_XML);

        tbJsonClient = new DefaultTaobaoClient(taobaoConfig.getTopBoxApiUrl(),
                taobaoConfig.getTopBoxAppKey(), taobaoConfig.getTopBoxAppSecret(),
                Constants.FORMAT_XML);

        tbXmlClients = new DefaultTaobaoClient(taobaoConfig.getTopSecurityUrl(),
                taobaoConfig.getTopBoxAppKey(), taobaoConfig.getTopBoxAppSecret(),
                Constants.FORMAT_XML);

        tbJsonClients = new DefaultTaobaoClient(taobaoConfig.getTopSecurityUrl(),
                taobaoConfig.getTopBoxAppKey(), taobaoConfig.getTopBoxAppSecret(),
                Constants.FORMAT_XML);

    }


    /**
     * 创建TaobaoClient对象，默认对象格式为XML
     * @param format
     * 		数据加密等接口，强制 要求使用https调用  (升级https换了地址)
     * 		http://gw.api.taobao.com/router/rest  -->	https://eco.taobao.com/router/rest
     * 		com.taobao.api.Constants.FORMAT_JSON
     * 		com.taobao.api.Constants.FORMAT_XML
     * @return
     */
    public TaobaoClient getClient(String format) {
        if (Constants.FORMAT_JSON.equals(format)) {
            return tbJsonClient;
        }
        return tbXmlClient;

    }

    /**
     * 创建TaobaoClient对象，默认对象格式为XML
     * @param format
     *
     * 		com.taobao.api.Constants.FORMAT_JSON
     * 		com.taobao.api.Constants.FORMAT_XML
     * @return
     */
    public TaobaoClient getHttpsClient(String format) {
        if (Constants.FORMAT_JSON.equals(format)) {
            return tbJsonClients;
        }
        return tbXmlClients;

    }

    public TaobaoConfig getTaobaoConfig() {
        return taobaoConfig;
    }

    public void setTaobaoConfig(TaobaoConfig taobaoConfig) {
        this.taobaoConfig = taobaoConfig;
    }

    public JingdongConfig getJingdongConfig() {
        return jingdongConfig;
    }

    public void setJingdongConfig(JingdongConfig jingdongConfig) {
        this.jingdongConfig = jingdongConfig;
    }
}
