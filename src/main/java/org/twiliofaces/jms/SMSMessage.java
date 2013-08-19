package org.twiliofaces.jms;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SMSMessage implements Serializable
{

   private String smsSid;
   private String accountSid;
   private String from;
   private String to;
   private String body;

   private String fromCity;
   private String fromState;
   private String fromZip;
   private String fromCountry;
   private String toCity;
   private String toState;
   private String toZip;
   private String toCountry;

   public SMSMessage()
   {
   }

   public SMSMessage(String smsSid, String accountSid, String from, String to, String body, String fromCity,
            String fromState, String fromZip, String fromCountry, String toCity, String toState, String toZip,
            String toCountry)
   {
      this.smsSid = smsSid;
      this.accountSid = accountSid;
      this.from = from;
      this.to = to;
      this.body = body;
      this.fromCity = fromCity;
      this.fromState = fromState;
      this.fromZip = fromZip;
      this.fromCountry = fromCountry;
      this.toCity = toCity;
      this.toState = toState;
      this.toZip = toZip;
      this.toCountry = toCountry;
   }

   public String getSmsSid()
   {
      return smsSid;
   }

   public void setSmsSid(String smsSid)
   {
      this.smsSid = smsSid;
   }

   public String getAccountSid()
   {
      return accountSid;
   }

   public void setAccountSid(String accountSid)
   {
      this.accountSid = accountSid;
   }

   public String getFrom()
   {
      return from;
   }

   public void setFrom(String from)
   {
      this.from = from;
   }

   public String getTo()
   {
      return to;
   }

   public void setTo(String to)
   {
      this.to = to;
   }

   public String getBody()
   {
      return body;
   }

   public void setBody(String body)
   {
      this.body = body;
   }

   public String getFromCity()
   {
      return fromCity;
   }

   public void setFromCity(String fromCity)
   {
      this.fromCity = fromCity;
   }

   public String getFromState()
   {
      return fromState;
   }

   public void setFromState(String fromState)
   {
      this.fromState = fromState;
   }

   public String getFromZip()
   {
      return fromZip;
   }

   public void setFromZip(String fromZip)
   {
      this.fromZip = fromZip;
   }

   public String getFromCountry()
   {
      return fromCountry;
   }

   public void setFromCountry(String fromCountry)
   {
      this.fromCountry = fromCountry;
   }

   public String getToCity()
   {
      return toCity;
   }

   public void setToCity(String toCity)
   {
      this.toCity = toCity;
   }

   public String getToState()
   {
      return toState;
   }

   public void setToState(String toState)
   {
      this.toState = toState;
   }

   public String getToZip()
   {
      return toZip;
   }

   public void setToZip(String toZip)
   {
      this.toZip = toZip;
   }

   public String getToCountry()
   {
      return toCountry;
   }

   public void setToCountry(String toCountry)
   {
      this.toCountry = toCountry;
   }

   @Override
   public String toString()
   {
      return "SMSMessage [smsSid=" + smsSid + ", accountSid=" + accountSid + ", from=" + from + ", to=" + to
               + ", body=" + body + ", fromCity=" + fromCity + ", fromState=" + fromState + ", fromZip=" + fromZip
               + ", fromCountry=" + fromCountry + ", toCity=" + toCity + ", toState=" + toState + ", toZip=" + toZip
               + ", toCountry=" + toCountry + "]";
   }

}