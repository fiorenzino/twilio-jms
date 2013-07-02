package org.twiliofaces.jms;

import java.nio.charset.Charset;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class EchoServerHandler extends SimpleChannelHandler
{

   @Override
   public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
   {
      ChannelBuffer buffer = (ChannelBuffer) e.getMessage();
      StringBuilder strBuffer = new StringBuilder();

      while (buffer.readable())
      {
         strBuffer.append((char) buffer.readByte());
      }

      String terms = strBuffer.toString();
      System.out.println(terms);
      System.out.flush();
      // ChannelBuffer channelNew = ChannelBuffers.copiedBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>  " +
      // "<Response> " +
      // "    <Sms>Hello World!</Sms>" +
      // "    <Redirect>http://api.twilio.com/sms/welcome</Redirect>" +
      // "</Response>" + "\n", Charset.defaultCharset());
      // channel.write(channelNew);
   }

   @Override
   public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
   {
      e.getCause().printStackTrace();

      Channel ch = e.getChannel();
      ch.close();
   }
}
