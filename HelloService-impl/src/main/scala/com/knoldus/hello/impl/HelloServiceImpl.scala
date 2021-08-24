package com.knoldus.hello.impl

import akka.NotUsed
import com.knoldus.hello.api.HelloService
import com.lightbend.lagom.scaladsl.api.ServiceCall

import scala.concurrent.{ExecutionContext, Future}

class HelloServiceImpl()(implicit ec: ExecutionContext)
  extends HelloService {
  override def sayHello(userName: String): ServiceCall[NotUsed, String] = ServiceCall{
    _ =>
      Future.successful {
        s"Hello! $userName from Lagom service"
      }
  }
}

