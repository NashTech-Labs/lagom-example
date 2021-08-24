package com.knoldus.hello.impl

import com.knoldus.hello.api.HelloService
import com.lightbend.lagom.scaladsl.akka.discovery.AkkaDiscoveryComponents
import com.lightbend.lagom.scaladsl.api.{Descriptor, ServiceLocator}
import com.lightbend.lagom.scaladsl.server._
import com.softwaremill.macwire._
import play.api.libs.ws.ahc.AhcWSComponents



class HelloServiceLoader extends LagomApplicationLoader {

  override def load(context: LagomApplicationContext): LagomApplication = {
    new HelloServiceApplication(context) with AkkaDiscoveryComponents
  }
  override def loadDevMode(context: LagomApplicationContext): LagomApplication = {
    new HelloServiceApplication(context)  {
      override def serviceLocator: ServiceLocator = ServiceLocator.NoServiceLocator
    }
  }
  override def describeService: Option[Descriptor] = Some(readDescriptor[HelloService])

}

abstract class HelloServiceApplication(context: LagomApplicationContext)
  extends LagomApplication(context)
  with AhcWSComponents {
  override lazy val lagomServer: LagomServer = serverFor[HelloService](wire[HelloServiceImpl])
}
