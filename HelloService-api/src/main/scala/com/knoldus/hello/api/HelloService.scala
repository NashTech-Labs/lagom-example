package com.knoldus.hello.api

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.transport.Method.GET
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}


trait HelloService extends Service{

  def sayHello(userName: String) : ServiceCall[NotUsed,String]

  override def descriptor: Descriptor = {
    import Service._
    named("HelloService")
      .withCalls(
        restCall(GET,"/api/hello/:name", sayHello _)
      )
      .withAutoAcl(true)
  }
}
