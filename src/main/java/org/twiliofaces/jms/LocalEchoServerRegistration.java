package org.twiliofaces.jms;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.local.DefaultLocalServerChannelFactory;
import org.jboss.netty.channel.local.LocalAddress;

@Singleton
@Startup
public class LocalEchoServerRegistration
{
   private final ChannelFactory factory = new DefaultLocalServerChannelFactory();
   private volatile Channel serverChannel;

   @PostConstruct
   public void start()
   {
      ServerBootstrap serverBootstrap = new ServerBootstrap(factory);
      // EchoServerHandler handler = new EchoServerHandler();
      Echo2ServerHandler handler = new Echo2ServerHandler();
      serverBootstrap.getPipeline().addLast("handler", handler);

      // Note that "myLocalServer" is the endpoint which was specified in web.xml.
      System.out.println("try to connect.. " + System.getenv("OPENSHIFT_JBOSSAS_IP"));
      serverChannel = serverBootstrap.bind(new LocalAddress("0.0.0.0"));
   }

   @PreDestroy
   public void stop()
   {
      serverChannel.close();
   }

}
