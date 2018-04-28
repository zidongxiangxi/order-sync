package com.xdchen.order.dao.provider;

import com.xdchen.order.model.Order;

import java.util.List;
import java.util.Map;

public class OrderDaoProvider {
    public String saveAll(Map map) {
        List<Order> configs = (List<Order>) map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("insert into order ");
        sb.append("(orderId, userId, nick, kuaidiCom, kuaidiNum, cargo, recAddr, buyerMobile, comment, consignTime, created, tbKuaidiCom, payment, payment, recState, recCity, recDistrict)");
        sb.append(" values ");
        String columns = "(#{list[{index}].orderId}, #{list[{index}].userId}, #{list[{index}].nick}, #{list[{index}].kuaidiCom}, #{list[{index}].kuaidiNum}, #{list[{index}].cargo}, #{list[{index}].recAddr}," +
                "#{list[{index}].buyerMobile}, #{list[{index}].comment}, #{list[{index}].consignTime}, #{list[{index}].created}, #{list[{index}].tbKuaidiCom}, #{list[{index}].payment}, #{list[{index}].payment}," +
                ", #{list[{index}].recState}, #{list[{index}].recCity}, #{list[{index}].recDistrict})";
        for (int i = 0; i < configs.size(); i++) {
            sb.append(columns.replaceAll("\\{index}", String.valueOf(i)));
            if (i < configs.size() - 1) {
                sb.append(",");
            }
        }

        return sb.toString();
    }
}
