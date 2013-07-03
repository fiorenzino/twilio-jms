package org.twiliofaces.jms;

import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;

public class Echo2ServerHandler extends SimpleChannelUpstreamHandler
{

   private static final Logger logger = Logger.getLogger(
            EchoServerHandler.class.getName());

   private final AtomicLong transferredBytes = new AtomicLong();

   public long getTransferredBytes()
   {
      return transferredBytes.get();
   }

   @Override
   public void messageReceived(
            ChannelHandlerContext ctx, MessageEvent e)
   {
      // Send back the received message to the remote peer.
      ChannelBuffer buffer = (ChannelBuffer) e.getMessage();
      transferredBytes.addAndGet(buffer.readableBytes());

      // e.getChannel().write(e.getMessage());
      StringBuilder strBuffer = new StringBuilder();

      while (buffer.readable())
      {
         strBuffer.append((char) buffer.readByte());
      }

      String terms = strBuffer.toString();

      System.out.println(terms);

      ChannelBuffer channelNew = ChannelBuffers.copiedBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>  " +
               "<Response> " +
               "    <Sms>Hello World!</Sms>" +
               "    <Redirect>http://api.twilio.com/sms/welcome</Redirect>" +
               "</Response>" + "\n", Charset.defaultCharset());
      e.getChannel().write(channelNew);
   }

   @Override
   public void exceptionCaught(
            ChannelHandlerContext ctx, ExceptionEvent e)
   {
      // Close the connection when an exception is raised.
      logger.log(
               Level.WARNING,
               "Unexpected exception from downstream.",
               e.getCause());
      e.getChannel().close();
   }
}
