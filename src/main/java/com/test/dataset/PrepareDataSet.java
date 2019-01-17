package com.test.dataset;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrepareDataSet {
    public static void main(String[] a){
        makeDisputeCancellable(Arrays.asList(
                "000000170100002014160000100001",
                "000000170100002014170000100001",
                "000000170100002014180000100001",
                "000000170100002014190000100001",
                "000000170100002014200000100001",
                "000000170100002014210000100001",
                "000000170100002014220000100001",
                "000000170100002014230000100001",
                "000000170100002014240000100001"));

    }

    private static void makeDisputeCancellable(List<String> paymentIds){
        String url = "jdbc:oracle:thin:@10.63.66.100:1521:locdb";
        String username = "EPS";
        String password = "wDIiAi216";
        String sql = "update OPR_PAYMENTATTEMPT set statusid=1500,paymentamount=2980, paymentcurrencycode='EUR' where merchantid=? and orderid=?  and effortid=? and attemptid=?";
        StringBuilder querySQL = new StringBuilder("Select statusid,orderid,merchantid from OPR_PAYMENTATTEMPT where merchantid=? and orderid in (");
        List<Integer> orderIds = new ArrayList<>();
        String merchantid = null;
        try (Connection connection =  DriverManager.getConnection(url, username, password)){
            connection.setAutoCommit(false);


            for (String paymentID : paymentIds) {
                merchantid = Integer.valueOf(paymentID.substring(0, 10)).toString();
                String orderid = Integer.valueOf(paymentID.substring(10, 20)).toString();
                orderIds.add(Integer.valueOf(orderid));
                String effortid = Integer.valueOf(paymentID.substring(20, 25)).toString();
                String attemptid = Integer.valueOf(paymentID.substring(25, 30)).toString();

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, Integer.valueOf(merchantid));
                preparedStatement.setInt(2, Integer.valueOf(orderid));
                preparedStatement.setInt(3, Integer.valueOf(effortid));
                preparedStatement.setInt(4, Integer.valueOf(attemptid));

                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
            connection.commit();

            for (int count=0; count < orderIds.size() ; count++){
                if (count == orderIds.size() - 1){
                   querySQL.append("?");
                }else{
                    querySQL.append("?").append(",");
                }
            }
            querySQL.append(")");



            PreparedStatement queryPreparedStatement = connection.prepareStatement(querySQL.toString());
            queryPreparedStatement.setInt(1,Integer.valueOf(merchantid));
            for (int count = 1 ; count <= orderIds.size(); count++){
                queryPreparedStatement.setInt(count+1,orderIds.get(count-1));
            }


            ResultSet rs = queryPreparedStatement.executeQuery();
            System.out.println("STATUSID           ORDERID        MERCHANTID");
            while (rs.next()){
                int statusId = rs.getInt(1);
                int orderId = rs.getInt(2);
                int merchantId = rs.getInt(3);
                System.out.println(statusId+"               "+orderId+"             "+merchantId);
            }

            rs.close();
            queryPreparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
