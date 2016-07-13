package impl

import api.HelloWorldService
import com.google.inject.AbstractModule
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport


class HelloWorldServiceModule extends AbstractModule with ServiceGuiceSupport {
  override def configure(): Unit = bindServices(serviceBinding(classOf[HelloWorldService], classOf[HelloWorldServiceImpl]))
}
