// This Java source file was generated on 2020-09-06 13:40:52 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.account;

import java.util.Currency;

public class UserAttributes {
    private Integer userID;
    private String username;
    private String title;
    private String name;
    private String email;
    private String divisionAbbreviation;
    private String languageAbbreviation;
    private Currency homeCurrency;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDivisionAbbreviation() {
        return divisionAbbreviation;
    }

    public void setDivisionAbbreviation(String divisionAbbreviation) {
        this.divisionAbbreviation = divisionAbbreviation;
    }

    public String getLanguageAbbreviation() {
        return languageAbbreviation;
    }

    public void setLanguageAbbreviation(String languageAbbreviation) {
        this.languageAbbreviation = languageAbbreviation;
    }

    public Currency getHomeCurrency() {
        return homeCurrency;
    }

    public void setHomeCurrency(Currency homeCurrency) {
        this.homeCurrency = homeCurrency;
    }

}
