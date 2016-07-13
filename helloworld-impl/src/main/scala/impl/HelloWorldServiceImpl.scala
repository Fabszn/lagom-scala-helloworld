package impl


import javax.inject.Inject

import com.lightbend.lagom.javadsl.api.ServiceCall
import akka.Done
import akka.NotUsed
import api.HelloWorldService

import scala.concurrent.{ExecutionContext, Future}


class HelloWorldServiceImpl @Inject()()(implicit ex: ExecutionContext) extends HelloWorldService {

  // Needed to convert some Scala types to Java
  import converter.ServiceCallConverter._
  override def hello(id: String): ServiceCall[NotUsed, String] = {rew => Future.successful("Hello " + id)}
}
