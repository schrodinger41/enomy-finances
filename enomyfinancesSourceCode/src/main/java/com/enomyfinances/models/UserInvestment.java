package com.enomyfinances.models;
import javax.persistence.*;

;

@Entity
@Table (name="userInvestments")
public class UserInvestment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "investmentId")
    private Long investmentId;

    @Column(name = "investmentType", nullable = false)
    private String investmentType;

    @Column(name = "initialLumpSum", nullable = false)
    private int initialLumpSum;

    @Column(name = "monthlyInvestment", nullable = false)
    private int monthlyInvestment;

    @Column(name = "yearlyInvestment", nullable = false)
    private int yearlyInvestment;
    @Column(name = "oneYearReturn")
    private double oneYearReturn;
    @Column(name = "fiveYearsReturn")
    private double fiveYearsReturn;
    @Column(name = "tenYearsReturn")
    private double tenYearsReturn;
    @Column(name = "userId")
    private long userId;
    
    
    
    
    @Column(name = "oneYearProfit")
    private double oneyeartotalprofit;
    @Column(name = "fiveYearsProfit")
    private double fiveyeartotalprofit;
    @Column(name = "tenYearsProfit")
    private double tenyeartotalprofit;
    @Column(name = "oneYearFees")
    private double oneyeartotalfees;
    @Column(name = "fiveYearsFees")
    private double fiveyeartotalfees;
    @Column(name = "tenYearsFees")
    private double tenyeartotalfees;
    @Column(name = "oneYearTaxes")
    private double oneyeartotaltaxes;
    @Column(name = "fiveYearsTaxes")
    private double fiveyeartotaltaxes;
    @Column(name = "tenYearsTaxes")
    private double tenyeartotaltaxes;
    

   


    public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Long getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(Long investmentId) {
        this.investmentId = investmentId;
    }

    public String getInvestmentType() {
        return investmentType;
    }

    public void setInvestmentType(String investmentType) {
        this.investmentType = investmentType;
    }

    public int getInitialLumpSum() {
        return initialLumpSum;
    }

    public void setInitialLumpSum(int initialLumpSum) {
        this.initialLumpSum = initialLumpSum;
    }

    public int getMonthlyInvestment() {
        return monthlyInvestment;
    }

    public void setMonthlyInvestment(int monthlyInvestment) {
        this.monthlyInvestment = monthlyInvestment;
    }

    public int getYearlyInvestment() {
        return yearlyInvestment;
    }

    public void setYearlyInvestment(int yearlyInvestment) {
        this.yearlyInvestment = yearlyInvestment;
    }

	public void setUser(User user) {
		// TODO Auto-generated method stub
		
	}
	public double getOneYearReturn() {
	    return oneYearReturn;
	}

    public void setOneYearReturn(double oneYearReturn) {
        this.oneYearReturn = oneYearReturn;
    }

    public double getFiveYearsReturn() {
        return fiveYearsReturn;
    }

    public void setFiveYearsReturn(double fiveYearsReturn) {
        this.fiveYearsReturn = fiveYearsReturn;
    }

    public double getTenYearsReturn() {
        return tenYearsReturn;
    }

    public void setTenYearsReturn(double tenYearsReturn) {
        this.tenYearsReturn = tenYearsReturn;
    }

	public double getOneyeartotalprofit() {
		return oneyeartotalprofit;
	}

	public void setOneyeartotalprofit(double oneyeartotalprofit) {
		this.oneyeartotalprofit = oneyeartotalprofit;
	}

	public double getFiveyeartotalprofit() {
		return fiveyeartotalprofit;
	}

	public void setFiveyeartotalprofit(double fiveyeartotalprofit) {
		this.fiveyeartotalprofit = fiveyeartotalprofit;
	}

	public double getTenyeartotalprofit() {
		return tenyeartotalprofit;
	}

	public void setTenyeartotalprofit(double tenyeartotalprofit) {
		this.tenyeartotalprofit = tenyeartotalprofit;
	}

	public double getOneyeartotalfees() {
		return oneyeartotalfees;
	}

	public void setOneyeartotalfees(double oneyeartotalfees) {
		this.oneyeartotalfees = oneyeartotalfees;
	}

	public double getFiveyeartotalfees() {
		return fiveyeartotalfees;
	}

	public void setFiveyeartotalfees(double fiveyeartotalfees) {
		this.fiveyeartotalfees = fiveyeartotalfees;
	}

	public double getTenyeartotalfees() {
		return tenyeartotalfees;
	}

	public void setTenyeartotalfees(double tenyeartotalfees) {
		this.tenyeartotalfees = tenyeartotalfees;
	}

	public double getOneyeartotaltaxes() {
		return oneyeartotaltaxes;
	}

	public void setOneyeartotaltaxes(double oneyeartotaltaxes) {
		this.oneyeartotaltaxes = oneyeartotaltaxes;
	}

	public double getFiveyeartotaltaxes() {
		return fiveyeartotaltaxes;
	}

	public void setFiveyeartotaltaxes(double fiveyeartotaltaxes) {
		this.fiveyeartotaltaxes = fiveyeartotaltaxes;
	}

	public double getTenyeartotaltaxes() {
		return tenyeartotaltaxes;
	}

	public void setTenyeartotaltaxes(double tenyeartotaltaxes) {
		this.tenyeartotaltaxes = tenyeartotaltaxes;
	}
	
	
    
}
