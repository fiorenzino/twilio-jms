package org.twiliofaces.jms;

public class SmsUtils
{
   public static SMSMessage fromString(String params)
   {
      SMSMessage smsMessage = new SMSMessage();
      String[] parts = params.split("&");
      for (String part : parts)
      {
         String[] pairs = part.split("=");
         valorize(smsMessage, pairs);
      }
      return smsMessage;
   }

   private static void valorize(SMSMessage smsMessage, String[] pairs)
   {
      String key = pairs[0];
      String value = pairs[1];
      if ("SmsSid".equals(key))
      {
         smsMessage.setSmsSid(value);
      }
      else if ("AccountSid".equals(key))
      {
         smsMessage.setAccountSid(value);
      }
      else if ("From".equals(key))
      {
         smsMessage.setFrom(value);
      }
      else if ("To".equals(key))
      {
         smsMessage.setTo(value);
      }
      else if ("Body".equals(key))
      {
         smsMessage.setBody(value);
      }
      else if ("FromCity".equals(key))
      {
         smsMessage.setFromCity(value);
      }
      else if ("FromState".equals(key))
      {
         smsMessage.setFromState(value);
      }
      else if ("FromZip".equals(key))
      {
         smsMessage.setFromZip(value);
      }
      else if ("FromCountry".equals(key))
      {
         smsMessage.setFromCountry(value);
      }
      else if ("ToCity".equals(key))
      {
         smsMessage.setToCity(value);
      }
      else if ("ToState".equals(key))
      {
         smsMessage.setToState(value);
      }
      else if ("ToZip".equals(key))
      {
         smsMessage.setToZip(value);
      }
      else if ("ToCountry".equals(key))
      {
         smsMessage.setToCountry(value);
      }
   }

   public static void main(String[] args)
   {
      String params = "SmsSid=value1&AccountSid=val2";
      System.out.println(fromString(params));
   }
}
