package com.sam9mo.finance.entity;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StockHokaDomestic {

    public String id;
    public String stockCode;
    public String tradeTime;
    public String askPrice10;
    public String askPrice09;
    public String askPrice08;
    public String askPrice07;
    public String askPrice06;
    public String askPrice05;
    public String askPrice04;
    public String askPrice03;
    public String askPrice02;
    public String askPrice01;
    public String askSize10;
    public String askSize09;
    public String askSize08;
    public String askSize07;
    public String askSize06;
    public String askSize05;
    public String askSize04;
    public String askSize03;
    public String askSize02;
    public String askSize01;
    public String bidPrice01;
    public String bidPrice02;
    public String bidPrice03;
    public String bidPrice04;
    public String bidPrice05;
    public String bidPrice06;
    public String bidPrice07;
    public String bidPrice08;
    public String bidPrice09;
    public String bidPrice10;
    public String bidSize01;
    public String bidSize02;
    public String bidSize03;
    public String bidSize04;
    public String bidSize05;
    public String bidSize06;
    public String bidSize07;
    public String bidSize08;
    public String bidSize09;
    public String bidSize10;
    public String totalAskSize;
    public String totalBidSize;

}
