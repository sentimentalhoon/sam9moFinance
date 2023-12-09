package com.sam9mo.finance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class KospiCode {

    @Id
    public String abbreviationCode;
    public String standardCode;
    public String koreanName;
    public String groupCode;
    public String marketCapSize;
    public String indexIndustryMajor;
    public String indexIndustryMedium;
    public String indexIndustryMinor;
    public String manufacturing;
    public String lowLiquidity;
    public String governanceIndexStock;
    public String kOSPI200SectorIndustry;
    public String kospi100;
    public String kospi50;
    public String krx;
    public String etp;
    public String eLWIssuance;
    public String krx100;
    public String kRXAutomobile;
    public String kRXSemiconductor;
    public String kRXBio;
    public String kRXBank;
    public String spac;
    public String kRXEnergyChemical;
    public String kRXSteel;
    public String shortTermOverheated;
    public String kRXMediaCommunication;
    public String kRXConstruction;
    public String non1;
    public String kRXSecurities;
    public String kRXShip;
    public String kRXSectorInsurance;
    public String kRXSectorTransportation;
    public String sri;
    public String basePrice;
    public String tradingUnit;
    public String afterHoursUnit;
    public String tradingSuspension;
    public String cleanupTrading;
    public String managementStock;
    public String marketWarning;
    public String warningNotice;
    public String insincereDisclosure;
    public String circumventionListing;
    public String lockDivision;
    public String faceValueChange;
    public String capitalIncrease;
    public String marginRate;
    public String creditPossible;
    public String creditPeriod;
    public String prevDayTradingVolume;
    public String faceValue;
    public String listingDate;
    public String listedShares;
    public String capital;
    public String settlementMonth;
    public String publicOfferingPrice;
    public String preferredStock;
    public String shortSellingOverheated;
    public String abnormalRise;
    public String krx300;
    public String kospi;
    public String sales;
    public String operatingProfit;
    public String currentProfit;
    public String netProfit;
    public String roe;
    public String baseYearMonth;
    public String marketCap;
    public String groupCompanyCode;
    public String companyCreditLimitExceeded;
    public String collateralLoanPossible;
    public String majorShareholderPossible;
}
