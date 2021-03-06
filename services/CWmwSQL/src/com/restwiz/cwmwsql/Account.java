/*Copyright (c) 2015-2016 medicalwizard.com.au All Rights Reserved.
 This software is the confidential and proprietary information of medicalwizard.com.au You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with medicalwizard.com.au*/
package com.restwiz.cwmwsql;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Account generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`account`")
public class Account implements Serializable {

    private String accountno;
    private int idNo;
    private String acctype;
    private String acName;
    private String contact;
    private String position;
    private String phoneAh;
    private String business;
    private String acn;
    private String phoneBh;
    private String fax;
    private String address1;
    private String address2;
    private String suburb;
    private String state;
    private String postcode;
    private String invTerms;
    private String comments;
    private String bankAc;
    private String bank;
    private String branch;
    private String mainfile;
    private String mainfield;
    private byte invduedays = 0;
    private short maxinvlns = 0;
    private String providerno;
    private String definvmsg;
    private String invprefix;
    private String rctprefix;
    private boolean issuercts;
    private boolean issueinvs;
    private String tradeactyp;
    private String accescode;
    private short osageslot1 = 0;
    private short osageslot2 = 0;
    private short osageslot3 = 0;
    private String ltrHead;
    private String watchout;
    private boolean indivinvcs;
    private String status;
    private boolean nocrcards;
    private String abn;
    private String email;
    private byte feeposspec = 0;
    private String prfcomunic;
    private boolean ok2email;
    private String lastbachno;
    private String lasttrnsno;
    private String hiccustno;
    private boolean noautoupdt;
    private LocalDateTime nostmttill;
    private String nostmtresn;
    private LocalDateTime acdob;
    private String acsurname;
    private String acgivennme;
    private String actitle;
    private String acothRef1;
    private String acothRef2;
    private boolean bilinAgnt;
    private String mid;

    @Id
    @Column(name = "`accountno`", nullable = false, length = 10)
    public String getAccountno() {
        return this.accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    @Column(name = "`IdNo`", nullable = false, scale = 0, precision = 10)
    public int getIdNo() {
        return this.idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    @Column(name = "`acctype`", nullable = false, length = 10)
    public String getAcctype() {
        return this.acctype;
    }

    public void setAcctype(String acctype) {
        this.acctype = acctype;
    }

    @Column(name = "`ac_name`", nullable = false, length = 87)
    public String getAcName() {
        return this.acName;
    }

    public void setAcName(String acName) {
        this.acName = acName;
    }

    @Column(name = "`contact`", nullable = false, length = 30)
    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Column(name = "`position`", nullable = false, length = 20)
    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Column(name = "`phone_ah`", nullable = false, length = 14)
    public String getPhoneAh() {
        return this.phoneAh;
    }

    public void setPhoneAh(String phoneAh) {
        this.phoneAh = phoneAh;
    }

    @Column(name = "`business`", nullable = false, length = 50)
    public String getBusiness() {
        return this.business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    @Column(name = "`acn`", nullable = false, length = 12)
    public String getAcn() {
        return this.acn;
    }

    public void setAcn(String acn) {
        this.acn = acn;
    }

    @Column(name = "`phone_bh`", nullable = false, length = 14)
    public String getPhoneBh() {
        return this.phoneBh;
    }

    public void setPhoneBh(String phoneBh) {
        this.phoneBh = phoneBh;
    }

    @Column(name = "`fax`", nullable = false, length = 14)
    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Column(name = "`address1`", nullable = false, length = 30)
    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Column(name = "`address2`", nullable = false, length = 20)
    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Column(name = "`suburb`", nullable = false, length = 20)
    public String getSuburb() {
        return this.suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    @Column(name = "`state`", nullable = false, length = 3)
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "`postcode`", nullable = false, length = 4)
    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Column(name = "`inv_terms`", nullable = false, length = 20)
    public String getInvTerms() {
        return this.invTerms;
    }

    public void setInvTerms(String invTerms) {
        this.invTerms = invTerms;
    }

    @Column(name = "`comments`", nullable = false, length = 2147483647)
    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Column(name = "`bank_ac`", nullable = false, length = 15)
    public String getBankAc() {
        return this.bankAc;
    }

    public void setBankAc(String bankAc) {
        this.bankAc = bankAc;
    }

    @Column(name = "`bank`", nullable = false, length = 10)
    public String getBank() {
        return this.bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Column(name = "`branch`", nullable = false, length = 25)
    public String getBranch() {
        return this.branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Column(name = "`mainfile`", nullable = false, length = 8)
    public String getMainfile() {
        return this.mainfile;
    }

    public void setMainfile(String mainfile) {
        this.mainfile = mainfile;
    }

    @Column(name = "`mainfield`", nullable = false, length = 10)
    public String getMainfield() {
        return this.mainfield;
    }

    public void setMainfield(String mainfield) {
        this.mainfield = mainfield;
    }

    @Column(name = "`invduedays`", nullable = false, scale = 0, precision = 2)
    public byte getInvduedays() {
        return this.invduedays;
    }

    public void setInvduedays(byte invduedays) {
        this.invduedays = invduedays;
    }

    @Column(name = "`maxinvlns`", nullable = false, scale = 0, precision = 5)
    public short getMaxinvlns() {
        return this.maxinvlns;
    }

    public void setMaxinvlns(short maxinvlns) {
        this.maxinvlns = maxinvlns;
    }

    @Column(name = "`providerno`", nullable = false, length = 14)
    public String getProviderno() {
        return this.providerno;
    }

    public void setProviderno(String providerno) {
        this.providerno = providerno;
    }

    @Column(name = "`definvmsg`", nullable = false, length = 2147483647)
    public String getDefinvmsg() {
        return this.definvmsg;
    }

    public void setDefinvmsg(String definvmsg) {
        this.definvmsg = definvmsg;
    }

    @Column(name = "`invprefix`", nullable = false, length = 2)
    public String getInvprefix() {
        return this.invprefix;
    }

    public void setInvprefix(String invprefix) {
        this.invprefix = invprefix;
    }

    @Column(name = "`rctprefix`", nullable = false, length = 2)
    public String getRctprefix() {
        return this.rctprefix;
    }

    public void setRctprefix(String rctprefix) {
        this.rctprefix = rctprefix;
    }

    @Column(name = "`issuercts`", nullable = false)
    public boolean isIssuercts() {
        return this.issuercts;
    }

    public void setIssuercts(boolean issuercts) {
        this.issuercts = issuercts;
    }

    @Column(name = "`issueinvs`", nullable = false)
    public boolean isIssueinvs() {
        return this.issueinvs;
    }

    public void setIssueinvs(boolean issueinvs) {
        this.issueinvs = issueinvs;
    }

    @Column(name = "`tradeactyp`", nullable = false, length = 1)
    public String getTradeactyp() {
        return this.tradeactyp;
    }

    public void setTradeactyp(String tradeactyp) {
        this.tradeactyp = tradeactyp;
    }

    @Column(name = "`accescode`", nullable = false, length = 87)
    public String getAccescode() {
        return this.accescode;
    }

    public void setAccescode(String accescode) {
        this.accescode = accescode;
    }

    @Column(name = "`osageslot1`", nullable = false, scale = 0, precision = 3)
    public short getOsageslot1() {
        return this.osageslot1;
    }

    public void setOsageslot1(short osageslot1) {
        this.osageslot1 = osageslot1;
    }

    @Column(name = "`osageslot2`", nullable = false, scale = 0, precision = 3)
    public short getOsageslot2() {
        return this.osageslot2;
    }

    public void setOsageslot2(short osageslot2) {
        this.osageslot2 = osageslot2;
    }

    @Column(name = "`osageslot3`", nullable = false, scale = 0, precision = 3)
    public short getOsageslot3() {
        return this.osageslot3;
    }

    public void setOsageslot3(short osageslot3) {
        this.osageslot3 = osageslot3;
    }

    @Column(name = "`ltr_head`", nullable = false, length = 14)
    public String getLtrHead() {
        return this.ltrHead;
    }

    public void setLtrHead(String ltrHead) {
        this.ltrHead = ltrHead;
    }

    @Column(name = "`watchout`", nullable = false, length = 2147483647)
    public String getWatchout() {
        return this.watchout;
    }

    public void setWatchout(String watchout) {
        this.watchout = watchout;
    }

    @Column(name = "`indivinvcs`", nullable = false)
    public boolean isIndivinvcs() {
        return this.indivinvcs;
    }

    public void setIndivinvcs(boolean indivinvcs) {
        this.indivinvcs = indivinvcs;
    }

    @Column(name = "`status`", nullable = false, length = 20)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "`nocrcards`", nullable = false)
    public boolean isNocrcards() {
        return this.nocrcards;
    }

    public void setNocrcards(boolean nocrcards) {
        this.nocrcards = nocrcards;
    }

    @Column(name = "`abn`", nullable = false, length = 15)
    public String getAbn() {
        return this.abn;
    }

    public void setAbn(String abn) {
        this.abn = abn;
    }

    @Column(name = "`email`", nullable = false, length = 49)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "`feeposspec`", nullable = false, scale = 0, precision = 2)
    public byte getFeeposspec() {
        return this.feeposspec;
    }

    public void setFeeposspec(byte feeposspec) {
        this.feeposspec = feeposspec;
    }

    @Column(name = "`prfcomunic`", nullable = false, length = 10)
    public String getPrfcomunic() {
        return this.prfcomunic;
    }

    public void setPrfcomunic(String prfcomunic) {
        this.prfcomunic = prfcomunic;
    }

    @Column(name = "`ok2email`", nullable = false)
    public boolean isOk2email() {
        return this.ok2email;
    }

    public void setOk2email(boolean ok2email) {
        this.ok2email = ok2email;
    }

    @Column(name = "`lastbachno`", nullable = false, length = 10)
    public String getLastbachno() {
        return this.lastbachno;
    }

    public void setLastbachno(String lastbachno) {
        this.lastbachno = lastbachno;
    }

    @Column(name = "`lasttrnsno`", nullable = false, length = 3)
    public String getLasttrnsno() {
        return this.lasttrnsno;
    }

    public void setLasttrnsno(String lasttrnsno) {
        this.lasttrnsno = lasttrnsno;
    }

    @Column(name = "`hiccustno`", nullable = false, length = 10)
    public String getHiccustno() {
        return this.hiccustno;
    }

    public void setHiccustno(String hiccustno) {
        this.hiccustno = hiccustno;
    }

    @Column(name = "`noautoupdt`", nullable = false)
    public boolean isNoautoupdt() {
        return this.noautoupdt;
    }

    public void setNoautoupdt(boolean noautoupdt) {
        this.noautoupdt = noautoupdt;
    }

    @Column(name = "`nostmttill`", nullable = false)
    public LocalDateTime getNostmttill() {
        return this.nostmttill;
    }

    public void setNostmttill(LocalDateTime nostmttill) {
        this.nostmttill = nostmttill;
    }

    @Column(name = "`nostmtresn`", nullable = false, length = 35)
    public String getNostmtresn() {
        return this.nostmtresn;
    }

    public void setNostmtresn(String nostmtresn) {
        this.nostmtresn = nostmtresn;
    }

    @Column(name = "`acdob`", nullable = false)
    public LocalDateTime getAcdob() {
        return this.acdob;
    }

    public void setAcdob(LocalDateTime acdob) {
        this.acdob = acdob;
    }

    @Column(name = "`acsurname`", nullable = false, length = 25)
    public String getAcsurname() {
        return this.acsurname;
    }

    public void setAcsurname(String acsurname) {
        this.acsurname = acsurname;
    }

    @Column(name = "`acgivennme`", nullable = false, length = 20)
    public String getAcgivennme() {
        return this.acgivennme;
    }

    public void setAcgivennme(String acgivennme) {
        this.acgivennme = acgivennme;
    }

    @Column(name = "`actitle`", nullable = false, length = 10)
    public String getActitle() {
        return this.actitle;
    }

    public void setActitle(String actitle) {
        this.actitle = actitle;
    }

    @Column(name = "`acoth_ref1`", nullable = false, length = 12)
    public String getAcothRef1() {
        return this.acothRef1;
    }

    public void setAcothRef1(String acothRef1) {
        this.acothRef1 = acothRef1;
    }

    @Column(name = "`acoth_ref2`", nullable = false, length = 2)
    public String getAcothRef2() {
        return this.acothRef2;
    }

    public void setAcothRef2(String acothRef2) {
        this.acothRef2 = acothRef2;
    }

    @Column(name = "`bilin_agnt`", nullable = false)
    public boolean isBilinAgnt() {
        return this.bilinAgnt;
    }

    public void setBilinAgnt(boolean bilinAgnt) {
        this.bilinAgnt = bilinAgnt;
    }

    @Column(name = "`mid`", nullable = false, length = 10)
    public String getMid() {
        return this.mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        final Account account = (Account) o;
        return Objects.equals(getAccountno(), account.getAccountno());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountno());
    }
}