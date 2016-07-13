package api

import com.lightbend.lagom.javadsl.api.Service.named
import akka.NotUsed
import com.lightbend.lagom.javadsl.api.Descriptor
import com.lightbend.lagom.javadsl.api.Service
import com.lightbend.lagom.javadsl.api.ServiceCall
import com.lightbend.lagom.javadsl.api.transport.Method

import com.lightbend.lagom.javadsl.api.ScalaService._


trait HelloWorldService extends Service {


  def hello(id: String): ServiceCall[NotUsed, String]

  def descriptor: Descriptor = {
    named("helloservice").withCalls(
      restCall(Method.GET, "/api/hello/:id", hello _)).withAutoAcl(true)
  }
}

