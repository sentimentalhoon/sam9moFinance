package com.sam9mo.finance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class KosdaqCode {
    @Id
    public String abbreviationCode;
    public String standardCode;
    public String koreanName;
    public String securityGroupCode;
    public String marketCapSizeCodeListed;
    public String indexIndustryMajorCode;
    public String indexIndustryMediumCode;
    public String indexIndustryMinorCode;
    public String ventureCompanyYN;
    public String lowLiquidityStockYN;
    public String kRXStockYN;
    public String etpproductCode;
    public String kRX100StockYN;
    public String kRXAutomobileYN;
    public String kRXSemiconductorYN;
    public String kRXBioYN;
    public String kRXBankYN;
    public String companyTakeoverPurposeYN;
    public String kRXEnergyChemicalYN;
    public String kRXSteelYN;
    public String shortTermOverheatedStockCode;
    public String kRXMediaCommunicationYN;
    public String kRXConstructionYN;
    public String kOSDAQInvestmentWarningRevocationYN;
    public String kRXSecuritiesDivision;
    public String kRXShipDivision;
    public String kRXSectorIndexInsuranceYN;
    public String kRXSectorIndexTransportationYN;
    public String kOSDAQ150IndexYN;
    public String stockBasePrice;
    public String regularMarketTradingUnit;
    public String afterHoursMarketTradingUnit;
    public String tradingSuspensionYN;
    public String cleanupTradingYN;
    public String managementStockYN;
    public String marketWarningCode;
    public String marketWarningRiskNoticeYN;
    public String insincereDisclosureYN;
    public String circumventionListingYN;
    public String lockCode;
    public String faceValueChangeCode;
    public String capitalIncreaseCode;
    public String marginRate;
    public String creditOrderPossibleYN;
    public String creditPeriod;
    public String prevDayTradingVolume;
    public String stockFaceValue;
    public String stockListingDate;
    public String listedSharesThousand;
    public String capital;
    public String settlementMonth;
    public String publicOfferingPrice;
    public String preferredStockCode;
    public String shortSellingOverheatedStockYN;
    public String abnormalRiseStockYN;
    public String kRX300StockYN;
    public String sales;
    public String operatingProfit;
    public String currentProfit;
    public String shortTermNetProfit;
    public String roe;
    public String baseYearMonth;
    public String prevDayBaseMarketCapBillion;
    public String groupCompanyCode;
    public String companyCreditLimitExceededYN;
    public String collateralLoanPossibleYN;
    public String majorShareholderPossibleYN;
}
